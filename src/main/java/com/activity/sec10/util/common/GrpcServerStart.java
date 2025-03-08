package com.activity.sec10.util.common;


import com.activity.sec10.BankTransactionService;

public class GrpcServerStart {
    public static void main(String args[]) {
        GrpcServer.create(new BankTransactionService()).start().await();
    }
}
