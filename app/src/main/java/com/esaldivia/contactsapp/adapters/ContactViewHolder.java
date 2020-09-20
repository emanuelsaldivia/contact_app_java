package com.esaldivia.contactsapp.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.esaldivia.contactsapp.databinding.ActivityMainBinding;
import com.esaldivia.contactsapp.databinding.ContactAdapterBinding;

public class ContactViewHolder extends RecyclerView.ViewHolder {

    private ContactAdapterBinding contactAdapterBinding;

    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);
        contactAdapterBinding = ContactAdapterBinding.bind(itemView);
    }

    public View getView() {
        return contactAdapterBinding.getRoot();
    }

    public ImageView getUserImageView() {
        return contactAdapterBinding.contactImage;
    }

    public ImageView getUserIsFavoriteView() {
        return contactAdapterBinding.contactIsFavorite;
    }

    public TextView getNameTextView() {
        return contactAdapterBinding.contactName;
    }

    public TextView getCompanyTextView() {
        return contactAdapterBinding.contactCompany;
    }
}
