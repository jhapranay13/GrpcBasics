// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: sec05/bank_service.proto

// Protobuf Java Version: 3.25.1
package com.models.sec05;

/**
 * Protobuf type {@code sec05.TransferReq}
 */
public final class TransferReq extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:sec05.TransferReq)
    TransferReqOrBuilder {
private static final long serialVersionUID = 0L;
  // Use TransferReq.newBuilder() to construct.
  private TransferReq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private TransferReq() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new TransferReq();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.models.sec05.BankServiceOuterClass.internal_static_sec05_TransferReq_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.models.sec05.BankServiceOuterClass.internal_static_sec05_TransferReq_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.models.sec05.TransferReq.class, com.models.sec05.TransferReq.Builder.class);
  }

  public static final int FROM_ACCOUNT_FIELD_NUMBER = 1;
  private int fromAccount_ = 0;
  /**
   * <code>int32 from_account = 1;</code>
   * @return The fromAccount.
   */
  @java.lang.Override
  public int getFromAccount() {
    return fromAccount_;
  }

  public static final int TO_ACCOUNT_FIELD_NUMBER = 2;
  private int toAccount_ = 0;
  /**
   * <code>int32 to_account = 2;</code>
   * @return The toAccount.
   */
  @java.lang.Override
  public int getToAccount() {
    return toAccount_;
  }

  public static final int AMOUNT_FIELD_NUMBER = 3;
  private int amount_ = 0;
  /**
   * <code>int32 amount = 3;</code>
   * @return The amount.
   */
  @java.lang.Override
  public int getAmount() {
    return amount_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (fromAccount_ != 0) {
      output.writeInt32(1, fromAccount_);
    }
    if (toAccount_ != 0) {
      output.writeInt32(2, toAccount_);
    }
    if (amount_ != 0) {
      output.writeInt32(3, amount_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (fromAccount_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, fromAccount_);
    }
    if (toAccount_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, toAccount_);
    }
    if (amount_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, amount_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.models.sec05.TransferReq)) {
      return super.equals(obj);
    }
    com.models.sec05.TransferReq other = (com.models.sec05.TransferReq) obj;

    if (getFromAccount()
        != other.getFromAccount()) return false;
    if (getToAccount()
        != other.getToAccount()) return false;
    if (getAmount()
        != other.getAmount()) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + FROM_ACCOUNT_FIELD_NUMBER;
    hash = (53 * hash) + getFromAccount();
    hash = (37 * hash) + TO_ACCOUNT_FIELD_NUMBER;
    hash = (53 * hash) + getToAccount();
    hash = (37 * hash) + AMOUNT_FIELD_NUMBER;
    hash = (53 * hash) + getAmount();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.models.sec05.TransferReq parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.models.sec05.TransferReq parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.models.sec05.TransferReq parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.models.sec05.TransferReq parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.models.sec05.TransferReq parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.models.sec05.TransferReq parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.models.sec05.TransferReq parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.models.sec05.TransferReq parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.models.sec05.TransferReq parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.models.sec05.TransferReq parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.models.sec05.TransferReq parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.models.sec05.TransferReq parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.models.sec05.TransferReq prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code sec05.TransferReq}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:sec05.TransferReq)
      com.models.sec05.TransferReqOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.models.sec05.BankServiceOuterClass.internal_static_sec05_TransferReq_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.models.sec05.BankServiceOuterClass.internal_static_sec05_TransferReq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.models.sec05.TransferReq.class, com.models.sec05.TransferReq.Builder.class);
    }

    // Construct using com.models.sec05.TransferReq.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      fromAccount_ = 0;
      toAccount_ = 0;
      amount_ = 0;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.models.sec05.BankServiceOuterClass.internal_static_sec05_TransferReq_descriptor;
    }

    @java.lang.Override
    public com.models.sec05.TransferReq getDefaultInstanceForType() {
      return com.models.sec05.TransferReq.getDefaultInstance();
    }

    @java.lang.Override
    public com.models.sec05.TransferReq build() {
      com.models.sec05.TransferReq result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.models.sec05.TransferReq buildPartial() {
      com.models.sec05.TransferReq result = new com.models.sec05.TransferReq(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.models.sec05.TransferReq result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.fromAccount_ = fromAccount_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.toAccount_ = toAccount_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.amount_ = amount_;
      }
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.models.sec05.TransferReq) {
        return mergeFrom((com.models.sec05.TransferReq)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.models.sec05.TransferReq other) {
      if (other == com.models.sec05.TransferReq.getDefaultInstance()) return this;
      if (other.getFromAccount() != 0) {
        setFromAccount(other.getFromAccount());
      }
      if (other.getToAccount() != 0) {
        setToAccount(other.getToAccount());
      }
      if (other.getAmount() != 0) {
        setAmount(other.getAmount());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {
              fromAccount_ = input.readInt32();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 16: {
              toAccount_ = input.readInt32();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
            case 24: {
              amount_ = input.readInt32();
              bitField0_ |= 0x00000004;
              break;
            } // case 24
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private int fromAccount_ ;
    /**
     * <code>int32 from_account = 1;</code>
     * @return The fromAccount.
     */
    @java.lang.Override
    public int getFromAccount() {
      return fromAccount_;
    }
    /**
     * <code>int32 from_account = 1;</code>
     * @param value The fromAccount to set.
     * @return This builder for chaining.
     */
    public Builder setFromAccount(int value) {

      fromAccount_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>int32 from_account = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearFromAccount() {
      bitField0_ = (bitField0_ & ~0x00000001);
      fromAccount_ = 0;
      onChanged();
      return this;
    }

    private int toAccount_ ;
    /**
     * <code>int32 to_account = 2;</code>
     * @return The toAccount.
     */
    @java.lang.Override
    public int getToAccount() {
      return toAccount_;
    }
    /**
     * <code>int32 to_account = 2;</code>
     * @param value The toAccount to set.
     * @return This builder for chaining.
     */
    public Builder setToAccount(int value) {

      toAccount_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>int32 to_account = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearToAccount() {
      bitField0_ = (bitField0_ & ~0x00000002);
      toAccount_ = 0;
      onChanged();
      return this;
    }

    private int amount_ ;
    /**
     * <code>int32 amount = 3;</code>
     * @return The amount.
     */
    @java.lang.Override
    public int getAmount() {
      return amount_;
    }
    /**
     * <code>int32 amount = 3;</code>
     * @param value The amount to set.
     * @return This builder for chaining.
     */
    public Builder setAmount(int value) {

      amount_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>int32 amount = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearAmount() {
      bitField0_ = (bitField0_ & ~0x00000004);
      amount_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:sec05.TransferReq)
  }

  // @@protoc_insertion_point(class_scope:sec05.TransferReq)
  private static final com.models.sec05.TransferReq DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.models.sec05.TransferReq();
  }

  public static com.models.sec05.TransferReq getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<TransferReq>
      PARSER = new com.google.protobuf.AbstractParser<TransferReq>() {
    @java.lang.Override
    public TransferReq parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<TransferReq> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<TransferReq> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.models.sec05.TransferReq getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

