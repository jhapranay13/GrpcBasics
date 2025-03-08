package com.activity.sec07;

import com.activity.common.util.FlowControlResponseHandler;
import com.google.common.util.concurrent.Uninterruptibles;
import com.models.sec07.GuessNumberGrpc;
import com.models.sec07.GuessRequest;
import com.models.sec07.GuessResponse;
import com.models.sec07.Result;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class GuessNumberService extends GuessNumberGrpc.GuessNumberImplBase {
    private static final Logger log = LoggerFactory.getLogger(GuessNumberService.class);

    @Override
    public StreamObserver<GuessRequest> guess(StreamObserver<GuessResponse> responseObserver) {
        return new StreamObserver<GuessRequest>() {
            private int attempts = 0;
            private int number = ThreadLocalRandom.current().nextInt(1, 100);

            @Override
            public void onNext(GuessRequest guessRequest) {
                log.info("Received guess: " + guessRequest.getGuess());
                log.info("Actual number: " + number);
                int guess = guessRequest.getGuess();
                Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);

                if (guess == number) {
                    log.info("Correct guess");
                    responseObserver.onNext(GuessResponse.newBuilder().setAttempts(++attempts).setResult(Result.CORRECT).build());
                    responseObserver.onCompleted();
                } else if (guess < number) {
                    log.info("Too low");
                    responseObserver.onNext(GuessResponse.newBuilder().setAttempts(++attempts).setResult(Result.TOO_LOW).build());
                } else {
                    log.info("Too high");
                    responseObserver.onNext(GuessResponse.newBuilder().setAttempts(++attempts).setResult(Result.TOO_HIGH).build());
                }
            }

            @Override
            public void onError(Throwable throwable) {
                log.error("Error occurred in GuessNumberService: " + throwable.getMessage());
            }

            @Override
            public void onCompleted() {
                log.info("GuessNumberService completed");
                responseObserver.onCompleted();
            }
        };
    }
}
