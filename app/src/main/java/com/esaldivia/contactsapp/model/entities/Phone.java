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

    public WorkPhone getWorkPhone() {
        return new WorkPhone(work);
    }

    public HomePhone getHomePhone() {
        return new HomePhone(home);
    }

    public MobilePhone getMobilePhone() {
        return new MobilePhone(mobile);
    }

    /**
     * Retrieves a list o phone numbers ready to show
     * @return
     */
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
