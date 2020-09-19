package com.esaldivia.contacts_model.entities;

import com.esaldivia.contacts_model.interfaces.PhoneInterface;

public class WorkPhone implements PhoneInterface {
    protected Integer phoneNumber;

    @Override
    public Integer getPhoneNumber() {
        return phoneNumber;
    }
}
