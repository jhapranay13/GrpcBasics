// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: sec04/well-known.proto

// Protobuf Java Version: 3.25.1
package com.models.sec04;

/**
 * Protobuf type {@code sec04.Sample}
 */
public final class Sample extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:sec04.Sample)
    SampleOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Sample.newBuilder() to construct.
  private Sample(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Sample() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Sample();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.models.sec04.WellKnown.internal_static_sec04_Sample_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.models.sec04.WellKnown.internal_static_sec04_Sample_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.models.sec04.Sample.class, com.models.sec04.Sample.Builder.class);
  }

  private int bitField0_;
  public static final int TIMESTAMP_FIELD_NUMBER = 1;
  private com.google.protobuf.Timestamp timestamp_;
  /**
   * <code>.google.protobuf.Timestamp timestamp = 1;</code>
   * @return Whether the timestamp field is set.
   */
  @java.lang.Override
  public boolean hasTimestamp() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>.google.protobuf.Timestamp timestamp = 1;</code>
   * @return The timestamp.
   */
  @java.lang.Override
  public com.google.protobuf.Timestamp getTimestamp() {
    return timestamp_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : timestamp_;
  }
  /**
   * <code>.google.protobuf.Timestamp timestamp = 1;</code>
   */
  @java.lang.Override
  public com.google.protobuf.TimestampOrBuilder getTimestampOrBuilder() {
    return timestamp_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : timestamp_;
  }

  public static final int AGE_FIELD_NUMBER = 2;
  private com.google.protobuf.Int32Value age_;
  /**
   * <pre>
   * it will create hasAge method for check
   * </pre>
   *
   * <code>optional .google.protobuf.Int32Value age = 2;</code>
   * @return Whether the age field is set.
   */
  @java.lang.Override
  public boolean hasAge() {
    return ((bitField0_ & 0x00000002) != 0);
  }
  /**
   * <pre>
   * it will create hasAge method for check
   * </pre>
   *
   * <code>optional .google.protobuf.Int32Value age = 2;</code>
   * @return The age.
   */
  @java.lang.Override
  public com.google.protobuf.Int32Value getAge() {
    return age_ == null ? com.google.protobuf.Int32Value.getDefaultInstance() : age_;
  }
  /**
   * <pre>
   * it will create hasAge method for check
   * </pre>
   *
   * <code>optional .google.protobuf.Int32Value age = 2;</code>
   */
  @java.lang.Override
  public com.google.protobuf.Int32ValueOrBuilder getAgeOrBuilder() {
    return age_ == null ? com.google.protobuf.Int32Value.getDefaultInstance() : age_;
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
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeMessage(1, getTimestamp());
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      output.writeMessage(2, getAge());
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getTimestamp());
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getAge());
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
    if (!(obj instanceof com.models.sec04.Sample)) {
      return super.equals(obj);
    }
    com.models.sec04.Sample other = (com.models.sec04.Sample) obj;

    if (hasTimestamp() != other.hasTimestamp()) return false;
    if (hasTimestamp()) {
      if (!getTimestamp()
          .equals(other.getTimestamp())) return false;
    }
    if (hasAge() != other.hasAge()) return false;
    if (hasAge()) {
      if (!getAge()
          .equals(other.getAge())) return false;
    }
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
    if (hasTimestamp()) {
      hash = (37 * hash) + TIMESTAMP_FIELD_NUMBER;
      hash = (53 * hash) + getTimestamp().hashCode();
    }
    if (hasAge()) {
      hash = (37 * hash) + AGE_FIELD_NUMBER;
      hash = (53 * hash) + getAge().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.models.sec04.Sample parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.models.sec04.Sample parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.models.sec04.Sample parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.models.sec04.Sample parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.models.sec04.Sample parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.models.sec04.Sample parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.models.sec04.Sample parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.models.sec04.Sample parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.models.sec04.Sample parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.models.sec04.Sample parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.models.sec04.Sample parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.models.sec04.Sample parseFrom(
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
  public static Builder newBuilder(com.models.sec04.Sample prototype) {
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
   * Protobuf type {@code sec04.Sample}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:sec04.Sample)
      com.models.sec04.SampleOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.models.sec04.WellKnown.internal_static_sec04_Sample_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.models.sec04.WellKnown.internal_static_sec04_Sample_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.models.sec04.Sample.class, com.models.sec04.Sample.Builder.class);
    }

    // Construct using com.models.sec04.Sample.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getTimestampFieldBuilder();
        getAgeFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      timestamp_ = null;
      if (timestampBuilder_ != null) {
        timestampBuilder_.dispose();
        timestampBuilder_ = null;
      }
      age_ = null;
      if (ageBuilder_ != null) {
        ageBuilder_.dispose();
        ageBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.models.sec04.WellKnown.internal_static_sec04_Sample_descriptor;
    }

    @java.lang.Override
    public com.models.sec04.Sample getDefaultInstanceForType() {
      return com.models.sec04.Sample.getDefaultInstance();
    }

    @java.lang.Override
    public com.models.sec04.Sample build() {
      com.models.sec04.Sample result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.models.sec04.Sample buildPartial() {
      com.models.sec04.Sample result = new com.models.sec04.Sample(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.models.sec04.Sample result) {
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.timestamp_ = timestampBuilder_ == null
            ? timestamp_
            : timestampBuilder_.build();
        to_bitField0_ |= 0x00000001;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.age_ = ageBuilder_ == null
            ? age_
            : ageBuilder_.build();
        to_bitField0_ |= 0x00000002;
      }
      result.bitField0_ |= to_bitField0_;
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
      if (other instanceof com.models.sec04.Sample) {
        return mergeFrom((com.models.sec04.Sample)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.models.sec04.Sample other) {
      if (other == com.models.sec04.Sample.getDefaultInstance()) return this;
      if (other.hasTimestamp()) {
        mergeTimestamp(other.getTimestamp());
      }
      if (other.hasAge()) {
        mergeAge(other.getAge());
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
            case 10: {
              input.readMessage(
                  getTimestampFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              input.readMessage(
                  getAgeFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000002;
              break;
            } // case 18
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

    private com.google.protobuf.Timestamp timestamp_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder> timestampBuilder_;
    /**
     * <code>.google.protobuf.Timestamp timestamp = 1;</code>
     * @return Whether the timestamp field is set.
     */
    public boolean hasTimestamp() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>.google.protobuf.Timestamp timestamp = 1;</code>
     * @return The timestamp.
     */
    public com.google.protobuf.Timestamp getTimestamp() {
      if (timestampBuilder_ == null) {
        return timestamp_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : timestamp_;
      } else {
        return timestampBuilder_.getMessage();
      }
    }
    /**
     * <code>.google.protobuf.Timestamp timestamp = 1;</code>
     */
    public Builder setTimestamp(com.google.protobuf.Timestamp value) {
      if (timestampBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        timestamp_ = value;
      } else {
        timestampBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp timestamp = 1;</code>
     */
    public Builder setTimestamp(
        com.google.protobuf.Timestamp.Builder builderForValue) {
      if (timestampBuilder_ == null) {
        timestamp_ = builderForValue.build();
      } else {
        timestampBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp timestamp = 1;</code>
     */
    public Builder mergeTimestamp(com.google.protobuf.Timestamp value) {
      if (timestampBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
          timestamp_ != null &&
          timestamp_ != com.google.protobuf.Timestamp.getDefaultInstance()) {
          getTimestampBuilder().mergeFrom(value);
        } else {
          timestamp_ = value;
        }
      } else {
        timestampBuilder_.mergeFrom(value);
      }
      if (timestamp_ != null) {
        bitField0_ |= 0x00000001;
        onChanged();
      }
      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp timestamp = 1;</code>
     */
    public Builder clearTimestamp() {
      bitField0_ = (bitField0_ & ~0x00000001);
      timestamp_ = null;
      if (timestampBuilder_ != null) {
        timestampBuilder_.dispose();
        timestampBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp timestamp = 1;</code>
     */
    public com.google.protobuf.Timestamp.Builder getTimestampBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getTimestampFieldBuilder().getBuilder();
    }
    /**
     * <code>.google.protobuf.Timestamp timestamp = 1;</code>
     */
    public com.google.protobuf.TimestampOrBuilder getTimestampOrBuilder() {
      if (timestampBuilder_ != null) {
        return timestampBuilder_.getMessageOrBuilder();
      } else {
        return timestamp_ == null ?
            com.google.protobuf.Timestamp.getDefaultInstance() : timestamp_;
      }
    }
    /**
     * <code>.google.protobuf.Timestamp timestamp = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder> 
        getTimestampFieldBuilder() {
      if (timestampBuilder_ == null) {
        timestampBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder>(
                getTimestamp(),
                getParentForChildren(),
                isClean());
        timestamp_ = null;
      }
      return timestampBuilder_;
    }

    private com.google.protobuf.Int32Value age_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Int32Value, com.google.protobuf.Int32Value.Builder, com.google.protobuf.Int32ValueOrBuilder> ageBuilder_;
    /**
     * <pre>
     * it will create hasAge method for check
     * </pre>
     *
     * <code>optional .google.protobuf.Int32Value age = 2;</code>
     * @return Whether the age field is set.
     */
    public boolean hasAge() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <pre>
     * it will create hasAge method for check
     * </pre>
     *
     * <code>optional .google.protobuf.Int32Value age = 2;</code>
     * @return The age.
     */
    public com.google.protobuf.Int32Value getAge() {
      if (ageBuilder_ == null) {
        return age_ == null ? com.google.protobuf.Int32Value.getDefaultInstance() : age_;
      } else {
        return ageBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * it will create hasAge method for check
     * </pre>
     *
     * <code>optional .google.protobuf.Int32Value age = 2;</code>
     */
    public Builder setAge(com.google.protobuf.Int32Value value) {
      if (ageBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        age_ = value;
      } else {
        ageBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * it will create hasAge method for check
     * </pre>
     *
     * <code>optional .google.protobuf.Int32Value age = 2;</code>
     */
    public Builder setAge(
        com.google.protobuf.Int32Value.Builder builderForValue) {
      if (ageBuilder_ == null) {
        age_ = builderForValue.build();
      } else {
        ageBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * it will create hasAge method for check
     * </pre>
     *
     * <code>optional .google.protobuf.Int32Value age = 2;</code>
     */
    public Builder mergeAge(com.google.protobuf.Int32Value value) {
      if (ageBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0) &&
          age_ != null &&
          age_ != com.google.protobuf.Int32Value.getDefaultInstance()) {
          getAgeBuilder().mergeFrom(value);
        } else {
          age_ = value;
        }
      } else {
        ageBuilder_.mergeFrom(value);
      }
      if (age_ != null) {
        bitField0_ |= 0x00000002;
        onChanged();
      }
      return this;
    }
    /**
     * <pre>
     * it will create hasAge method for check
     * </pre>
     *
     * <code>optional .google.protobuf.Int32Value age = 2;</code>
     */
    public Builder clearAge() {
      bitField0_ = (bitField0_ & ~0x00000002);
      age_ = null;
      if (ageBuilder_ != null) {
        ageBuilder_.dispose();
        ageBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <pre>
     * it will create hasAge method for check
     * </pre>
     *
     * <code>optional .google.protobuf.Int32Value age = 2;</code>
     */
    public com.google.protobuf.Int32Value.Builder getAgeBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getAgeFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * it will create hasAge method for check
     * </pre>
     *
     * <code>optional .google.protobuf.Int32Value age = 2;</code>
     */
    public com.google.protobuf.Int32ValueOrBuilder getAgeOrBuilder() {
      if (ageBuilder_ != null) {
        return ageBuilder_.getMessageOrBuilder();
      } else {
        return age_ == null ?
            com.google.protobuf.Int32Value.getDefaultInstance() : age_;
      }
    }
    /**
     * <pre>
     * it will create hasAge method for check
     * </pre>
     *
     * <code>optional .google.protobuf.Int32Value age = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Int32Value, com.google.protobuf.Int32Value.Builder, com.google.protobuf.Int32ValueOrBuilder> 
        getAgeFieldBuilder() {
      if (ageBuilder_ == null) {
        ageBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.protobuf.Int32Value, com.google.protobuf.Int32Value.Builder, com.google.protobuf.Int32ValueOrBuilder>(
                getAge(),
                getParentForChildren(),
                isClean());
        age_ = null;
      }
      return ageBuilder_;
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


    // @@protoc_insertion_point(builder_scope:sec04.Sample)
  }

  // @@protoc_insertion_point(class_scope:sec04.Sample)
  private static final com.models.sec04.Sample DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.models.sec04.Sample();
  }

  public static com.models.sec04.Sample getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Sample>
      PARSER = new com.google.protobuf.AbstractParser<Sample>() {
    @java.lang.Override
    public Sample parsePartialFrom(
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

  public static com.google.protobuf.Parser<Sample> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Sample> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.models.sec04.Sample getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

