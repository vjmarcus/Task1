package com.example.task1.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task1.ui.AlertDialogFragment;
import com.example.task1.R;
import com.example.task1.model.Person;

import java.util.List;

public class personAdapter extends RecyclerView.Adapter<personAdapter.ViewHolderPerson> {

    private static final String TAG = "MyApp";
    private List<Person> personList;
    private Context context;

    public personAdapter(List<Person> personList, Context context) {
        this.personList = personList;
        this.context = context;
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
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: " + position);
                FragmentManager manager = ((FragmentActivity) context).getSupportFragmentManager();
                AlertDialogFragment alertDialogFragment = new AlertDialogFragment(position);
                alertDialogFragment.show(manager, "TAG");
            }
        });
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    class ViewHolderPerson extends RecyclerView.ViewHolder {

        private final TextView firstNameTextView;
        private final TextView lastNameTextView;
        private final CardView cardView;

        public ViewHolderPerson(@NonNull View itemView) {
            super(itemView);
            firstNameTextView = itemView.findViewById(R.id.textViewFirstName);
            lastNameTextView = itemView.findViewById(R.id.textViewLastName);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
