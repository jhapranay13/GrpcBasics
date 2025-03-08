package com.activity.sec11.util.common;


import com.activity.sec11.BankTransactionService;

// For Context
public class GrpcServerStart {
    public static void main(String args[]) {
        GrpcServer.create(new BankTransactionService()).start().await();
    }
}
