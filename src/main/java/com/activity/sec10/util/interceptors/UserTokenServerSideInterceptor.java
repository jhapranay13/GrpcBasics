package com.activity.sec10.util.interceptors;

import com.activity.common.constants.Constants;
import io.grpc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.Set;

public class UserTokenServerSideInterceptor implements ServerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(UserTokenServerSideInterceptor.class);


    private static final Set<String> PRIME_SET = Set.of("user-token-1", "user-token-2");
    private static final Set<String> STANDARD_SET = Set.of("user-token-3", "user-token-4");

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT,
            RespT> serverCall, Metadata metadata,
            ServerCallHandler<ReqT, RespT> serverCallHandler) {
        String token = extractToken(metadata.get(Constants.UESR_TOKEN_KEY));
        log.info("Interceptor invoked with token {}", token);

        if (Objects.nonNull(token) && PRIME_SET.contains(token) ||
                STANDARD_SET.contains(token)) {
            // if it is streaming or not
            boolean isStreaming = serverCall.getMethodDescriptor().getType().clientSendsOneMessage();

            if (isStreaming || PRIME_SET.contains(token)) {
                return serverCallHandler.startCall(serverCall, metadata);
            }
        }
        serverCall.close(Status.UNAUTHENTICATED, metadata);
        return new ServerCall.Listener<ReqT>() {

        };
    }

    private String extractToken(String value) {
        return Objects.nonNull(value) && value.startsWith(Constants.BEARER) ?
                value.substring(Constants.BEARER.length()).trim() : null ;
    }
}
