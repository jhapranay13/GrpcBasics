package com.activity.sec04;

import com.google.protobuf.Int32Value;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Timestamp;
import com.models.sec04.Product;
import com.models.sec04.ProductV1;
import com.models.sec04.ProductV2;
import com.models.sec04.Sample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;

public class CompatibilityExp {
    private static final Logger log = LoggerFactory.getLogger(CompatibilityExp.class);
    // only type and number matters so it is always compatible
    // even if field does not exist in the new version
    public static void main(String args[]) throws InvalidProtocolBufferException {
        Product product = Product.newBuilder().setId(1).setName("Product1").build();
        ProductV1 productV1 = ProductV1.newBuilder().setId(1).setName("Product2").setPrice(2.4F).build();
        ProductV2 productV2 = ProductV2.newBuilder().setName("Product3").setPrice(4.5F).build();

        parseProduct1(product.toByteArray());
        parseProduct1(productV1.toByteArray());
        parseProduct1(productV2.toByteArray());

        parseProduct2(product.toByteArray());
        parseProduct2(productV1.toByteArray());
        parseProduct2(productV2.toByteArray());

        parseProduct3(product.toByteArray());
        parseProduct3(productV1.toByteArray());
        parseProduct3(productV2.toByteArray());
    }

    public static void parseProduct1(byte[] productByte) throws InvalidProtocolBufferException {
        Product product = Product.parseFrom(productByte);
        log.info("Product: {}", product);
        log.info("Product id: {}", product.getId());
        log.info("Product id: {}", product.getName());
    }

    public static void parseProduct2(byte[] productByte) throws InvalidProtocolBufferException {
        ProductV1 product = ProductV1.parseFrom(productByte);
        log.info("Product: {}", product);
        log.info("Product id: {}", product.getId());
        log.info("Product id: {}", product.getName());
        log.info("Product id: {}", product.getPrice());
    }

    public static void parseProduct3(byte[] productByte) throws InvalidProtocolBufferException {
        ProductV2 product = ProductV2.parseFrom(productByte);
        log.info("Product: {}", product);
        log.info("Product id: {}", product.getName());
        log.info("Product id: {}", product.getPrice());
    }
}
