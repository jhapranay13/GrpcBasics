// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: sec03/CollectionBook.proto

// Protobuf Java Version: 3.25.1
package com.models.sec03;

public final class CollectionBook {
  private CollectionBook() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_sec03_book_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_sec03_book_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_sec03_library_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_sec03_library_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\032sec03/CollectionBook.proto\022\005sec03\"$\n\004b" +
      "ook\022\014\n\004name\030\001 \001(\t\022\016\n\006author\030\002 \001(\t\"2\n\007lib" +
      "rary\022\014\n\004name\030\001 \001(\t\022\031\n\004book\030\002 \003(\0132\013.sec03" +
      ".bookB\024\n\020com.models.sec03P\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_sec03_book_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_sec03_book_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_sec03_book_descriptor,
        new java.lang.String[] { "Name", "Author", });
    internal_static_sec03_library_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_sec03_library_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_sec03_library_descriptor,
        new java.lang.String[] { "Name", "Book", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
