// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: sec08/bank-transaction.proto

// Protobuf Java Version: 3.25.1
package com.models.sec08;

public final class BankTransaction {
  private BankTransaction() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_sec08_BalanceCheckRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_sec08_BalanceCheckRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_sec08_AccountBalance_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_sec08_AccountBalance_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_sec08_WithdrawalRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_sec08_WithdrawalRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_sec08_Money_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_sec08_Money_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_sec08_ErrorMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_sec08_ErrorMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\034sec08/bank-transaction.proto\022\005sec08\"-\n" +
      "\023BalanceCheckRequest\022\026\n\016account_number\030\001" +
      " \001(\005\"9\n\016AccountBalance\022\026\n\016account_number" +
      "\030\001 \001(\005\022\017\n\007balance\030\002 \001(\005\";\n\021WithdrawalReq" +
      "uest\022\026\n\016account_number\030\001 \001(\005\022\016\n\006amount\030\002" +
      " \001(\005\"\027\n\005Money\022\016\n\006amount\030\002 \001(\005\"3\n\014ErrorMe" +
      "ssage\022#\n\004code\030\001 \001(\0162\025.sec08.ValidationCo" +
      "de*S\n\016ValidationCode\022\023\n\017INVALID_ACCOUNT\020" +
      "\000\022\022\n\016INVALID_AMOUNT\020\001\022\030\n\024INSUFFICIENT_BA" +
      "LANCE\020\0022\215\001\n\022TransactionService\022A\n\014checkB" +
      "alance\022\032.sec08.BalanceCheckRequest\032\025.sec" +
      "08.AccountBalance\0224\n\010withdraw\022\030.sec08.Wi" +
      "thdrawalRequest\032\014.sec08.Money0\001B\024\n\020com.m" +
      "odels.sec08P\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_sec08_BalanceCheckRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_sec08_BalanceCheckRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_sec08_BalanceCheckRequest_descriptor,
        new java.lang.String[] { "AccountNumber", });
    internal_static_sec08_AccountBalance_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_sec08_AccountBalance_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_sec08_AccountBalance_descriptor,
        new java.lang.String[] { "AccountNumber", "Balance", });
    internal_static_sec08_WithdrawalRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_sec08_WithdrawalRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_sec08_WithdrawalRequest_descriptor,
        new java.lang.String[] { "AccountNumber", "Amount", });
    internal_static_sec08_Money_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_sec08_Money_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_sec08_Money_descriptor,
        new java.lang.String[] { "Amount", });
    internal_static_sec08_ErrorMessage_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_sec08_ErrorMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_sec08_ErrorMessage_descriptor,
        new java.lang.String[] { "Code", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
