package com.activity.sec10.util.credential;

import com.activity.common.constants.Constants;
import io.grpc.CallCredentials;
import io.grpc.Metadata;

import java.util.concurrent.Executor;

public class UserSessionToken extends CallCredentials {

    private final String jwtToken;
    private static final String TOKEN_FORMAT ="%s %s";

    public UserSessionToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    @Override
    public void applyRequestMetadata(RequestInfo requestInfo,
                                     Executor executor,
                                     MetadataApplier metadataApplier) {

       /* Metadata metadata = new Metadata();
        metadata.put(
                Constants.UESR_TOKEN_KEY,
                TOKEN_FORMAT.formatted(Constants.BEARER, jwtToken));
        metadataApplier.apply(metadata);*/

        executor.execute(() -> {
            Metadata metadata = new Metadata();
            metadata.put(
                    Constants.UESR_TOKEN_KEY,
                    TOKEN_FORMAT.formatted(Constants.BEARER, jwtToken));
            metadataApplier.apply(metadata);
        }); // This is non blocking
    }
}
