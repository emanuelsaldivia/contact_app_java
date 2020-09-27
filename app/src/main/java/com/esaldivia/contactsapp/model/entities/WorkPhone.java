package com.esaldivia.contactsapp.model.entities;

import com.esaldivia.contactsapp.model.interfaces.ContactInfo;

public class WorkPhone implements ContactInfo {
    protected String phoneNumber;

    public WorkPhone(String phoneNumber) {
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
        return "Work";
    }
}
