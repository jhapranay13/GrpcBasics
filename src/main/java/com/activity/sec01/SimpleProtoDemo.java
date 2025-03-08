package com.activity.sec01;

import com.models.sec01.PersonOuterClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleProtoDemo {
    private static final Logger log = LoggerFactory.getLogger(SimpleProtoDemo.class);

    public static void main(String args[]) {
        PersonOuterClass.Person obj = PersonOuterClass.Person.newBuilder().setName("Pranay").setAge(40).build();
        log.info("{}", obj);
    }
}
