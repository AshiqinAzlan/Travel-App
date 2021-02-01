package com.example.hoppy;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class foodadpt extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Food> FoodList;

    DatabaseReference databaseReference;
    FirebaseUser user;
    String id;
    String uid;

    public foodadpt(Context context, int layout, ArrayList<Food> foodList) {
        this.context = context;
        this.layout = layout;
        FoodList = foodList;
    }


    @Override
    public int getCount() {
        return FoodList.size();
    }

    @Override
    public Object getItem(int position) {
        return FoodList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class ViewHolder{
        ImageView i1;
        TextView t1,t2,t3;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = new ViewHolder();
        if(convertView==null){
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);

            holder.i1 = (ImageView) convertView.findViewById(R.id.placeimage);
            holder.t1 =(TextView) convertView.findViewById(R.id.stayName);
            holder.t2 =(TextView) convertView.findViewById(R.id.staylocation);
            holder.t3 =(TextView) convertView.findViewById(R.id.stayprice);

            final Food home = FoodList.get(position);
            holder.i1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    databaseReference = FirebaseDatabase.getInstance().getReference("Homestay").orderByChild("id").equalTo(home.getId());
                    databaseReference = FirebaseDatabase.getInstance().getReference();
                    Query getDetails = databaseReference.child("Food").orderByChild("id").equalTo(home.getId());

                    getDetails.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for(DataSnapshot ds : snapshot.getChildren()){
                                String key = ds.getKey();
                                Intent intent=new Intent(context,foodinfo.class);
                                intent.putExtra("Key", key);
                                context.startActivity(intent);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }

                    });
                }
            });

            convertView.setTag(holder);
        }else{
            holder=(ViewHolder) convertView.getTag();
        }

        Food homestay = FoodList.get(position);
        holder.t1.setText(homestay.getName());
        holder.t2.setText(homestay.getOperatinghrs());
        holder.t3.setText(homestay.getLocation());
        Picasso.with(context)
                .load(homestay.getImageUrl())
                .placeholder(R.mipmap.ic_launcher)
                .fit()
                .centerCrop()
                .into(holder.i1);

        return convertView;
    }
}
