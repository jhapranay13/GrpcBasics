package com.activity.sec11;

import com.activity.common.constants.Constants;
import com.activity.sec08.repo.AccountRepo;
import com.activity.sec08.validation.RequestValidator;
import com.activity.sec11.util.common.GrpcServer;
import com.models.sec08.*;
import io.grpc.Context;
import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BankTransactionService extends TransactionServiceGrpc.TransactionServiceImplBase {
    private static final Logger log = LoggerFactory.getLogger(BankTransactionService.class);

    @Override
    public void checkBalance(BalanceCheckRequest request, StreamObserver<AccountBalance> responseObserver) {
       int account = request.getAccountNumber();
       int balance = AccountRepo.getBalance(account);
       AccountBalance accountBalance = AccountBalance.newBuilder().setAccountNumber(account)
               .setBalance(balance)
               .build();
        log.info("Context Value {}", Constants.CTX_KEY.get());
        responseObserver.onNext(accountBalance);
        responseObserver.onCompleted();
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
