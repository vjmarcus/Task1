package com.example.task1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task1.R;
import com.example.task1.RecyclerViewClickListener;
import com.example.task1.model.Person;

import java.util.List;

public class personAdapter extends RecyclerView.Adapter<personAdapter.ViewHolderPerson> {

    private static final String TAG = "MyApp";
    private List<Person> personList;
    private Context context;

    private RecyclerViewClickListener recyclerViewClickListener;

    public personAdapter(List<Person> personList, RecyclerViewClickListener recyclerViewClickListener) {
        this.personList = personList;
        this.recyclerViewClickListener = recyclerViewClickListener;
    }

    @NonNull
    @Override
    public ViewHolderPerson onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.people_item,
                parent, false);
        return new ViewHolderPerson(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolderPerson holder, final int position) {
        Person person = personList.get(position);
        holder.firstNameTextView.setText(person.getFirstName());
        holder.lastNameTextView.setText(person.getLastName());
//        holder.cardView.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    class ViewHolderPerson extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView firstNameTextView;
        private final TextView lastNameTextView;
        private final CardView cardView;

        public ViewHolderPerson(@NonNull View itemView) {
            super(itemView);
            firstNameTextView = itemView.findViewById(R.id.textViewFirstName);
            lastNameTextView = itemView.findViewById(R.id.textViewLastName);
            cardView = itemView.findViewById(R.id.cardView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            recyclerViewClickListener.recyclerViewListClicked(view, this.getLayoutPosition());
        }
    }
}
