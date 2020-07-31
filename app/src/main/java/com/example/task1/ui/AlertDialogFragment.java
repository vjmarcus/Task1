package com.example.task1.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.task1.R;

public class AlertDialogFragment extends DialogFragment {

    private int position;

    public AlertDialogFragment(int position) {
        this.position = position;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        String textValueOfPosition = getTextValueOfPosition(position);;
        builder.setMessage(getString(R.string.left_bracket) + position
                + getString(R.string.right_bracket) + getString(R.string.space)
                + textValueOfPosition ).setTitle(R.string.title)
                .setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Close window
                        dialog.cancel();
                    }
                });
        return builder.create();
    }

    private String getTextValueOfPosition(int position) {
        String text;
        switch (position) {
            case 0:
                text = getString(R.string.zero);
                break;
            case 1:
                text = getString(R.string.first);
                break;
            case 2:
                text = getString(R.string.second);
                break;
            case 3:
                text = getString(R.string.third);
                break;
            case 4:
                text = getString(R.string.fourth);
                break;
            case 5:
                text = getString(R.string.fifth);
                break;
            case 6:
                text = getString(R.string.sixth);
                break;
            case 7:
                text = getString(R.string.seventh);
                break;
            case 8:
                text = getString(R.string.eighth);
                break;
            case 9:
                text = getString(R.string.ninth);
                break;
            default:
                text = getString(R.string.not_define);
                break;
        }
        return text;
    }
}
