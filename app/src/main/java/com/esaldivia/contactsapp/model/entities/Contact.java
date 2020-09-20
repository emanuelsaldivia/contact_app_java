package com.esaldivia.contactsapp.model.entities;

import com.esaldivia.contactsapp.model.interfaces.PhoneInterface;

import java.util.Date;
import java.util.List;

public class Contact {
    private Integer id;
    private String name;
    private String companyName;
    private boolean isFavorite;
    private String smallImageURL;
    private String largeImageURL;
    private String emailAdress;
    private Date birthdate;
    private List<PhoneInterface> phoneNumbers;
    private Adress adress;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public String getSmallImageURL() {
        return smallImageURL;
    }

    public String getLargeImageURL() {
        return largeImageURL;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public List<PhoneInterface> getPhoneNumbers() {
        return phoneNumbers;
    }

    public Adress getAdress() {
        return adress;
    }
}
