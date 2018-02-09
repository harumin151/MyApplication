package com.example.myfrontapplication2;

/**
 * Created by Panda on 2018/01/24.
 */

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageArrayAdapter extends ArrayAdapter<Contactinformation> {

    private int resourceId;
    private List<Contactinformation> items;
    private LayoutInflater inflater;

    public ImageArrayAdapter(Context context, int resourceId, List<Contactinformation> items) {
        super(context, resourceId, items);

        this.resourceId = resourceId;
        this.items = items;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView != null) {
            view = convertView;
        } else {
            view = this.inflater.inflate(this.resourceId, null);
        }

        Contactinformation item = this.items.get(position);

        // Listviewの名前
        TextView appInfoText = (TextView)view.findViewById(R.id.item_name);
        appInfoText.setText(item.getName());

        // アイコンをセット（うまるちゃん）
        ImageView appInfoImage = (ImageView)view.findViewById(R.id.item_image);
        appInfoImage.setImageBitmap(item.getPicture());

        return view;
    }
}