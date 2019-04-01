package com.josephvuoto.customdialog.CustomAlertDialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.josephvuoto.customdialog.common.OnCancelClickListener;
import com.josephvuoto.customdialog.common.OnOkClickListener;
import com.xieyangzhe.customdialog.R;

import java.util.Objects;

public class CustomDialog extends Dialog {

    private Builder builder;

    public CustomDialog(@NonNull Context context, Builder builder) {
        super(context, R.style.Dialog);
        Objects.requireNonNull(getWindow()).setDimAmount(0.4f);
        this.builder = builder;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dialog_common);

        TextView textTitle = findViewById(R.id.title);
        TextView textMessage = findViewById(R.id.content);
        TextView buttonOk = findViewById(R.id.submit);
        TextView buttonCancel = findViewById(R.id.cancel);
        View divider = findViewById(R.id.divider);

        if (TextUtils.isEmpty(builder.title)) {
            textTitle.setVisibility(View.GONE);
        } else {
            textTitle.setText(builder.title);
        }

        if (TextUtils.isEmpty(builder.okText)) {
            buttonOk.setVisibility(View.GONE);
            divider.setVisibility(View.GONE);
            buttonCancel.setBackgroundResource(R.drawable.bg_button);
        } else {
            buttonOk.setText(builder.okText);
            buttonOk.setOnClickListener(v -> {
                dismiss();
                builder.onOkClickListener.onOkClick(CustomDialog.this);
            });
        }

        if (TextUtils.isEmpty(builder.cancelText)) {
            buttonCancel.setVisibility(View.GONE);
            divider.setVisibility(View.GONE);
            buttonOk.setBackgroundResource(R.drawable.bg_button);
        } else {
            buttonCancel.setText(builder.cancelText);
            buttonCancel.setOnClickListener(v -> builder.onCancelClickListener.onCancelClick(CustomDialog.this));
        }

        textMessage.setText(Html.fromHtml(builder.message));

        if (builder.cancelColor != -1) {
            buttonCancel.setTextColor(builder.cancelColor);
        }
        if (builder.okColor != -1) {
            buttonOk.setTextColor(builder.okColor);
        }
    }

    public static class Builder {
        private Context context;
        private String title;
        private String message;
        private String okText;
        private String cancelText;
        private OnOkClickListener onOkClickListener;
        private OnCancelClickListener onCancelClickListener;
        private int okColor = -1;
        private int cancelColor = -1;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setOkButton(String okText, OnOkClickListener onOkClickListener) {
            this.okText = okText;
            this.onOkClickListener = onOkClickListener;
            return this;
        }

        public Builder setCancelButton(String cancelText, OnCancelClickListener onCancelClickListener) {
            this.cancelText = cancelText;
            this.onCancelClickListener = onCancelClickListener;
            return this;
        }

        public Builder setOkColor(int okColor) {
            this.okColor = okColor;
            return this;
        }

        public Builder setCancelColor(int cancelColor) {
            this.cancelColor = cancelColor;
            return this;
        }

        public CustomDialog build() {
            if (message == null) {
                throw new Error("A message body is required");
            }
            return new CustomDialog(context, this);
        }
    }
}
