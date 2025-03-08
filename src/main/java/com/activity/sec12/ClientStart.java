package com.activity.sec12;

import com.activity.sec11.util.common.GrpcServer;
import com.activity.sec11.util.credential.UserSessionToken;
import com.activity.sec12.Util.SSLUtil;
import com.models.sec08.AccountBalance;
import com.models.sec08.BalanceCheckRequest;
import com.models.sec08.TransactionServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientStart {
    private static final Logger log = LoggerFactory.getLogger(ClientStart.class);


    public static void main(String args[]) {
        SSLUtil sslUtil = new SSLUtil();
        ManagedChannel channel =  NettyChannelBuilder.forAddress("localhost", 6565)
               // .usePlaintext() // request will go but will not be authenticated as no certificate
                .sslContext(sslUtil.clientSSLContext())
                .build();
        TransactionServiceGrpc.TransactionServiceBlockingStub stub =
                TransactionServiceGrpc.newBlockingStub(channel);
        BalanceCheckRequest balanceCheckRequest = BalanceCheckRequest.newBuilder()
                .setAccountNumber(10)
                .build();

        try {
            AccountBalance response = stub.
                    withCallCredentials(new UserSessionToken("user-token-1")).
                    withCompression("gzip"). // with Gzip Compression client side
                            checkBalance(balanceCheckRequest);
            log.info("Account Balance {}", response);
        } catch (StatusRuntimeException e) {
            log.error("Got exception for balance check: {}, code {} ", e.getStatus(), e.getStatus().getCode());
            // Trailer from statuses. Will have to give correct key
            //log.error("Trailer: {} ", e.getTrailers().get(Key), e.getStatus().getCode());
            log.error("Deadline ", e.getStatus().getCode());
            // for above Status.Code.DEADLINE_EXCEEDED
        }
        channel.shutdownNow();
    }
}
