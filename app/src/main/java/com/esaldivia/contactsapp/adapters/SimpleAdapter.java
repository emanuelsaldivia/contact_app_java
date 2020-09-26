package com.esaldivia.contactsapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.esaldivia.contactsapp.databinding.ContactAdapterBinding;
import com.esaldivia.contactsapp.databinding.SectionBinding;

import java.util.List;

public class SimpleAdapter extends RecyclerView.Adapter<SimpleViewHolder> {

    private final Context mContext;
    private List<String> mData;
    private SectionBinding sectionBinding;

    public void add(String s,int position) {
        position = position == -1 ? getItemCount()  : position;
        mData.add(position,s);
        notifyItemInserted(position);
    }

    public void remove(int position){
        if (position < getItemCount()  ) {
            mData.remove(position);
            notifyItemRemoved(position);
        }
    }

    public SimpleAdapter(Context context, List<String> data) {
        mContext = context;
        mData = data;
    }

    @NonNull
    @Override
    public SimpleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        sectionBinding = SectionBinding.inflate(layoutInflater);
        View view = sectionBinding.getRoot();
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleViewHolder holder, int position) {
        TextView title = holder.getSection();
        title.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
