package com.josephvuoto.customdialogdemo;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.josephvuoto.customdialog.CustomAlertDialog.CustomDialog;
import com.josephvuoto.customdialog.CustomListDialog.ListDialog;
import com.josephvuoto.customdialog.CustomListDialog.ListItemModel;
import com.josephvuoto.customdialog.CustomLoadingDialog.LoadingDialog;
import com.josephvuoto.customdialog.CustomUIDialog.CustomViewDialog;

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
                .setMessage("MESSAGE, MESSAGE, MESSAGE, MESSAGE, MESSAGE, MESSAGE, MESSAGE, MESSAGE")
                .setOkButton("OK", dialog -> {
                    Toast.makeText(this, "CLICKED OK", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                })
                .setCancelButton("CANCEL", dialog -> {
                    Toast.makeText(this, "CLICKED CANCEL", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                })
                .build()
                .show();
    }

    public void withoutTitle(View view) {
        new CustomDialog.Builder(this)
                .setMessage("MESSAGE")
                .setOkButton("OK", dialog -> {
                    Toast.makeText(this, "CLICKED OK", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                })
//                .setCancelButton("CANCEL", dialog ->
//                        Toast.makeText(this, "CLICKED CANCEL", Toast.LENGTH_SHORT).show())
                .build()
                .show();
    }

    public void withList(View view) {
        List<ListItemModel> listItemModels = new ArrayList<>();
        listItemModels.add(new ListItemModel(R.drawable.ic_alarms, "Set Alarm"));
        listItemModels.add(new ListItemModel(R.drawable.ic_insert_emoticon, "Insert Emoticon"));
        listItemModels.add(new ListItemModel(R.drawable.ic_lock_open, "Open Lock"));
        new ListDialog.Builder(this)
                .setDatas(listItemModels)
                .setColorText(getResources().getColor(R.color.colorAccent))
                .setColorImageTint(getResources().getColor(R.color.colorAccent))
                .setOnSelectListener((which, dialog) -> {
                    Toast.makeText(this, "CLICKED " + which, Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                })
                .build()
                .show();
    }

    public void custom(View view) {
        @SuppressLint("InflateParams")
        LinearLayout customView = (LinearLayout) LayoutInflater.from(this)
                .inflate(R.layout.layout_custom, null, false);
        new CustomViewDialog.Builder(this)
                .setOkButton("Done", Dialog::dismiss)
                .setCustomView(customView)
                .build()
                .show();
    }

    public void loading(View view) {
        new LoadingDialog.Builder(this)
                .setLoadingText("new loading...")
                .setTextColor(Color.parseColor("#DDDDDD"))
                .setCanceledOnTouchOutside(false)
                .build()
                .show();
    }
}
