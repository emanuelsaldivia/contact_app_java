package com.esaldivia.contactsapp.model.entities;

import com.esaldivia.contactsapp.model.interfaces.ContactInfo;
import com.esaldivia.contactsapp.model.interfaces.PhoneInterface;

public class WorkPhone implements ContactInfo {
    protected Integer phoneNumber;

    @Override
    public String getName() {
        return "Phone";
    }

    @Override
    public String getValue() {
        return phoneNumber.toString();
    }

    @Override
    public String getType() {
        return "Work";
    }
}
