package com.esaldivia.contactsapp.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.esaldivia.contactsapp.model.entities.Contact;
import com.esaldivia.contactsapp.model.entities.ContactOutputs;
import com.esaldivia.contactsapp.utils.ContactRepository;

import java.util.List;

public class ViewModelContactOutputs extends AndroidViewModel {
    private final ContactRepository repository;

    private MutableLiveData<List<Contact>> listOfContacts = new MutableLiveData<>();


    public ViewModelContactOutputs(@NonNull Application application) {
        super(application);
        repository = new ContactRepository();
    }

    public MutableLiveData<List<Contact>> getContactRepository() {
        listOfContacts = loadContacts();
        return listOfContacts;
    }

    private MutableLiveData<List<Contact>> loadContacts() {
        return repository.getContacts();
    }
}
