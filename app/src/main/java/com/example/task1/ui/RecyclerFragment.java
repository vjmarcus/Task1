package com.example.task1.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task1.R;
import com.example.task1.adapter.Adapter;
import com.example.task1.model.Person;

import java.util.ArrayList;
import java.util.List;


public class RecyclerFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter peopleAdapter;
    private List<Person> personList;

    public RecyclerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_recycler, container, false);
        generateTestValuesInPeopleList();
        recyclerView = root.findViewById(R.id.recycler);
        peopleAdapter = new Adapter(personList, getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(peopleAdapter);
        return root;
    }

    private void generateTestValuesInPeopleList() {
        personList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            personList.add(new Person("FirstName" + i, "LastName" + i));
        }
    }
}