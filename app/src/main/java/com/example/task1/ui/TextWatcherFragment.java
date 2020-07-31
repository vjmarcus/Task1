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

public class TextWatcherFragment extends Fragment implements TextWatcher, View.OnClickListener {

    private EditText editText;
    private TextView textWatcherTextView;
    private Button showToastButton;

    public TextWatcherFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_first, container, false);
        init(root);
        editText.addTextChangedListener(this);
        showToastButton.setOnClickListener(this);
        return root;
    }

    private void init(View root) {
        editText = root.findViewById(R.id.editText);
        textWatcherTextView = root.findViewById(R.id.textViewTextWatcher);
        showToastButton = root.findViewById(R.id.buttonShowToast);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        //do nothing
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        //do nothing
    }

    @Override
    public void afterTextChanged(Editable editable) {
        if (editable.length() == 0) {
            textWatcherTextView.setVisibility(View.GONE);
        } else {
            StringBuilder builder = new StringBuilder();
            builder.append(getString(R.string.you_enter)).append(editText.getText());
            textWatcherTextView.setText(builder);
        }
    }

    @Override
    public void onClick(View view) {
        if (editText.getText().length() == 0) {
            Toast.makeText(getActivity(), R.string.field_is_empty, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), editText.getText(), Toast.LENGTH_SHORT).show();
        }
    }
}