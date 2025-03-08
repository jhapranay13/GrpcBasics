package com.activity.sec03;


import com.models.sec03.Credential;
import com.models.sec03.Email;
import com.models.sec03.Phone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OneOfExp {
    private static final Logger log = LoggerFactory.getLogger(OneOfExp.class);

    public static void main(String args[]) {

        Email email = Email.newBuilder().setEmail("acx@yahoo.com").build();
        Phone ph = Phone.newBuilder().setPhone(123456).build();
        login(Credential.newBuilder().setEmail(email).build());
        login(Credential.newBuilder().setPhone(ph).build());
        login(Credential.newBuilder().setPhone(ph).setEmail(email).build());

    }

    private static void login(Credential cred) {
        switch (cred.getCredTypeCase()) {
            case EMAIL: log.info("{}", cred.getEmail());
                break;
            case PHONE: log.info("{}", cred.getPhone());
                break;
            default: log.info("{}", "NOT SET");
                break;
        }
    }
}
