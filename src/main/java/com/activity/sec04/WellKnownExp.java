package com.activity.sec04;

import com.activity.sec03.OneOfExp;
import com.google.protobuf.Int32Value;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Timestamp;
import com.models.sec03.Person;
import com.models.sec04.Sample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;

public class WellKnownExp {
    private static final Logger log = LoggerFactory.getLogger(WellKnownExp.class);

    public static void main(String args[]) throws InvalidProtocolBufferException {
        Sample sample = Sample.newBuilder().setAge(Int32Value.of(3))
                .setTimestamp(Timestamp.newBuilder().setSeconds(Instant.now().getEpochSecond()).build()).build();

        log.info("Sample: {}", sample);
        log.info("Sample has age: {}", sample.hasAge());

    }
}
