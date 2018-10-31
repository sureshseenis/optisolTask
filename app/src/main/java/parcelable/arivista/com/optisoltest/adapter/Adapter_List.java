package parcelable.arivista.com.optisoltest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import parcelable.arivista.com.optisoltest.R;
import parcelable.arivista.com.optisoltest.holder.List_Holder;

public class Adapter_List extends RecyclerView.Adapter<Adapter_List.ViewHolder> {

    private ArrayList<List_Holder> items;
    private int itemLayout;
    Context ctx;

    public Adapter_List(ArrayList<List_Holder> items, int itemLayout,Context context) {
        this.items = items;
        this.itemLayout = itemLayout;
        this.ctx=context;
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ViewHolder(v);
    }

    @Override public void onBindViewHolder(final ViewHolder holder, final int position) {
        final List_Holder item = items.get(position);
        holder.text.setText(item.getTitle());
        holder.image.setImageBitmap(null);
        holder.expantable_Image.setImageBitmap(null);
        Picasso.with(holder.image.getContext()).cancelRequest(holder.image);
        Picasso.with(holder.image.getContext()).load(item.getUrl()).into(holder.image);
        Picasso.with(holder.expantable_Image.getContext()).cancelRequest(holder.expantable_Image);
        Picasso.with(holder.expantable_Image.getContext()).load(item.getUrl()).into(holder.expantable_Image);
        holder.itemView.setTag(item);
        holder.expantable_Image.setVisibility(View.GONE);
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.expantable_Image.getVisibility()==View.VISIBLE){
                    holder.expantable_Image.setVisibility(View.GONE);
                }else {
                    holder.expantable_Image.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image,expantable_Image;
        public TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.imageView1);
            text = (TextView) itemView.findViewById(R.id.textView1);
            expantable_Image=(ImageView)itemView.findViewById(R.id.expentable_image);
        }
    }
}
