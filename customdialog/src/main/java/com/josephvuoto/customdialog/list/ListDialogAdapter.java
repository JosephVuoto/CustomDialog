package com.josephvuoto.customdialog.list;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.xieyangzhe.customdialog.R;

public class ListDialogAdapter extends ArrayAdapter {

    private int resourceId;
    private ListDialog.Builder builder;

    ListDialogAdapter(@NonNull Context context, int resource, ListDialog.Builder builder) {
        super(context, resource, builder.getDatas());
        this.resourceId = resource;
        this.builder = builder;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ListItemModel model = (ListItemModel) getItem(position);
        @SuppressLint("ViewHolder") View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        TextView textItem = view.findViewById(R.id.item);
        ImageView imageView = view.findViewById(R.id.item_img);
        assert model != null;
        textItem.setText(model.getItemString());
        if (builder.getColorText() != -1) {
            textItem.setTextColor(builder.getColorText());
        }
        if (builder.getColorImageTint() != -1) {
            imageView.setColorFilter(builder.getColorImageTint());
        }
        if (model.getImgResourceId() == -1) {
            imageView.setVisibility(View.GONE);
        } else {
            imageView.setImageResource(model.getImgResourceId());
        }
        if (position == 0) {
            view.setBackgroundResource(R.drawable.bg_button_top);
        } else if (position == getCount() - 1) {
            view.setBackgroundResource(R.drawable.bg_button_bottom);
        } else {
            view.setBackgroundResource(R.drawable.bg_ripple);
        }
        return view;
    }
}
