package com.activity.sec03;

import com.google.protobuf.InvalidProtocolBufferException;
import com.models.sec03.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SerializeAndDeserialize {
    private static final Logger log = LoggerFactory.getLogger(OneOfExp.class);

    public static void main(String args[]) throws InvalidProtocolBufferException {
        Person person = Person.newBuilder().setId(1).setName("Pranay").build();
        byte[] serialPerson = serialize(person);
        Person person2 = deserialize(serialPerson);
        log.info("Person2: {}", person2);
        log.info("Perosn1.equals(Person2): {}", person.equals(person2));
        log.info("Perosn1 == Person2: {}", (person == person2));

    }

    public static byte[] serialize(Person person) {
        byte[] personByteArray = person.toByteArray();
        log.info("Serialized Person: {}", personByteArray);
        return personByteArray;
    }

    public static Person deserialize(byte[] personByteArray) throws InvalidProtocolBufferException {
        Person person = Person.parseFrom(personByteArray);
        log.info("Deserialized Person: {}", person);
        return person;
    }
}
