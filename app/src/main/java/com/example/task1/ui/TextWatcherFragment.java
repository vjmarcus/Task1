package com.example.task1.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.task1.R;

public class TextWatcherFragment extends Fragment {

    private EditText editText;
    private TextView textViewTextWatcher;
    private Button showToast;

    public TextWatcherFragment() {
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
        View root = inflater.inflate(R.layout.fragment_first, container, false);
        editText = root.findViewById(R.id.editText);
        textViewTextWatcher = root.findViewById(R.id.textViewTextWatcher);
        showToast = root.findViewById(R.id.buttonShowToast);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 0){
                    textViewTextWatcher.setVisibility(View.GONE);
                } else {
                    textViewTextWatcher.setText("Вы ввели: " + editText.getText());
                }
            }
        });
        showToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText.getText().length() == 0 || editText.getText().equals("")) {
                    Toast.makeText(getActivity(), "field is empty", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), editText.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        return root;
    }
}