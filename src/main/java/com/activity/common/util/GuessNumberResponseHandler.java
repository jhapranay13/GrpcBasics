package com.activity.common.util;

import com.activity.sec07.GuessNumberService;
import com.models.sec07.GuessRequest;
import com.models.sec07.GuessResponse;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

public class GuessNumberResponseHandler implements StreamObserver<GuessResponse> {
    private static final Logger log = LoggerFactory.getLogger(GuessNumberService.class);
    StreamObserver<GuessRequest> requestObserver;
    CountDownLatch latch = new CountDownLatch(1);
    private int number;
    int lo = 0;
    int hi = 99;

    @Override
    public void onNext(GuessResponse guessResponse) {
        log.info("Response received: " + guessResponse.getResult());
        log.info("Attempts: " + guessResponse.getAttempts());
        switch (guessResponse.getResult()) {
            case CORRECT: {
                log.info("Correct guess");
                requestObserver.onCompleted();
                latch.countDown();
                break;
            }
            case TOO_HIGH: {
                log.info("Too high");
                hi = number - 1;
                send();
                break;
            }
            case TOO_LOW: {
                log.info("Too low");
                lo = number + 1;
                send();
                break;
            }
        }
    }

    @Override
    public void onError(Throwable throwable) {
        latch.countDown();
        log.error("Error occurred in GuessNumberResponseHandler: " + throwable.getMessage());
    }

    @Override
    public void onCompleted() {
        latch.countDown();
        log.info("GuessNumberResponseHandler completed");
    }

    public void setRequestObserver(StreamObserver<GuessRequest> requestObserver) {
        this.requestObserver = requestObserver;
    }

    public void start() {
        send();
    }

    private void send() {
        number =  lo + (hi - lo) / 2;
        log.info("Sending guess: " + number);
        requestObserver.onNext(GuessRequest.newBuilder().setGuess(number).build());
    }

    public void await() throws InterruptedException {
        latch.await();
    }
}
