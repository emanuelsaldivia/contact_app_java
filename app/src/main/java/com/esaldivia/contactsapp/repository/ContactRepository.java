package com.esaldivia.contactsapp.repository;

import androidx.lifecycle.MutableLiveData;

import com.esaldivia.contactsapp.model.entities.Contact;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContactRepository {
    private static ContactRepository contactRepository;
    private static NetworkService networkService;
    private final MutableLiveData<List<Contact>> listOfContacts = new MutableLiveData<>();

    /**
     * Retrieves ContactRepository instance
     * @return
     */
    public static ContactRepository getInstance() {
        if (contactRepository == null) {
            contactRepository = new ContactRepository();
        }
        return contactRepository;
    }

    public ContactRepository() {
        networkService = RetrofitClientInstance.getRetrofitInstance().create(NetworkService.class);
    }

    /**
     * Retrieves contact list from API
     */
    public MutableLiveData<List<Contact>> getContacts() {
        Call<List<Contact>> contactList = networkService.getAllContacts();
        contactList.enqueue(new Callback<List<Contact>>() {
            @Override
            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
                listOfContacts.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {
            }
        });

        return listOfContacts;
    }

    /**
     * updates contacts from list (ideally ORM takes care of this)
     * @param contact
     */
    public void updateContact(Contact contact) {
        List<Contact> contacts = listOfContacts.getValue();

        for (int i = 0; i < contacts.size(); i++) {
            Contact c = contacts.get(i);
            if (contact.getId().equals(c.getId())) {
                contacts.set(i, contact);
                break;
            }
        }
    }

}
