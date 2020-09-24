package com.esaldivia.contactsapp.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.esaldivia.contactsapp.ContactInformationActivity;
import com.esaldivia.contactsapp.R;
import com.esaldivia.contactsapp.databinding.ContactAdapterBinding;
import com.esaldivia.contactsapp.model.entities.Contact;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {
    List<Contact> listOfContacts;
    private Context context;
    ContactAdapterBinding contactAdapterBinding;

    public ContactAdapter(List<Contact> listOfContacts, Context context) {
        this.listOfContacts = listOfContacts;
        this.context = context;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        contactAdapterBinding = ContactAdapterBinding.inflate(layoutInflater);
        View view = contactAdapterBinding.getRoot();
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact contact = listOfContacts.get(position);
        final String imageURL = contact.getSmallImageURL();
        final boolean isfavorite = contact.isFavorite();
        final String name = contact.getName();
        final String companyName = contact.getCompanyName();

        holder.getNameTextView().setText(name);
        holder.getCompanyTextView().setText(companyName);

        Glide.with(context)
                .load(imageURL)
                .apply(RequestOptions.placeholderOf(context.getDrawable(R.drawable.user_small)))
                .into(holder.getUserImageView());


        holder.getUserIsFavoriteView().setImageDrawable(isfavorite ?
                        context.getDrawable(R.drawable.favorite_true) :
                        context.getDrawable(R.drawable.favorite_false));

        holder.getView().setOnClickListener((view) ->{
            Intent intent = new Intent(context, ContactInformationActivity.class);
            intent.putExtra(ContactInformationActivity.CONTACT_KEY, contact);
            Activity activity = (Activity) context;
            activity.startActivityForResult(intent, 1);
        });

    }

    @Override
    public int getItemCount() {
        return listOfContacts.size();
    }
}
