package com.activity.sec06;


import com.models.sec06.FlowControlServiceGrpc;
import com.models.sec06.Output;
import com.models.sec06.RequestSize;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.IntStream;

public class FlowControlService extends FlowControlServiceGrpc.FlowControlServiceImplBase {
    private static final Logger log = LoggerFactory.getLogger(FlowControlService.class);

    @Override
    public StreamObserver<RequestSize> getMessage(StreamObserver<Output> responseObserver) {
        return new RequestHandler(responseObserver);
    }

    private static class RequestHandler implements StreamObserver<RequestSize> {
        private final StreamObserver<Output> responseObserver;
        private Integer emitter = 0;

        public RequestHandler(StreamObserver<Output> responseObserver) {
            this.responseObserver = responseObserver;
        }

        @Override
        public void onNext(RequestSize requestSize) {
            IntStream.rangeClosed(emitter + 1, 100)
                    .limit(requestSize.getSize())
                    .forEach(i -> {
                        log.info("Emitting: " + i);
                        Output output = Output.newBuilder()
                                .setValue(i)
                                .build();
                        responseObserver.onNext(output);
                    });
            emitter += requestSize.getSize();

            if (emitter >= 100) {
                responseObserver.onCompleted();
            }
        }

        @Override
        public void onError(Throwable throwable) {
            log.error("Error occurred in RequestHandler: " + throwable.getMessage());
        }

        @Override
        public void onCompleted() {
            log.info("RequestHandler completed");
            responseObserver.onCompleted();
        }
    }
}
