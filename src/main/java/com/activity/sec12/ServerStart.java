package com.activity.sec12;

import com.activity.sec11.BankTransactionService;
import com.activity.sec11.util.common.GrpcServer;
import com.activity.sec12.Util.SSLUtil;

public class ServerStart {

    // CachedThreadPool is default   forPort(...).executor(...).build()
    // don't use direct Executor as it will have fixed size
    // It java 21 can usr newVirtualThreadPerTaskExecutor
    public static void main(String args[]) {
        SSLUtil util = new SSLUtil();

        GrpcServer server = GrpcServer.create(6565, b -> {
            b.addService(new BankTransactionService())
                    .sslContext(util.serverSSLContext());
        });
        server.start().await();
    }
}
