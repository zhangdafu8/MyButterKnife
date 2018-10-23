package com.example.qiaoxian.mybutterknife;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.ViewHolderRecycle> {

    private LayoutInflater layoutInflaterMy;
    private List<String> mList;

    public MyRecycleViewAdapter(Context context, List<String> list){
        layoutInflaterMy = LayoutInflater.from(context);
        mList = list;

    }

    @NonNull
    @Override
    public ViewHolderRecycle onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolderRecycle(layoutInflaterMy.inflate(R.layout.item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderRecycle viewHolderRecycle, int i) {
        viewHolderRecycle.textViewRecycleItem.setText(mList.get(i));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class ViewHolderRecycle extends RecyclerView.ViewHolder {

        @BindView(R.id.textViewItem) TextView textViewRecycleItem;

        public ViewHolderRecycle(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
