package com.josephvuoto.customdialog.CustomLoadingDialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.xieyangzhe.customdialog.R;

import java.util.Objects;

public class LoadingDialog extends Dialog {
    private Builder builder;

    LoadingDialog(@NonNull Context context, int themeResId, Builder builder) {
        super(context, themeResId);
        Objects.requireNonNull(getWindow()).setDimAmount(0.4f);
        this.builder = builder;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_loading_dialog);

        TextView textView = findViewById(R.id.tv_load_dialog);
        ProgressBar progressBar = findViewById(R.id.progress);

        if (builder.loadingText != null) {
            textView.setText(builder.loadingText);
        }
        if (builder.textColor != -1) {
            textView.setTextColor(builder.textColor);
        }
    }

    public static class Builder {
        private Context context;
        private String loadingText;
        private int textColor = -1;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setLoadingText(String loadingText) {
            this.loadingText = loadingText;
            return this;
        }

        public Builder setTextColor(int textColor) {
            this.textColor = textColor;
            return this;
        }

        public LoadingDialog build() {
            return new LoadingDialog(context, R.style.CustomDialog , this);
        }
    }
}
