package com.activity.sec09.util.interceptors;

import io.grpc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiKeyAuthenticationServerSide implements ServerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(ApiKeyAuthenticationServerSide.class);


    private static final Metadata.Key<String> KEY =
            Metadata.Key.of("api-key", Metadata.ASCII_STRING_MARSHALLER);

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT,
            RespT> serverCall, Metadata metadata,
            ServerCallHandler<ReqT, RespT> serverCallHandler) {
        log.info("Interceptor invoked");

        if (metadata.containsKey(KEY) && metadata.get(KEY).equals("client-secrete")) {
            return serverCallHandler.startCall(serverCall, metadata);
        }
        serverCall.close(
                Status.UNAUTHENTICATED.withDescription("Wrong Creds"),
                metadata
        );
        return new ServerCall.Listener<ReqT>() {

        };
    }
}
