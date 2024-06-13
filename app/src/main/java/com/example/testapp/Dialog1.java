package com.example.testapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.annotation.NonNull;

public class Dialog1 extends DialogFragment {

    private Removable removable;

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        removable = (Removable) context;
        System.out.println("hello");
        System.out.println("fdsfd");
    }










    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        String value = getArguments().getString("VALUE");

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("Диалоговое окно");
        builder.setIcon(R.drawable.ic_launcher_foreground);
        builder.setMessage(String.format("Удалить %s ?", value));
        builder.setNegativeButton("Отмена", null);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                removable.remove(value);
            }
        });

        Dialog resultDialog = builder.create();

        return resultDialog;
    }














}
