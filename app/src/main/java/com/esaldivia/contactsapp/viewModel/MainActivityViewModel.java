package com.esaldivia.contactsapp.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.esaldivia.contactsapp.model.entities.Contact;
import com.esaldivia.contactsapp.repository.ContactRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<List<Contact>> contactList;
    private ContactRepository mRepo;

    public void init(){
        if(contactList != null){
            return;
        }
        mRepo = ContactRepository.getInstance();
        contactList = mRepo.getContacts();
    }

    public LiveData<List<Contact>> getContactList() {
        return contactList;
    }
}
