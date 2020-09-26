package com.esaldivia.contactsapp.adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.esaldivia.contactsapp.databinding.ContactInfoAdapterBinding;
import com.esaldivia.contactsapp.model.entities.Contact;

public class ContactInfoViewHolder extends RecyclerView.ViewHolder {

    ContactInfoAdapterBinding contactInfoAdapterBinding;
    public ContactInfoViewHolder(@NonNull View itemView) {
        super(itemView);
        contactInfoAdapterBinding = ContactInfoAdapterBinding.bind(itemView);
    }

    public TextView getValueNameTextView() {
        return contactInfoAdapterBinding.valueName;
    }

    public TextView getValueTextView() {
        return contactInfoAdapterBinding.value;
    }

    public TextView getValueTypeTextView() {
        return contactInfoAdapterBinding.valueType;
    }
}
