package com.example.task1.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task1.R;
import com.example.task1.adapter.personAdapter;
import com.example.task1.model.Person;

import java.util.ArrayList;
import java.util.List;


public class RecyclerFragment extends Fragment implements View.OnClickListener {

    private RecyclerView peopleRecyclerView;
    private RecyclerView.Adapter peopleAdapter;
    private List<Person> personList;

    public RecyclerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_recycler, container, false);
        generateTestValuesInPeopleList();
        initPeopleRecyclerView(root);
        return root;
    }

    private void initPeopleRecyclerView(View root){
        peopleRecyclerView = root.findViewById(R.id.recycler);
        peopleAdapter = new personAdapter(personList, getContext());

        peopleRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        peopleRecyclerView.setAdapter(peopleAdapter);
    }

    private void generateTestValuesInPeopleList() {
        personList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            personList.add(new Person(getString(R.string.firstNameTest)
                    + i, getString(R.string.lastNameTest) + i));
        }
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(getContext(), "HELLO", Toast.LENGTH_SHORT).show();
    }
}