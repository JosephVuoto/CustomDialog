package com.xieyangzhe.customdialog.CustomListDialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ListView;

import com.xieyangzhe.customdialog.R;

import java.util.List;
import java.util.Objects;

public class ListDialog extends Dialog {

    private Builder builder;

    public ListDialog(@NonNull Context context, Builder builder) {
        super(context);
        this.builder = builder;
        Objects.requireNonNull(getWindow()).setDimAmount(0.4f);
    }

    public ListDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    public ListDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dialog_list);
        ListDialogAdapter adapter = new ListDialogAdapter(getContext(), R.layout.item_dialog_list, builder.datas, builder.colorText);
        ListView list = findViewById(R.id.dialog_listview);
        list.setAdapter(adapter);
        list.setFocusable(true);
        list.setDivider(new ColorDrawable(Color.parseColor("#E1E1E1")));
        list.setDividerHeight(1);
        list.setOnItemClickListener((adapterView, view, i, l) -> {
            if (builder.onSelectListener != null) {
                builder.onSelectListener.onSelect(i, this);
            }
        });
    }

    public static class Builder {
        private Context context;
        private List<ListItemModel> datas;
        private OnSelectListener onSelectListener;
        private int colorText = -1;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setColorText(int colorText) {
            this.colorText = colorText;
            return this;
        }

        public Builder setDatas(List<ListItemModel> datas) {
            this.datas = datas;
            return this;
        }

        public Builder setOnSelectListener(OnSelectListener onSelectListener) {
            this.onSelectListener = onSelectListener;
            return this;
        }

        public ListDialog build() {
            return new ListDialog(context, this);
        }
    }
}
