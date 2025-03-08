package com.activity.sec02;

import com.models.sec02.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersonProtoDemo2 {
    private static final Logger log = LoggerFactory.getLogger(PersonProtoDemo2.class);

    public static void main(String args[]) {
        Person obj1 = createPerson();
        Person obj2 = createPerson();
        log.info("equals {}", obj1.equals(obj2));
        log.info("== {}", (obj2 == obj1));

        Person obj3 = obj2.toBuilder().clearName().build();
        log.info("Obj3 {}", obj3);

    }

    public static Person createPerson() {
        return Person.newBuilder().setName("Pranay").setAge(40).build();
    }
}
