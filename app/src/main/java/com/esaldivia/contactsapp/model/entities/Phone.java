package com.esaldivia.contactsapp.model.entities;

import com.esaldivia.contactsapp.model.interfaces.ContactInfo;
import com.esaldivia.contactsapp.model.interfaces.PhoneInterface;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Phone implements Serializable {
    private String work;
    private String home;
    private String mobile;

    private WorkPhone workPhone;

    public String getWork() {
        return work;
    }

    public String getHome() {
        return home;
    }

    public String getMobile() {
        return mobile;
    }

    public WorkPhone getWorkPhone() {
        return new WorkPhone(work);
    }

    public HomePhone getHomePhone() {
        return new HomePhone(home);
    }

    public MobilePhone getMobilePhone() {
        return new MobilePhone(mobile);
    }

    // todo esta logica no va aca
    public List<ContactInfo> getPhoneNumers() {
        List<ContactInfo> phoneNumbers = new ArrayList<>();

        if (getHomePhone().getValue() != null) {
            phoneNumbers.add(getHomePhone());
        }

        if (getMobilePhone().getValue() != null) {
            phoneNumbers.add(getMobilePhone());
        }

        if (getWorkPhone().getValue() != null) {
            phoneNumbers.add(getWorkPhone());
        }

        return phoneNumbers;
    }

}
