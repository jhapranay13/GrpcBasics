package com.activity.sec08;

import com.activity.sec08.repo.AccountRepo;
import com.activity.sec08.validation.RequestValidator;
import com.models.sec08.*;
import io.grpc.Status;
import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;

public class BankTransactionService extends TransactionServiceGrpc.TransactionServiceImplBase {

    @Override
    public void checkBalance(BalanceCheckRequest request, StreamObserver<AccountBalance> responseObserver) {
        RequestValidator.validateAccount(request.getAccountNumber())
                //.map(Status::asRuntimeException)  // When Satatus is returned commented when StatusException is returned
                .ifPresentOrElse(
                        responseObserver::onError,
                () -> sendAccountBalance(request,responseObserver)
                );
    }

    @Override
    public void withdraw(WithdrawalRequest request, StreamObserver<Money> responseObserver) {
       /* RequestValidator.validateAccount(request.getAccountNumber())
                .ifPresentOrElse(status -> responseObserver.onError(status.asRuntimeException()),
                        () -> RequestValidator.isAmountMultipleOfTen(request.getAmount())
                                .ifPresentOrElse(status -> responseObserver.onError(status.asRuntimeException()),
                                        () -> sendMoney(request, responseObserver)));
        */
        RequestValidator.validateAccount(request.getAccountNumber())
                .or(() -> RequestValidator.isAmountMultipleOfTen(request.getAmount()))
                .or(() -> RequestValidator.isSufficientFundsAvailable(request.getAmount(),AccountRepo.getBalance(request.getAccountNumber()) ))
                //.map(status -> status.asRuntimeException())
                .ifPresentOrElse(
                        responseObserver::onError,
                        () -> sendMoney(request, responseObserver)
                );
    }

    private void sendAccountBalance(BalanceCheckRequest request, StreamObserver<AccountBalance> responseObserver) {
        int accountNumber = request.getAccountNumber();
        int balance = AccountRepo.getBalance(accountNumber);
        AccountBalance accountBalance = AccountBalance.newBuilder()
                .setAccountNumber(accountNumber)
                .setBalance(balance)
                .build();
        // Server side compression enabled
        ((ServerCallStreamObserver<AccountBalance>) responseObserver).setCompression("gzip");

        responseObserver.onNext(accountBalance);
        responseObserver.onCompleted();
    }

    private void sendMoney(WithdrawalRequest request, StreamObserver<Money> responseObserver) {
        int accountNumber = request.getAccountNumber();
        int amount = request.getAmount();
        int balance = AccountRepo.getBalance(accountNumber);
        if (balance < amount) {
            responseObserver.onError(new RuntimeException("Insufficient balance"));
            return;
        }
        for (int i = 0; i < amount / 10; i++) {
            Money money = Money.newBuilder().setAmount(10).build();
            responseObserver.onNext(money);
            AccountRepo.updateBalance(accountNumber, 10);
        }
        responseObserver.onCompleted();
    }
}
