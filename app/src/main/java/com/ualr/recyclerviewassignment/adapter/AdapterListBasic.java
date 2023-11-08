package com.ualr.recyclerviewassignment.adapter;

import android.content.Context;
import android.graphics.drawable.Icon;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.ExtractedText;
import android.widget.HeaderViewListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ualr.recyclerviewassignment.MainActivity;
import com.ualr.recyclerviewassignment.R;
import com.ualr.recyclerviewassignment.model.Inbox;

import java.text.CollationElementIterator;
import java.util.List;

public class AdapterListBasic extends RecyclerView.Adapter {

    // A Defined variable that will contain the data source that is passed into the constructor
    private static List<Inbox> mItems;
    private Context mContext;
    private Object Tools;
    private String originalText;

    public void addItems(int i, Inbox newItem) {
    }

    public void deleteItem(int i) {
    }

    public void clear() {
    }

    public void setOnItemClickListener(MainActivity mainActivity) {
    }

    public interface OnItemClickListener {
        void onItemClick(View view, Inbox obj, int index);

        void OnThumbnailClick(View view, Inbox obj, int index);

        void onThumbnailClick(View view, Inbox obj, int index);
    }

    private static OnItemClickListener mListener;
    // The constructor copies the Inbox collection to the corresponding variable
    public AdapterListBasic(List<Inbox> items){
        this.mItems = items;
        Context context;
    }

    public void removeItem(int index) {

        if (index >= mItems.size()) {
            return;
        }
        mItems.remove(index);
        notifyItemRemoved(index);
        notifyItemRangeChanged(index, getItemCount());
    }

    @Override
    public int getItemViewType(int index) {

        return 0; //.mItems.get(index).isSection() ? HEADER_VIEW : Person_View;
    }
    public void setOnItemClickListener(final OnItemClickListener itemClickListener) {
        this.mListener = itemClickListener;
    }

    // The defined ViewHolder class, used to hold a reference to the different widgets within each row item
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating the layout, creating different elements in every row of the RecyclerView
        LayoutInflater lyInflater = LayoutInflater.from(parent.getContext());
        //Invoking the inflate method
        View itemView = lyInflater.inflate(R.layout.item_email, parent, false);
        RecyclerView.ViewHolder vh = new itemViewHolder(itemView);
        return vh;
    }

    // The onBindViewHolder method

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int index) {
        itemViewHolder iVH = (itemViewHolder) holder;
        Inbox i = mItems.get(index);


        //Set the name and date TextViews
        iVH.name.setText(i.getFrom());
        iVH.date.setText(i.getDate());
        iVH.email.setText(i.getEmail());
        iVH.icon.setText(i.getFrom().substring(0,1));
    }

    //The getItemCount method
    @Override
    public int getItemCount() {

        return mItems.size();
    }

    //Defining the ViewHolder class as an inner class
    public class itemViewHolder extends RecyclerView.ViewHolder{


      //  private static final View icon;
        public TextView icon;
        public TextView name;
        public TextView date;
        public TextView email;
        public View lyt_parent;
        //public CollationElementIterator action_image;


        public itemViewHolder(@NonNull View itemView) {

            super(itemView);




            name = itemView.findViewById(R.id.name);
            icon = itemView.findViewById(R.id.icon);
            email = itemView.findViewById(R.id.email);
            date = itemView.findViewById(R.id.date);
            lyt_parent = itemView.findViewById(R.id.lyt_parent);

            //Set the click listener for the entire item view
            lyt_parent.setOnClickListener(new View.OnClickListener(){



                public void onClickListener(View itemView) {
                    //mListener.onItemClick(itemView, mItems.get(getAbsoluteAdapterPosition()), getAbsoluteAdapterPosition());

                };

                    @Override
                    public void onClick(View itemView) {
                        // Toggle the icon text between original text and "X"
                        if (icon.getText().toString().equals("X")) {
                            icon.setText(originalText);
                        } else {
                            originalText = icon.getText().toString();
                            icon.setText("X");
                        }
                    }
            });




            // Set the click listener for the icon view
            icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Delete the item only when the item is selected
                    if (icon.getText().toString().equals("X")) {
                        removeItem(getAbsoluteAdapterPosition());
                    }
                }
            });


        }
    }
}
