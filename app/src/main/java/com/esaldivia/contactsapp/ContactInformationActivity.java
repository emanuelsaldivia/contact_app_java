package com.esaldivia.contactsapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.esaldivia.contactsapp.adapters.ContactInfoAdapter;
import com.esaldivia.contactsapp.databinding.ActivityContactInformationBinding;
import com.esaldivia.contactsapp.model.entities.Contact;
import com.esaldivia.contactsapp.viewModel.ContactInformationActivityViewModel;

public class ContactInformationActivity extends AppCompatActivity {
    ActivityContactInformationBinding binding;
    RecyclerView recyclerView;
    ContactInfoAdapter mAdapter;
    ContactInformationActivityViewModel activityViewModel;

    public static final String CONTACT_KEY = "CONTACT_KEY";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContactInformationBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        setupActionBar();

        Contact contact = (Contact) getIntent().getSerializableExtra(CONTACT_KEY);

        setupViewModel(contact);
        buildView(contact);
    }

    private void setupViewModel(Contact contact) {
        activityViewModel = ViewModelProviders.of(this).get(ContactInformationActivityViewModel.class);
        activityViewModel.init(contact);
    }

    private void buildView(Contact contact) {
        if (contact != null) {
            Glide.with(this)
                    .load(contact.getLargeImageURL())
                    .apply(RequestOptions.placeholderOf(this.getDrawable(R.drawable.user_large)))
                    .into(binding.contactImage);

            binding.contactName.setText(contact.getName());
            binding.contactCompany.setText(contact.getCompanyName());

            recyclerView = binding.customRecyclerView;

            setupRecyclerView(contact);
        }
    }

    private void setupActionBar() {
        ActionBar supportActionBar = getSupportActionBar();

        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.contact_info_menu, menu);
            MenuItem item = menu.getItem(0);
            item.setIcon(getContact().isFavorite() ? R.drawable.favorite_true : R.drawable.favorite_false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.action_favorite:
                Contact contact = getContact();
                contact.setFavorite(!contact.isFavorite());
                activityViewModel.updateFavorite().observe(this, contactObserver -> {
                    item.setIcon(contactObserver.isFavorite() ? R.drawable.favorite_true : R.drawable.favorite_false);
                });
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    private Contact getContact() {
        return activityViewModel.getContact().getValue();
    }

    private void setupRecyclerView(Contact contact) {
        if (mAdapter == null) {
            mAdapter = new ContactInfoAdapter(contact.getContactInfo(this));
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(mAdapter);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setNestedScrollingEnabled(true);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }
}
