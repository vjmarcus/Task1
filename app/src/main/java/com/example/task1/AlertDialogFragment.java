package com.example.task1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class AlertDialogFragment extends DialogFragment {

    private int position;

    public AlertDialogFragment(int position) {
        this.position = position;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        String text = null;
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            switch (position) {
                case 0: text = "нулевой";
                break;
                case 1: text = "первый";
                break;
                case 2: text = "второй";
                break;
                case 3: text = "третий";
                break;
                case 4: text = "четвертый";
                break;
                default: text = "не определено";
                break;
            }
            builder.setTitle("Dialog title")
                    .setMessage(position + text)
                    .setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // Закрываем окно
                            dialog.cancel();
                        }
                    });
            return builder.create();
    }
}
