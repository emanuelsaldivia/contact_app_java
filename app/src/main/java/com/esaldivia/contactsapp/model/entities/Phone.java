package com.esaldivia.contactsapp.model.entities;

import com.esaldivia.contactsapp.model.interfaces.PhoneInterface;

public class Phone implements PhoneInterface {
    protected Integer phoneNumber;

    @Override
    public Integer getPhoneNumber() {
        return phoneNumber;
    }


}
