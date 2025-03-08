package com.activity.common.util;

import com.models.sec05.BalanceCheckResp;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ResponseObserverDeposit implements StreamObserver<BalanceCheckResp> {
    private static final Logger log = LoggerFactory.getLogger(ResponseObserverDeposit.class);
    public List<BalanceCheckResp> balanceCheckRespList = new ArrayList<>();
    CountDownLatch latch = new CountDownLatch(1);

    @Override
    public void onNext(BalanceCheckResp balanceCheckResp) {
        log.info("Balance is >> " + balanceCheckResp.getBalance());
        balanceCheckRespList.add(balanceCheckResp);

    }

    @Override
    public void onError(Throwable throwable) {
        log.info(throwable.getMessage());
        latch.countDown();
    }

    @Override
    public void onCompleted() {
        log.info("Server is done");
        latch.countDown();
    }

    public void await() throws InterruptedException {
            latch.await(5, java.util.concurrent.TimeUnit.SECONDS);

    }
}
