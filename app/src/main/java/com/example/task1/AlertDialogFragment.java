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
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        String textValueOfPosition = getTextValueOfPosition(position);
        builder.setMessage(position + " " + "(" + textValueOfPosition + ")").setTitle("Title")
                .setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Close window
                        dialog.cancel();
                    }
                });
        return builder.create();
    }

    private String getTextValueOfPosition(int position) {
        String text = null;
        switch (position) {
            case 0:
                text = "нулевой";
                break;
            case 1:
                text = "первый";
                break;
            case 2:
                text = "второй";
                break;
            case 3:
                text = "третий";
                break;
            case 4:
                text = "четвертый";
                break;
            case 5:
                text = "пятый";
                break;
            case 6:
                text = "шестой";
                break;
            case 7:
                text = "седьмой";
                break;
            case 8:
                text = "восьмой";
                break;
            case 9:
                text = "девятый";
                break;
            default:
                text = "не определено";
                break;
        }
        return text;
    }
}
