package com.esaldivia.contactsapp.adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.esaldivia.contactsapp.databinding.SectionBinding;

public class SimpleViewHolder extends RecyclerView.ViewHolder {

    SectionBinding sectionBinding;

    public SimpleViewHolder(@NonNull View itemView) {
        super(itemView);
        sectionBinding = SectionBinding.bind(itemView);
    }

    public TextView getSection() {
        return sectionBinding.sectionText;
    }
}
