package com.esaldivia.contactsapp.model.entities;

import android.content.Context;

import com.esaldivia.contactsapp.R;
import com.esaldivia.contactsapp.Utils.Util_Date;
import com.esaldivia.contactsapp.model.interfaces.ContactInfo;
import com.esaldivia.contactsapp.model.interfaces.PhoneInterface;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contact implements Serializable {
    private Integer id;
    private String name;
    private String companyName;
    private boolean isFavorite;
    private String smallImageURL;
    private String largeImageURL;
    private String emailAddress;
    private Date birthdate;
    private List<PhoneInterface> phoneNumbers;
    private Phone phone;
    private Address address;

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

    public String getEmailAddress() {
        return emailAddress;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public List<PhoneInterface> getPhoneNumbers() {
        return phoneNumbers;
    }

    public Address getAddress() {
        return address;
    }

    public List<ContactInfo> getContactInfo(Context context) {

        List<ContactInfo> info = new ArrayList<>(phone.getPhoneNumers());
        info.add(getAddress());

        if (getBirthdate() != null) {
            AdditionalInformation birthdate = new AdditionalInformation(context.getString(R.string.birthdate), Util_Date.dateToString(getBirthdate()), null);
            info.add(birthdate);
        }

        if (getEmailAddress() != null) {
            AdditionalInformation email = new AdditionalInformation(context.getString(R.string.email), getEmailAddress(), null);
            info.add(email);
        }

        return info;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
