package com.activity.common.constants;

import io.grpc.Context;
import io.grpc.Metadata;

public class Constants {

    public static final Metadata.Key<String> API_KEY =
            Metadata.Key.of("api-key", Metadata.ASCII_STRING_MARSHALLER);

    public static final Metadata.Key<String> UESR_TOKEN_KEY =
            Metadata.Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER);

    public static final String BEARER = "Bearer";
    /*jwt token   Authorization: Bearer uhfvuirhe98y3489yfjvvnvrv*/

    public static final Context.Key<String> CTX_KEY =
            Context.key("user-role");
}
