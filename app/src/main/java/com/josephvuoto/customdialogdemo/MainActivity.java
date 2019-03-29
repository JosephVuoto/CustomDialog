package com.josephvuoto.customdialogdemo;

import android.media.session.PlaybackState;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.josephvuoto.customdialog.CustomDialog;


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

    }
}
