package com.activity.common;

import com.activity.sec05.BankService;
import com.activity.sec06.FlowControlService;
import com.activity.sec07.GuessNumberService;
import com.activity.sec08.BankTransactionService;

public class GrpcServerStart {
    public static void main(String args[]) {
        GrpcServer.create(new BankService(),
                new FlowControlService(),
                new GuessNumberService(),
                new BankTransactionService()).start().await();
    }
}
