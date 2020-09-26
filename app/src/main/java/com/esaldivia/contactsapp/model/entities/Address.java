package com.esaldivia.contactsapp.model.entities;

import com.esaldivia.contactsapp.model.interfaces.ContactInfo;

import java.io.Serializable;

public class Address implements Serializable, ContactInfo {
    private String country;
    private String state;
    private String city;
    private Integer zipCode;
    private String street;

    @Override
    public String getName() {
        return "Address:";
    }

    @Override
    public String getValue() {
        return street + "\n" +
                city + ", " + state + " " + zipCode + " " + country;
    }

    @Override
    public String getType() {
        return "";
    }
}
