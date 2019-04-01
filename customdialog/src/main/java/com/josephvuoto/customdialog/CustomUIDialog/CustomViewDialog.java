package com.josephvuoto.customdialog.CustomUIDialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.josephvuoto.customdialog.common.OnCancelClickListener;
import com.josephvuoto.customdialog.common.OnOkClickListener;
import com.xieyangzhe.customdialog.R;

import java.util.Objects;

public class CustomViewDialog extends Dialog {

    private Builder builder;

    public CustomViewDialog(@NonNull Context context, Builder builder) {
        super(context, R.style.Dialog);
        Objects.requireNonNull(getWindow()).setDimAmount(0.4f);
        this.builder = builder;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dialog_custom);

        TextView buttonOk = findViewById(R.id.submit);
        TextView buttonCancel = findViewById(R.id.cancel);
        FrameLayout placeHolder = findViewById(R.id.placeholder);
        View dividerAction = findViewById(R.id.divider_action);
        View dividerText = findViewById(R.id.divider_text);
        LinearLayout buttonLayout = findViewById(R.id.action_layout);

        int action_count = 0;
        if (TextUtils.isEmpty(builder.okText)) {
            buttonOk.setVisibility(View.GONE);
            dividerAction.setVisibility(View.GONE);
            buttonCancel.setBackgroundResource(R.drawable.bg_button);
        } else {
            action_count++;
            buttonOk.setText(builder.okText);
            buttonOk.setOnClickListener(v -> {
                builder.onOkClickListener.onOkClick(CustomViewDialog.this);
            });
        }

        if (TextUtils.isEmpty(builder.cancelText)) {
            buttonCancel.setVisibility(View.GONE);
            dividerAction.setVisibility(View.GONE);
            buttonOk.setBackgroundResource(R.drawable.bg_button);
        } else {
            action_count++;
            buttonCancel.setText(builder.cancelText);
            buttonCancel.setOnClickListener(v -> builder.onCancelClickListener.onCancelClick(CustomViewDialog.this));
        }
        if (action_count == 0) {
            dividerText.setVisibility(View.GONE);
            buttonLayout.setVisibility(View.GONE);
        }

        if (builder.cancelColor != -1) {
            buttonCancel.setTextColor(builder.cancelColor);
        }
        if (builder.okColor != -1) {
            buttonOk.setTextColor(builder.okColor);
        }
        if (builder.customView != null) {
            if (builder.customView.getParent() != null) {
                throw new Error("This view already has a parent view");
            }
            placeHolder.addView(builder.customView);
        }
    }

    public static class Builder {
        private Context context;
        private View customView;
        private String okText;
        private String cancelText;
        private OnOkClickListener onOkClickListener;
        private OnCancelClickListener onCancelClickListener;
        private int okColor = -1;
        private int cancelColor = -1;

        public Builder(Context context) {
            this.context = context;
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

        public Builder setCustomView(View view) {
            this.customView = view;
            return this;
        }

        public Builder setCancelColor(int cancelColor) {
            this.cancelColor = cancelColor;
            return this;
        }

        public CustomViewDialog build() {
            if (customView == null) {
                throw new Error("A customView is required");
            }
            return new CustomViewDialog(context, this);
        }
    }
}
