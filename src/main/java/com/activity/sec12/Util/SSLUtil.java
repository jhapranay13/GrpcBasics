package com.activity.sec12.Util;

import io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.shaded.io.netty.handler.ssl.SslContext;
import io.grpc.netty.shaded.io.netty.handler.ssl.SslContextBuilder;
import io.grpc.netty.shaded.io.netty.internal.tcnative.SSLContext;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;
import java.nio.file.Path;
import java.security.KeyStore;
import java.util.concurrent.Callable;

public class SSLUtil {

    private static final Path KEY_STORE =
            Path.of("src/main/java/com/activity/sec12/grpc.keystore.jks");
    private static final Path TRUST_STORE =
            Path.of("src/main/java/com/activity/sec12/grpc.truststore.jks");
    private static final char[] PASSWORD = "changeit".toCharArray();

    public SslContext serverSSLContext() {
        return executionHandler(() -> {
             return GrpcSslContexts.configure(
                    SslContextBuilder.forServer(getKeyManagerFactory())).build();
        });
    }

    public SslContext clientSSLContext() {
        return executionHandler(() -> {
            return GrpcSslContexts.configure(
                    SslContextBuilder.forClient().trustManager(getTrustManagerFactory())).build();
        });
    }

    protected KeyManagerFactory getKeyManagerFactory() {
        return executionHandler(() -> {
            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            KeyStore keystore = KeyStore.getInstance(KEY_STORE.toFile(), PASSWORD);
            kmf.init(keystore, PASSWORD);
            return kmf;
        });
    }

    protected TrustManagerFactory getTrustManagerFactory() {
        return executionHandler(() -> {
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            KeyStore keystore = KeyStore.getInstance(TRUST_STORE.toFile(), PASSWORD);
            tmf.init(keystore);
            return tmf;
        });
    }

    protected <T> T executionHandler(Callable<T> callable) {

        try {
            return callable.call();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
