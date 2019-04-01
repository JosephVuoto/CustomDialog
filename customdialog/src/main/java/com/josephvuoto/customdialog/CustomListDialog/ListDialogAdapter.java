package com.josephvuoto.customdialog.CustomListDialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.xieyangzhe.customdialog.R;

import java.util.List;

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
        imageView.setImageResource(model.getImgResourceId());
        return view;
    }
}
