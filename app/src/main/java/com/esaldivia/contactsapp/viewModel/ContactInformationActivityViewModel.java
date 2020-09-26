package com.esaldivia.contactsapp.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.esaldivia.contactsapp.model.entities.Contact;
import com.esaldivia.contactsapp.repository.ContactRepository;

public class ContactInformationActivityViewModel extends ViewModel {
    private MutableLiveData<Contact> contact = new MutableLiveData<>();
    private ContactRepository mRepo;

    public void init(Contact contact) {
        this.contact.setValue(contact);
        mRepo = ContactRepository.getInstance();
    }

    public LiveData<Contact> getContact() {
        return contact;
    }

    public LiveData<Contact> updateFavorite() {
        Contact contact = this.contact.getValue();
        this.contact.setValue(contact);
        mRepo.updateContact(contact);

        return this.contact;
    }
}
