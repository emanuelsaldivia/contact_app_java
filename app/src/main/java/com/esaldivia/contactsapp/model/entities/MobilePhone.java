package com.esaldivia.contactsapp.model.entities;

import com.esaldivia.contactsapp.model.interfaces.ContactInfo;

public class MobilePhone implements ContactInfo {

    private String phoneNumber;

    public MobilePhone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String getName() {
        return "PHONE:";
    }

    @Override
    public String getValue() {
        return phoneNumber;
    }

    @Override
    public String getType() {
        return "Mobile";
    }
}
