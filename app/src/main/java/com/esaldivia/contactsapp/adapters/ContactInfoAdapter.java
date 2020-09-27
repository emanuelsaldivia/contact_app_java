package com.esaldivia.contactsapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.esaldivia.contactsapp.model.interfaces.ContactInfo;

import java.util.List;

public class ContactInfoAdapter extends RecyclerView.Adapter<ContactInfoViewHolder> {

    com.esaldivia.contactsapp.databinding.ContactInfoAdapterBinding contactInfoAdapterBinding;
    List<ContactInfo> mData;

    public ContactInfoAdapter(List<ContactInfo> data) {
        mData = data;
    }

    @NonNull
    @Override
    public ContactInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        contactInfoAdapterBinding = com.esaldivia.contactsapp.databinding.ContactInfoAdapterBinding.inflate(layoutInflater);
        View view = contactInfoAdapterBinding.getRoot();
        return new ContactInfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactInfoViewHolder holder, int position) {
        ContactInfo contactInfo = mData.get(position);
        holder.getValueNameTextView().setText(contactInfo.getName());
        holder.getValueTextView().setText(contactInfo.getValue());
        holder.getValueTypeTextView().setText(contactInfo.getType());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
