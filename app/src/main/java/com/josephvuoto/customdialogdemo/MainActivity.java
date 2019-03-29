package com.josephvuoto.customdialogdemo;

import android.app.Dialog;
import android.graphics.Color;
import android.media.session.PlaybackState;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.josephvuoto.customdialog.CustomDialog;
import com.josephvuoto.customdialog.CustomListDialog.ListDialog;
import com.josephvuoto.customdialog.CustomListDialog.ListItemModel;
import com.josephvuoto.customdialog.CustomListDialog.OnSelectListener;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void withTitle(View view) {
        new CustomDialog.Builder(this)
                .setTitle("TITLE")
                .setMessage("MESSAGE")
                .setOkButton("OK", dialog ->
                        Toast.makeText(this, "CLICKED OK", Toast.LENGTH_SHORT).show())
                .setCancelButton("CANCEL", dialog ->
                        Toast.makeText(this, "CLICKED OK", Toast.LENGTH_SHORT).show())
                .build()
                .show();
    }

    public void withoutTitle(View view) {
        new CustomDialog.Builder(this)
                .setMessage("MESSAGE")
                .setOkButton("OK", dialog ->
                        Toast.makeText(this, "CLICKED OK", Toast.LENGTH_SHORT).show())
                .setCancelButton("CANCEL", dialog ->
                        Toast.makeText(this, "CLICKED OK", Toast.LENGTH_SHORT).show())
                .build()
                .show();
    }

    public void withList(View view) {
        List<ListItemModel> listItemModels = new ArrayList<>();
        listItemModels.add(new ListItemModel(R.mipmap.ic_launcher_round, "ITEM 1"));
        listItemModels.add(new ListItemModel(R.mipmap.ic_launcher, "ITEM 2"));
        new ListDialog.Builder(this)
                .setDatas(listItemModels)
                .setColorText(Color.BLUE)
                .setOnSelectListener((which, dialog) -> {
                    Toast.makeText(this, "CLICKED " + which, Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                })
                .build()
                .show();
    }
}
