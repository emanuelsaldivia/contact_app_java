package com.esaldivia.contactsapp.utils;

import com.esaldivia.contactsapp.model.entities.Contact;
import com.esaldivia.contactsapp.model.entities.ContactOutputs;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NetworkService {
    @GET("/technical-challenge/v3/contacts.json")
    Call<List<Contact>> getAllContacts();
}
