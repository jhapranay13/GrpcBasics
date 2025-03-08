package com.activity.sec09.util.common;


import com.models.sec08.AccountBalance;
import com.models.sec08.BalanceCheckRequest;
import com.models.sec08.TransactionServiceGrpc;
import io.grpc.*;
import io.grpc.stub.MetadataUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class GrpcClient {
    private static final Logger log = LoggerFactory.getLogger(GrpcClient.class);
    private static final Metadata.Key<String> KEY =
            Metadata.Key.of("api-key", Metadata.ASCII_STRING_MARSHALLER);

    public static void main(String args[]) throws InterruptedException {
        clientRequestSendWithInterceptor();
    }

    public static void clientRequestSendWithInterceptor() throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext()
                .intercept(MetadataUtils.newAttachHeadersInterceptor(getMetaData()))
                .build();
        BalanceCheckRequest balanceCheckRequest = BalanceCheckRequest.newBuilder()
                .setAccountNumber(10)
                .build();
        TransactionServiceGrpc.TransactionServiceBlockingStub stub = TransactionServiceGrpc.newBlockingStub(channel);

        try {
            AccountBalance response = stub.
                            withCompression("gzip"). // with Gzip Compression client side
                            withDeadline(Deadline.after(2, TimeUnit.SECONDS)). //This is for backoff
                            checkBalance(balanceCheckRequest);
            log.info("Account Balance {}", response);
        } catch (StatusRuntimeException e) {
            log.error("Got exception for balance check: {}, code {} ", e.getStatus(), e.getStatus().getCode());
            // Trailer from statuses. Will have to give correct key
            //log.error("Trailer: {} ", e.getTrailers().get(Key), e.getStatus().getCode());
            log.error("Deadline ", e.getStatus().getCode());
            // for above Status.Code.DEADLINE_EXCEEDED
        }
    }

    public static Metadata getMetaData() {
        Metadata metadata = new Metadata();
        metadata.put(KEY, "client-secret");
        return metadata;
    }
}
