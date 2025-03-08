package com.activity.sec09.util.common;


import com.activity.sec09.BankTransactionService;

public class GrpcServerStart {
    public static void main(String args[]) {
        GrpcServer.create(new BankTransactionService()).start().await();
    }
}
