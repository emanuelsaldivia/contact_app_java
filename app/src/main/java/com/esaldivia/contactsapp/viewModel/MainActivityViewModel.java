package com.esaldivia.contactsapp.viewModel;

import android.content.Context;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.esaldivia.contactsapp.model.entities.Contact;
import com.esaldivia.contactsapp.repository.ContactRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<List<Contact>> contactList;
    private MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();
    private ContactRepository mRepo;

    public void init(Context context){
        if(contactList != null){
            return;
        }
        mRepo = ContactRepository.getInstance();
        contactList = mRepo.getContacts();
        mIsUpdating.setValue(true);
        contactList.observe((LifecycleOwner) context, new Observer<List<Contact>>() {
            @Override
            public void onChanged(List<Contact> contacts) {
                mIsUpdating.setValue(false);
            }
        });
    }

    public LiveData<List<Contact>> getContactList() {
        return contactList;
    }

    public LiveData<Boolean> getIsUpdating() {
        return mIsUpdating;
    }

}
