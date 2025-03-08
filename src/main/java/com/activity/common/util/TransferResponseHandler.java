package com.activity.common.util;

import com.models.sec05.TransferResp;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class TransferResponseHandler implements StreamObserver<TransferResp> {
    private static final Logger log = LoggerFactory.getLogger(TransferResponseHandler.class);
    public List<TransferResp> list = new ArrayList<>();
    CountDownLatch latch = new CountDownLatch(1);

    @Override
    public void onNext(TransferResp transferResp) {
        log.info("Transfer Status: " + transferResp.getStatus());
        log.info("From Account: " + transferResp.getFrom());
        log.info("To Account: " + transferResp.getTo());
        list.add(transferResp);
    }

    @Override
    public void onError(Throwable throwable) {
        log.info("Error occurred in TransferRequestHandler: " + throwable.getMessage());
        latch.countDown();

    }

    @Override
    public void onCompleted() {
        log.info("TransferRequestHandler completed");
        latch.countDown();
    }

    public void await() throws InterruptedException {
        latch.await(5, java.util.concurrent.TimeUnit.SECONDS);
    }
}
