package com.activity.sec08.validation;

import com.models.sec08.ErrorMessage;
import com.models.sec08.ValidationCode;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.protobuf.ProtoUtils;

import java.util.Optional;

public class RequestValidator {

    public static Optional<StatusRuntimeException> validateAccount(int accountNumber) {
        if (accountNumber > 0 && accountNumber < 11) {
            return Optional.empty();
        }
        Metadata metadata= toMetadata(ValidationCode.INVALID_ACCOUNT);
        return Optional.of(Status.INVALID_ARGUMENT.
                withDescription("Invalid Account Number").asRuntimeException(metadata));
    }

    public static Optional<StatusRuntimeException> isAmountMultipleOfTen(int amount) {
        if (amount > 0 && amount % 10 == 0) {
            return Optional.empty();
        }
        Metadata metadata= toMetadata(ValidationCode.INVALID_AMOUNT);

        return Optional.of(Status.INVALID_ARGUMENT.
                withDescription("Invalid Amount. Amount should be multiple of 10").asRuntimeException(metadata));
    }
    // Without Metadata is below for all methods
    //    public static Optional<Status> isSufficientFundsAvailable(int amount, int balance) {
    public static Optional<StatusRuntimeException> isSufficientFundsAvailable(int amount, int balance) {
        if (amount <= balance) {
            return Optional.empty();
        }
        Metadata metadata= toMetadata(ValidationCode.INSUFFICIENT_BALANCE);

        return Optional.of(Status.FAILED_PRECONDITION.
                withDescription("Insufficient funds in the account").asRuntimeException(metadata));
    }

    private static Metadata toMetadata(ValidationCode code) {
        Metadata meta = new Metadata();
        //Metadata.Key<ErrorMessage> key = ProtoUtils.keyForProto(ErrorMessage.getDefaultInstance());
        Metadata.Key<String> key = Metadata.Key.of("Error-Desc", Metadata.ASCII_STRING_MARSHALLER);

        meta.put(key,code.toString());
        return meta;
    }
}
