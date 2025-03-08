package com.activity.common;

import com.activity.common.util.*;
import com.activity.sec08.interceptor.GlobalDeadlineInterceptor;
import com.google.protobuf.Empty;
import com.models.sec05.*;
import com.models.sec06.FlowControlServiceGrpc;
import com.models.sec06.RequestSize;
import com.models.sec07.GuessNumberGrpc;
import com.models.sec07.GuessRequest;
import com.models.sec08.AccountBalance;
import com.models.sec08.BalanceCheckRequest;
import com.models.sec08.TransactionServiceGrpc;
import com.models.sec08.WithdrawalRequest;
import io.grpc.*;
import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Iterator;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class GrpcClient {
    private static final Logger log = LoggerFactory.getLogger(GrpcClient.class);

    public static void main(String args[]) throws InterruptedException {
        //checkBalanceSync(1);
        //checkBalanceAsync(1);
        // new Stub is the only one that handles all 4 communication patterns
        // blockingStub and Future stub only handle client and server and server streaming
        //Thread.sleep(Duration.ofSeconds(3).toMillis());
        //getAllAccountsSync();
        //getAllAccountsAsync();
        //withdrawSync(WithdrawReq.newBuilder().setAmount(70).setAccountNumber(1).build());
        //withdrawASync();
        //deposit();
        //transfer();
        //flowControl();
        //guessNumber();
        //validationGetBalance();
        //validationWithdraw();
        //validationGetBalanceWithGzip(); // For any other encoding Do
        // CompressiorRegistry.getOrDefaultInstance.register. This has to happen both client and server side
        //validationGetBalanceChangingExecutor();
        validationGetBalanceInterceptorsClientSide();
    }
    // Unary
    //========================================================================================================
    public static void checkBalanceSync(int accountNumber) {
        // It is lazily created. i.e when the first request is send and is thread safe
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext().build();
        BankServiceGrpc.BankServiceBlockingStub stub = BankServiceGrpc.newBlockingStub(channel);
        int balance = stub.getAccountBalance(BalanceCheckReq.newBuilder().setAccountNumber(1).build()).getBalance();
        log.info("Balance is {} ", balance);
    }

    public static void checkBalanceAsync(int accountNumber) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext().build();
        BankServiceGrpc.BankServiceStub stub = BankServiceGrpc.newStub(channel);
        stub.getAccountBalance(BalanceCheckReq
                .newBuilder()
                .setAccountNumber(1)
                .build(), new StreamObserver<BalanceCheckResp>() {

            @Override
            public void onNext(BalanceCheckResp balanceCheckResp) {
                log.info("Balance is {} ", balanceCheckResp.getBalance());
            }

            @Override
            public void onError(Throwable throwable) {
                log.error(throwable.getMessage());
            }

            @Override
            public void onCompleted() {
                log.info("Server is done");
            }
        });
    }


    public static void getAllAccountsSync() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext().build();
        BankServiceGrpc.BankServiceBlockingStub stub = BankServiceGrpc.newBlockingStub(channel);
        AllAccountsResp resp = stub.getAllAccounts(Empty.newBuilder().build());
        resp.getAccountsList().forEach(account -> log.info("Account Number: {} Balance: {}", account.getAccountNumber(), account.getBalance()));
    }

    public static void getAllAccountsAsync() throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext().build();
        BankServiceGrpc.BankServiceStub stub = BankServiceGrpc.newStub(channel);
        CountDownLatch latch = new CountDownLatch(1);
        stub.getAllAccounts(Empty.newBuilder().build(),
                new StreamObserver<AllAccountsResp>() {
                    @Override
                    public void onNext(AllAccountsResp allAccountsResp) {
                        allAccountsResp.getAccountsList().forEach(account -> log.info("Account Number Async: {} Balance: {}", account.getAccountNumber(), account.getBalance()));
                        latch.countDown();
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        log.error(throwable.getMessage());
                    }

                    @Override
                    public void onCompleted() {
                        log.info("Server is done");
                    }
                });
        latch.await();
    }
    // Server Streaming
    //====================================================================================================
    public static void withdrawSync(WithdrawReq request) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext().build();
        BankServiceGrpc.BankServiceBlockingStub stub = BankServiceGrpc.newBlockingStub(channel);
        Iterator<Money> resp = stub.withdraw(request);

        while(resp.hasNext()) {
            Money money = resp.next();
            log.info("Received: {}", money);
        }
    }

    public static void withdrawASync() throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext().build();
        BankServiceGrpc.BankServiceStub stub = BankServiceGrpc.newStub(channel);
        WithdrawReq request = WithdrawReq.newBuilder().setAmount(70).setAccountNumber(2).build();
        CountDownLatch latch = new CountDownLatch(1);
        stub.withdraw(request, new StreamObserver<Money>() {
            @Override
            public void onNext(Money money) {
                log.info("Received Async: {}", money);
            }

            @Override
            public void onError(Throwable throwable) {
                log.error(throwable.getMessage());
                latch.countDown();
            }

            @Override
            public void onCompleted() {
                log.info("Server is done");
                latch.countDown();
            }
        });
        latch.await();
    }
    // Client Streaming
    //====================================================================================================
    public static void deposit() throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext().build();
        BankServiceGrpc.BankServiceStub stub = BankServiceGrpc.newStub(channel);

        ResponseObserverDeposit responseObserver = new ResponseObserverDeposit();

        StreamObserver<DepositRequest> requestObserver = stub.deposit(responseObserver);
        requestObserver.onNext(DepositRequest.newBuilder().setAccountNumber(4).build());

        IntStream.rangeClosed(1, 10)
                .mapToObj(elem -> Money.newBuilder().setAmount(10).build())
                .map(elem -> DepositRequest.newBuilder().setMoney(elem).build())
                .forEach(requestObserver::onNext);

        requestObserver.onCompleted();
        responseObserver.await();

        log.info("Received deposit size: {}", responseObserver.balanceCheckRespList.size());
        log.info("Received deposit balance: {}", responseObserver.balanceCheckRespList.get(0).getBalance());
    }
    // Bi-Directional Streaming
    //====================================================================================================
    public static  void transfer() throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext().build();
        BankServiceGrpc.BankServiceStub stub = BankServiceGrpc.newStub(channel);
        TransferResponseHandler responseObserver = new TransferResponseHandler();


        StreamObserver<TransferReq> requestObserver = stub.transfer(responseObserver);;

        List<TransferReq> query = List.of(
                TransferReq.newBuilder().setFromAccount(3).setToAccount(1).setAmount(40).build(),
                TransferReq.newBuilder().setFromAccount(2).setToAccount(3).setAmount(40).build(),
                TransferReq.newBuilder().setFromAccount(4).setToAccount(5).setAmount(40).build(),
                TransferReq.newBuilder().setFromAccount(10).setToAccount(9).setAmount(40).build()
        );

        query.forEach(requestObserver::onNext);

        requestObserver.onCompleted();
        responseObserver.await();
        log.info("Received transfer size: {}", responseObserver.list.size());

        for (TransferResp resp : responseObserver.list) {
            log.info("Received transfer: {}", resp);
        }
    }
    //Flow Control
    //====================================================================================================
    public static void flowControl() throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext().build();
        FlowControlResponseHandler responseObserver = new FlowControlResponseHandler();
        FlowControlServiceGrpc.FlowControlServiceStub stub = FlowControlServiceGrpc.newStub(channel);
        StreamObserver<RequestSize> reqObserver = stub.getMessage(responseObserver);
        responseObserver.setRequestObserver(reqObserver);
        responseObserver.start();
        responseObserver.await();
    }
    // Guess Number
    //====================================================================================================
    public static void guessNumber() throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext().build();
        GuessNumberResponseHandler responseObserver = new GuessNumberResponseHandler();
        GuessNumberGrpc.GuessNumberStub stub = GuessNumberGrpc.newStub(channel);
        StreamObserver<GuessRequest> reqObserver = stub.guess(responseObserver);
        responseObserver.setRequestObserver(reqObserver);
        responseObserver.start();
        responseObserver.await();
    }
    // Validation
    //====================================================================================================
    public static void validationGetBalance() throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext().build();
        BalanceCheckRequest balanceCheckRequest = BalanceCheckRequest.newBuilder()
                .setAccountNumber(11)
                .build();
        TransactionServiceGrpc.TransactionServiceBlockingStub stub = TransactionServiceGrpc.newBlockingStub(channel);

        try {
            AccountBalance response = stub.
                    withDeadline(Deadline.after(2, TimeUnit.SECONDS)). //This is for backoff
                    checkBalance(balanceCheckRequest);
        } catch (StatusRuntimeException e) {
            log.error("Got exception for balance check: {}, code {} ", e.getStatus(), e.getStatus().getCode());
            // Trailer from statuses. Will have to give correct key
            //log.error("Trailer: {} ", e.getTrailers().get(Key), e.getStatus().getCode());
            log.error("Deadline ", e.getStatus().getCode());
            // for above Status.Code.DEADLINE_EXCEEDED
        }
    }

    public static void validationWithdraw() throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext().build();
        WithdrawalRequest req = WithdrawalRequest.newBuilder()
                .setAccountNumber(11)
                .setAmount(1000)
                .build();
        TransactionServiceGrpc.TransactionServiceStub stub = TransactionServiceGrpc.newStub(channel);
        CountDownLatch latch = new CountDownLatch(1);
        stub
                .withDeadline(Deadline.after(2, TimeUnit.SECONDS))  // same as above
                // With streaming there is a problem that deadline will breach before onCompletion if it is long running
                // Use context to top server from streaming
                // Context.current().isCancelled() on the server side streaming code check
            .withdraw(req, new StreamObserver<com.models.sec08.Money>() {

            @Override
            public void onNext(com.models.sec08.Money money) {
                log.info("Received money: {}", money.getAmount());

            }

            @Override
            public void onError(Throwable throwable) {
                Status status = Status.fromThrowable(throwable);
                log.error("Error: {}", status);
                latch.countDown();
            }

            @Override
            public void onCompleted() {
                log.info("Server is done");
                latch.countDown();
            }
        });
        latch.await();
        req = WithdrawalRequest.newBuilder()
                .setAccountNumber(1)
                .setAmount(1000)
                .build();
        CountDownLatch latch1 = new CountDownLatch(1);
        stub.withdraw(req, new StreamObserver<com.models.sec08.Money>() {

            @Override
            public void onNext(com.models.sec08.Money money) {
                log.info("Received money: {}", money.getAmount());

            }

            @Override
            public void onError(Throwable throwable) {
                Status status = Status.fromThrowable(throwable);
                log.error("Error: {}", status);
                latch1.countDown();
            }

            @Override
            public void onCompleted() {
                log.info("Server is done");
                latch1.countDown();
            }
        });
        latch1.await();

        req = WithdrawalRequest.newBuilder()
                .setAccountNumber(1)
                .setAmount(99)
                .build();
        CountDownLatch latch2 = new CountDownLatch(1);
        stub
                .withWaitForReady()  // Will wait till the server is available to serve requests
                .withDeadline(Deadline.after(2, TimeUnit.SECONDS)) // wait till deadline
                .withdraw(req, new StreamObserver<com.models.sec08.Money>() {

            @Override
            public void onNext(com.models.sec08.Money money) {
                log.info("Received money: {}", money.getAmount());

            }

            @Override
            public void onError(Throwable throwable) {
                Status status = Status.fromThrowable(throwable);
                log.error("Error: {}", status);
                latch2.countDown();
            }

            @Override
            public void onCompleted() {
                log.info("Server is done");
                latch2.countDown();
            }
        });
        latch2.await();
    }
    //Gzip compression
    //=======================================================================================
    public static void validationGetBalanceWithGzip() throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext().build();
        BalanceCheckRequest balanceCheckRequest = BalanceCheckRequest.newBuilder()
                .setAccountNumber(11)
                .build();
        TransactionServiceGrpc.TransactionServiceBlockingStub stub = TransactionServiceGrpc.newBlockingStub(channel);

        try {
            AccountBalance response = stub.
                    withCompression("gzip"). // with Gzip Compression client side
                    withDeadline(Deadline.after(2, TimeUnit.SECONDS)). //This is for backoff
                            checkBalance(balanceCheckRequest);
        } catch (StatusRuntimeException e) {
            log.error("Got exception for balance check: {}, code {} ", e.getStatus(), e.getStatus().getCode());
            // Trailer from statuses. Will have to give correct key
            //log.error("Trailer: {} ", e.getTrailers().get(Key), e.getStatus().getCode());
            log.error("Deadline ", e.getStatus().getCode());
            // for above Status.Code.DEADLINE_EXCEEDED
        }
    }
    //Changing Executor
    //=======================================================================================
    public static void validationGetBalanceChangingExecutor() throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext().build();
        BalanceCheckRequest balanceCheckRequest = BalanceCheckRequest.newBuilder()
                .setAccountNumber(11)
                .build();
        TransactionServiceGrpc.TransactionServiceBlockingStub stub = TransactionServiceGrpc.newBlockingStub(channel);

        try {
            AccountBalance response = stub.
                    // can other executors also
                   // withExecutor(Executors.newVirtualThreadPerTaskExecutor()). // will work with java 21
                    withCompression("gzip"). // with Gzip Compression client side
                            withDeadline(Deadline.after(2, TimeUnit.SECONDS)). //This is for backoff
                            checkBalance(balanceCheckRequest);
        } catch (StatusRuntimeException e) {
            log.error("Got exception for balance check: {}, code {} ", e.getStatus(), e.getStatus().getCode());
            // Trailer from statuses. Will have to give correct key
            //log.error("Trailer: {} ", e.getTrailers().get(Key), e.getStatus().getCode());
            log.error("Deadline ", e.getStatus().getCode());
            // for above Status.Code.DEADLINE_EXCEEDED
        }
    }
    //With interceptors
    //=======================================================================================
    public static void validationGetBalanceInterceptorsClientSide() throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext().build();
        BalanceCheckRequest balanceCheckRequest = BalanceCheckRequest.newBuilder()
                .setAccountNumber(10)
                .build();
        TransactionServiceGrpc.TransactionServiceBlockingStub stub = TransactionServiceGrpc.newBlockingStub(channel);

        try {
            AccountBalance response = stub.
                            withInterceptors(new GlobalDeadlineInterceptor(Duration.ofSeconds(2))).
                            withCompression("gzip"). // with Gzip Compression client side
                            withDeadline(Deadline.after(2, TimeUnit.SECONDS)). //This is for backoff
                            checkBalance(balanceCheckRequest);
        } catch (StatusRuntimeException e) {
            log.error("Got exception for balance check: {}, code {} ", e.getStatus(), e.getStatus().getCode());
            // Trailer from statuses. Will have to give correct key
            //log.error("Trailer: {} ", e.getTrailers().get(Key), e.getStatus().getCode());
            log.error("Deadline ", e.getStatus().getCode());
            // for above Status.Code.DEADLINE_EXCEEDED
        }
    }
}
