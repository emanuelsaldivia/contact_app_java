package com.esaldivia.contactsapp.repository;

import com.esaldivia.contactsapp.model.entities.Contact;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NetworkService {
    @GET("/technical-challenge/v3/contacts.json")
    Call<List<Contact>> getAllContacts();
}
