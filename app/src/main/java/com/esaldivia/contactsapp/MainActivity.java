package com.esaldivia.contactsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.esaldivia.contactsapp.adapters.ContactAdapter;
import com.esaldivia.contactsapp.adapters.SimpleSectionedRecyclerViewAdapter;
import com.esaldivia.contactsapp.databinding.ActivityMainBinding;
import com.esaldivia.contactsapp.model.entities.Contact;
import com.esaldivia.contactsapp.viewModel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Contact> mContacts = new ArrayList<>();
    private RecyclerView recyclerView;
    private ContactAdapter mAdapter;
    private SimpleSectionedRecyclerViewAdapter mSectionedAdapter;
    private List<SimpleSectionedRecyclerViewAdapter.Section> sections;
    private MainActivityViewModel mainActivityViewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        recyclerView = binding.customRecyclerView;

        sections = new ArrayList<>();

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mainActivityViewModel.init(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mainActivityViewModel.getIsUpdating().observe(this, mIsUpdating -> {
            binding.progressCircular.setVisibility(mIsUpdating ? View.VISIBLE : View.GONE);
        });

        mainActivityViewModel.getContactList().observe(this, contacts -> {
            sortContacts(contacts);
        });
    }

    private void sortContacts(List<Contact> contacts) {
        mContacts.clear();
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

        sections.clear();
        sections.add(new SimpleSectionedRecyclerViewAdapter.Section(0,getString(R.string.favorite_contacts)));
        sections.add(new SimpleSectionedRecyclerViewAdapter.Section(favContacts.size(),getString(R.string.other_contacts)));

        setupRecyclerView();
        mAdapter.notifyDataSetChanged();
    }

    private void setupRecyclerView() {
        if (mAdapter == null) {
            mAdapter = new ContactAdapter(mContacts, MainActivity.this);
            mSectionedAdapter = new SimpleSectionedRecyclerViewAdapter(this,R.layout.section,R.id.section_text,mAdapter);

            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            setupRecyclerViewSections();
            recyclerView.setAdapter(mSectionedAdapter);

            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setNestedScrollingEnabled(true);
        } else {
            setupRecyclerViewSections();
            mSectionedAdapter.notifyDataSetChanged();
            mAdapter.notifyDataSetChanged();
        }
    }

    private void setupRecyclerViewSections() {
        SimpleSectionedRecyclerViewAdapter.Section[] dummy = new SimpleSectionedRecyclerViewAdapter.Section[sections.size()];
        mSectionedAdapter.setSections(sections.toArray(dummy));
    }

}