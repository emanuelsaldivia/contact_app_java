package com.esaldivia.contacts_model.entities;

import com.esaldivia.contacts_model.interfaces.PhoneInterface;

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
}
