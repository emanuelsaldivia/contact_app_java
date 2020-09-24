package com.esaldivia.contactsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.esaldivia.contactsapp.adapters.ContactAdapter;
import com.esaldivia.contactsapp.databinding.ActivityMainBinding;
import com.esaldivia.contactsapp.model.entities.Contact;
import com.esaldivia.contactsapp.model.entities.ContactOutputs;
import com.esaldivia.contactsapp.viewModel.MainActivityViewModel;
import com.esaldivia.contactsapp.viewModel.ViewModelContactOutputs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ContactOutputs> listOfContacts = new ArrayList<>();
    List<Contact> mContacts = new ArrayList<>();
    RecyclerView recyclerView;
    ContactAdapter mAdapter;
    MainActivityViewModel mainActivityViewModel;
    ViewModelContactOutputs viewModelContactOutputs;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        recyclerView = binding.customRecyclerView;

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mainActivityViewModel.getContactList().observe(this, contacts -> {
            List<Contact> favContacts = new ArrayList<>();
            List<Contact> otherContacts = new ArrayList<>();
            for (Contact contact : contacts) {
                if (contact.isFavorite()) {
                    favContacts.add(contact);
                } else {
                    otherContacts.add(contact);
                }
            }
            Comparator<Contact> nameComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());
            favContacts.sort(nameComparator);
            otherContacts.sort(nameComparator);
            mContacts.addAll(favContacts);
            mContacts.addAll(otherContacts);
            setupRecyclerView();
            mAdapter.notifyDataSetChanged();
        });

//        viewModelContactOutputs = ViewModelProviders.of(this).get(ViewModelContactOutputs.class);
//        viewModelContactOutputs = new ViewModelContactOutputs(this.getApplication());
//        viewModelContactOutputs.getContactRepository().observe(this, contactResponse -> {
//            List<Contact> favContacts = new ArrayList<>();
//            List<Contact> otherContacts = new ArrayList<>();
//            for (Contact contact : contactResponse) {
//                if (contact.isFavorite()) {
//                    favContacts.add(contact);
//                } else {
//                    otherContacts.add(contact);
//                }
//            }
//            Comparator<Contact> nameComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());
//            favContacts.sort(nameComparator);
//            otherContacts.sort(nameComparator);
//            mContacts.addAll(favContacts);
//            mContacts.addAll(otherContacts);
//            setupRecyclerView();
//            mAdapter.notifyDataSetChanged();
//        });
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        if (mAdapter == null) {
            mAdapter = new ContactAdapter(mContacts, MainActivity.this);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(mAdapter);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setNestedScrollingEnabled(true);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

}