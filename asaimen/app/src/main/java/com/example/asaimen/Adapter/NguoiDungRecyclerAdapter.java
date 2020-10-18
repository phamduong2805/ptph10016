package com.example.asaimen.Adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asaimen.Dao.NguoiDungDao;
import com.example.asaimen.Model.NguoiDung;
import com.example.asaimen.NguoiDungActivity;
import com.example.asaimen.R;
import com.google.android.material.textfield.TextInputEditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NguoiDungRecyclerAdapter extends RecyclerView.Adapter<NguoiDungRecyclerAdapter.RecyclerViewHolder> {
    private Context context;
    private List<NguoiDung> arrNguoiDung;
    private LayoutInflater inflater;
    public NguoiDungDao nguoiDungDao;
    EditText username,phone;

    public NguoiDungRecyclerAdapter(Context context, List<NguoiDung> arrNguoiDung) {
        this.context=context;
        this.nguoiDungDao=new NguoiDungDao(context);
        this.arrNguoiDung=arrNguoiDung;
        this.inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    //muon xoa phai click voa button delete
    //tao view
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, final int i) {
        View view=inflater.inflate(R.layout.item_nguoi_dung, null);
        RecyclerViewHolder viewHolder=new RecyclerViewHolder(view);
        viewHolder.ivIcon=(ImageView) view.findViewById(R.id.ivIcon);
        viewHolder.tvName=(TextView) view.findViewById(R.id.tvName);
        viewHolder.tvPhone=(TextView) view.findViewById(R.id.tvPhone);
        viewHolder.ivDelete=(ImageView) view.findViewById(R.id.ivDelete);
        //thuc hien su kien delete

        return viewHolder;
    }

    //gan du lieu
    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        final NguoiDung nguoiDung=arrNguoiDung.get(position);
        holder.tvName.setText(nguoiDung.getUserName());
        holder.tvPhone.setText(nguoiDung.getPhone());
        holder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //xoa trong db
                String userName=arrNguoiDung.get(position).getUserName();//lay ve ten nguoi dung thu i
                nguoiDungDao.DeleteNguoiDungBuID(userName);
                //xoa tren recycler view
                NguoiDung nguoiDung=arrNguoiDung.get(position);//lay ve nguoi dunh o vi tri thu i
                arrNguoiDung.remove(nguoiDung);//thuc hien xoa trong arrayList
                //cap nhat len recyclerView
                notifyDataSetChanged();
            }
        });
        //khi click vao 1 dong (itemView tren recyclerView)
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final View layout = inflater.inflate(R.layout.activity_nguoi_dung_detail, null);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Sửa");
                builder.setView(layout);
                builder.setCancelable(false);
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        username = layout.findViewById(R.id.edPhone);
                        phone = layout.findViewById(R.id.edFullName);
                        nguoiDungDao = new NguoiDungDao(context);
                        nguoiDung.setHoTen(username.getText().toString());
                        nguoiDung.setPhone(phone.getText().toString());
                        nguoiDungDao.update(nguoiDung);
                        notifyDataSetChanged();
                            Toast.makeText(context, "Update thành công", Toast.LENGTH_LONG).show();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });

    }

    //tinh so luong
    @Override
    public int getItemCount() {
        return arrNguoiDung.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        ImageView ivIcon;
        TextView tvName;
        TextView tvPhone;
        ImageView ivDelete;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            this.ivIcon=ivIcon;
            this.tvName=tvName;
            this.tvPhone=tvPhone;
            this.ivDelete=ivDelete;
        }
    }
}