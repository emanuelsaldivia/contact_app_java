package com.esaldivia.contactsapp.model.entities;

import com.esaldivia.contactsapp.model.interfaces.PhoneInterface;

import java.io.Serializable;

public class Phone implements Serializable, PhoneInterface {
    protected Integer phoneNumber;

    @Override
    public Integer getPhoneNumber() {
        return phoneNumber;
    }


}
