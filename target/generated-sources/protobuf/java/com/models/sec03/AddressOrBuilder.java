// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: sec03/Address.proto

// Protobuf Java Version: 3.25.1
package com.models.sec03;

public interface AddressOrBuilder extends
    // @@protoc_insertion_point(interface_extends:sec03.Address)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *For has method 
   * </pre>
   *
   * <code>optional string street = 1;</code>
   * @return Whether the street field is set.
   */
  boolean hasStreet();
  /**
   * <pre>
   *For has method 
   * </pre>
   *
   * <code>optional string street = 1;</code>
   * @return The street.
   */
  java.lang.String getStreet();
  /**
   * <pre>
   *For has method 
   * </pre>
   *
   * <code>optional string street = 1;</code>
   * @return The bytes for street.
   */
  com.google.protobuf.ByteString
      getStreetBytes();

  /**
   * <code>string city = 2;</code>
   * @return The city.
   */
  java.lang.String getCity();
  /**
   * <code>string city = 2;</code>
   * @return The bytes for city.
   */
  com.google.protobuf.ByteString
      getCityBytes();

  /**
   * <code>string state = 3;</code>
   * @return The state.
   */
  java.lang.String getState();
  /**
   * <code>string state = 3;</code>
   * @return The bytes for state.
   */
  com.google.protobuf.ByteString
      getStateBytes();
}
