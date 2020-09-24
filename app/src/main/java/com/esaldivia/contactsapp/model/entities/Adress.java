package com.esaldivia.contactsapp.model.entities;

import com.esaldivia.contactsapp.model.interfaces.ContactInfo;

import java.io.Serializable;

public class Adress implements Serializable, ContactInfo {
    private String country;
    private String state;
    private String city;
    private Integer zipCode;
    private String street;

    @Override
    public String getName() {
        return Adress.class.getName();
    }

    @Override
    public String getValue() {
        return street + "/n" +
                city + ", " + state + " " + zipCode + " " + country;
    }

    @Override
    public String getType() {
        return "";
    }
}
