package com.activity.common.util;

import com.activity.sec05.repo.AccountRepo;
import com.models.sec05.BalanceCheckResp;
import com.models.sec05.TransferReq;
import com.models.sec05.TransferResp;
import com.models.sec05.TransferStatus;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TransferRequestHandler implements StreamObserver<TransferReq> {
    private static final Logger log = LoggerFactory.getLogger(TransferRequestHandler.class);
    private final StreamObserver<TransferResp> responseObserver;

    public TransferRequestHandler(StreamObserver<TransferResp> responseObserver) {
        this.responseObserver = responseObserver;
    }

    @Override
    public void onNext(TransferReq transferReq) {
        log.info("Received Transfer Request for account: {}", transferReq.getFromAccount());
        TransferStatus status = transfer(transferReq);
        responseObserver.onNext(TransferResp.newBuilder()
                        .setStatus(status)
                        .setFrom(getBalanceCheckResp(transferReq.getFromAccount()))
                        .setTo(getBalanceCheckResp(transferReq.getToAccount()))
                .build());
    }

    @Override
    public void onError(Throwable throwable) {
        log.error("Error occurred in TransferRequestHandler: {}", throwable.getMessage());
    }

    @Override
    public void onCompleted() {
        log.info("TransferRequestHandler completed");
        responseObserver.onCompleted();
    }

    private TransferStatus transfer(TransferReq transferReq) {
        int fromAccount = transferReq.getFromAccount();
        int toAccount = transferReq.getToAccount();

        int amount = transferReq.getAmount();

        int fromBalance = AccountRepo.getBalance(fromAccount);
        int toBalance = AccountRepo.getBalance(toAccount);

        if (fromBalance < amount || fromAccount == toAccount) {
            return TransferStatus.REJECTED;
        }
        AccountRepo.updateBalance(fromAccount, amount);
        AccountRepo.updateBalance(toAccount, -amount);
        return TransferStatus.ACCEPTED;
    }

    private BalanceCheckResp getBalanceCheckResp(int accountNumber) {
        return BalanceCheckResp.newBuilder()
                .setAccountNumber(accountNumber)
                .setBalance(AccountRepo.getBalance(accountNumber))
                .build();
    }
}
