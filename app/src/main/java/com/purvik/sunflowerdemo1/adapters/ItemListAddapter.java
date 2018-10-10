package com.purvik.sunflowerdemo1.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.purvik.sunflowerdemo1.R;
import com.purvik.sunflowerdemo1.singleton.SingleItem;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Purvik Rana on 10-10-2018.
 */
public class ItemListAddapter extends RecyclerView.Adapter<ItemListAddapter.ItemViewHolder> {

    private List<SingleItem> singleItemList;

    public ItemListAddapter(List<SingleItem> singleItemList) {
        this.singleItemList = singleItemList;
    }

    public void addItemList(List<SingleItem> singleItemList) {
        this.singleItemList=singleItemList;
        notifyDataSetChanged();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{

        public TextView tvItem;

        public ItemViewHolder(View v) {
            super(v);
            tvItem = v.findViewById(R.id.tvItem);
        }
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);

        ItemViewHolder vh = new ItemViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {

        holder.tvItem.setText(singleItemList.get(position).getItem()+"");

    }

    @Override
    public int getItemCount() {
        return singleItemList.size();
    }


}
