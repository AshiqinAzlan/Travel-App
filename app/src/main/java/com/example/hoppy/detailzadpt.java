package com.example.hoppy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class detailzadpt extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<bookingobject> FoodList;

    DatabaseReference databaseReference;
    FirebaseUser user;
    String id;
    String uid;

    public detailzadpt(Context context, int layout, ArrayList<bookingobject> foodList) {
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
        TextView t1,t2,t3,t4,t5,t6;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        if(convertView==null){
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);

            holder.t1 =(TextView) convertView.findViewById(R.id.firstname);
            holder.t2 =(TextView) convertView.findViewById(R.id.lastname);
            holder.t3 =(TextView) convertView.findViewById(R.id.email);
            holder.t4 =(TextView) convertView.findViewById(R.id.id);
            holder.t5 =(TextView) convertView.findViewById(R.id.number);
            holder.t6 =(TextView) convertView.findViewById(R.id.booking);



            convertView.setTag(holder);
        }else{
            holder=(ViewHolder) convertView.getTag();
        }

        bookingobject homestay = FoodList.get(position);
        holder.t1.setText(homestay.getfName());
        holder.t2.setText(homestay.getlName());
        holder.t3.setText(homestay.getEmail());
        holder.t4.setText(homestay.getNum());
        holder.t5.setText(homestay.getHomestayid());
        holder.t6.setText(homestay.getBooking());


        return convertView;
    }
}
