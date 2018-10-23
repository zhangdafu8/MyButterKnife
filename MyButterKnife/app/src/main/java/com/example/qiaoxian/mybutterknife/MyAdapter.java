package com.example.qiaoxian.mybutterknife;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyAdapter extends ArrayAdapter<String> {
    private LayoutInflater mLayoutInflater;

    public MyAdapter(@NonNull Context context, @NonNull List<String> objects) {
        super(context, -1, objects);
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder = null;
        if(convertView == null){
            convertView = mLayoutInflater.inflate(R.layout.item,parent,false);
            viewHolder = new ViewHolder(convertView);
//            viewHolder.textViewHolder=(TextView) convertView.findViewById(R.id.textViewItem);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.textViewHolder.setText(getItem(position));
        return convertView;


    }

    public static class ViewHolder{
        @BindView(R.id.textViewItem) TextView textViewHolder;
        public ViewHolder(View view){
            ButterKnife.bind(this,view);
        }
        //listener
    }
}
