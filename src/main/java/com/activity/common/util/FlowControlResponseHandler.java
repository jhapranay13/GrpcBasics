package com.activity.common.util;

import com.google.common.util.concurrent.Uninterruptibles;
import com.models.sec06.Output;
import com.models.sec06.RequestSize;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class FlowControlResponseHandler implements StreamObserver<Output> {
    private static final Logger log = LoggerFactory.getLogger(FlowControlResponseHandler.class);
    CountDownLatch latch = new CountDownLatch(1);
    // in order to make stream interactive, we need to have a reference to the request observer
    StreamObserver<RequestSize> reqObserver;
    private int size;

    @Override
    public void onNext(Output output) {
        this.size--;
        this.process(output);

        if (size == 0) {
            log.info("=============================");
            this.request(3);
        }
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onCompleted() {
        this.reqObserver.onCompleted();
        log.info("Server is done");
        latch.countDown();
    }

    public void setRequestObserver(StreamObserver<RequestSize> reqObserver) {
        this.reqObserver = reqObserver;
    }

    private void request(int size) {
        log.info("requesting: {}", size);
        this.size = size;
        this.reqObserver.onNext(RequestSize.newBuilder().setSize(size).build());
    }

    private void process(Output output) {
        log.info("Processing: {}", output);
        Uninterruptibles.sleepUninterruptibly(
                ThreadLocalRandom.current().nextInt(50, 200),
                TimeUnit.MILLISECONDS);
    }

    public void await() throws InterruptedException {
        latch.await();
    }

    public void start() {
        this.request(3);
    }
}
