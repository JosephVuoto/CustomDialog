package com.josephvuoto.customdialog.CustomListDialog;

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
    private int colorText;

    public ListDialogAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        resourceId = resource;
    }

    public ListDialogAdapter(@NonNull Context context, int resource, @NonNull List<ListItemModel> objects, int colorText) {
        super(context, resource, objects);
        this.colorText = colorText;
        this.resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ListItemModel model = (ListItemModel) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        TextView textItem = view.findViewById(R.id.item);
        textItem.setText("" + model.getItemString());
        if (colorText != -1) {
            textItem.setTextColor(colorText);
        }
        ((ImageView) view.findViewById(R.id.item_img)).setImageResource(model.getImgResourceId());
        return view;
    }
}
