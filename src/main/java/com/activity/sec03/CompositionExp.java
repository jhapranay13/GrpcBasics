package com.activity.sec03;

import com.models.sec03.Address;
import com.models.sec03.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompositionExp {
    private static final Logger log = LoggerFactory.getLogger(CompositionExp.class);

    public static void main(String args[]) {
        Address address = Address.newBuilder().setStreet("xyz").setCity("pqr").setState("abc").build();
        Student student = Student.newBuilder().setAddress(address).setName("Hill").build();
        log.info("{}", student);
    }
}
