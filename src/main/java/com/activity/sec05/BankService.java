package com.activity.sec05;

import com.activity.common.util.TransferRequestHandler;
import com.activity.sec05.repo.AccountRepo;
import com.google.common.util.concurrent.Uninterruptibles;
import com.google.protobuf.Empty;
import com.models.sec05.*;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BankService extends BankServiceGrpc.BankServiceImplBase {
    private static final Logger log = LoggerFactory.getLogger(BankService.class);

    @Override
    public void getAccountBalance(BalanceCheckReq request, StreamObserver<BalanceCheckResp> responseObserver) {
        int accNum = request.getAccountNumber();
        int balance = AccountRepo.getBalance(accNum);
        BalanceCheckResp resp = BalanceCheckResp.newBuilder().setAccountNumber(accNum)
                .setBalance(balance)
                .build();
        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }

    @Override
    public void getAllAccounts(Empty request, StreamObserver<AllAccountsResp> responseObserver) {
        List<BalanceCheckResp> list = AccountRepo.getAllAccounts()
                        .entrySet()
                                .stream()
                                .map(entry -> BalanceCheckResp.newBuilder()
                                        .setAccountNumber(entry.getKey())
                                        .setBalance(entry.getValue())
                                        .build())
                                        .toList();
        AllAccountsResp.Builder builder = AllAccountsResp.newBuilder();
        builder.addAllAccounts(list);
        AllAccountsResp allAccountResp = builder.build();
        responseObserver.onNext(allAccountResp);
        responseObserver.onCompleted();
    }

    @Override
    public void withdraw(WithdrawReq request, StreamObserver<Money> responseObserver) {
        int accNum = request.getAccountNumber();
        int balance = AccountRepo.getBalance(accNum);
        int amount = request.getAmount();
        log.info("Withdraw Request for Account {} of amount {} with balance {}", accNum, amount, balance);
        if (balance < amount) {
            responseObserver.onError(new RuntimeException("Insufficient balance"));
            return;
        }

        for (int i = 0; i < amount / 10; i++) {
            Money money = Money.newBuilder().setAmount(10).build();
            responseObserver.onNext(money);
            log.info("Money Sent{}: ", money);
            AccountRepo.updateBalance(accNum, money.getAmount());
            Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        }
        responseObserver.onCompleted();
    }
    // Client Streaming
    //========================================================================================================
    @Override
    public StreamObserver<DepositRequest> deposit(StreamObserver<BalanceCheckResp> responseObserver)  {
        final int[] accountNumber = {0};
        return new StreamObserver<DepositRequest>() {

            @Override
            public void onNext(DepositRequest depositRequest) {
                switch (depositRequest.getRequestCase()) {
                    case ACCOUNT_NUMBER -> {
                        log.info("Received Account Number: {}", depositRequest.getAccountNumber());
                        accountNumber[0] = depositRequest.getAccountNumber();
                        break;
                    }
                    case MONEY -> {
                        int amount = depositRequest.getMoney().getAmount();
                        AccountRepo.updateBalance(accountNumber[0], -amount); // -ve so that it gets added since method has -ve too
                        log.info("Deposited: {}", amount);
                    }
                }
            }

            @Override
            public void onError(Throwable throwable) {
                log.error(throwable.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onNext(BalanceCheckResp.newBuilder()
                        .setAccountNumber(1)
                        .setBalance(AccountRepo.getBalance(accountNumber[0]))
                        .build());
                responseObserver.onCompleted();
            }
        };
    }
    // Bi-Directional Streaming
    //========================================================================================================
    @Override
    public StreamObserver<TransferReq> transfer(StreamObserver<TransferResp> responseObserver) {
        return new TransferRequestHandler(responseObserver);
    }
}
