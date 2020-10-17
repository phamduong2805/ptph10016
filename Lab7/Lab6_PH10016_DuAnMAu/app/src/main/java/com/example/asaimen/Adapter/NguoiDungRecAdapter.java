package com.example.asaimen.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asaimen.Dao.NguoiDungDao;
import com.example.asaimen.Model.NguoiDung;
import com.example.asaimen.NguoiDungActivity;
import com.example.asaimen.NguoiDungDetailActivity;
import com.example.asaimen.R;

import java.util.List;

public class NguoiDungRecAdapter extends RecyclerView.Adapter<NguoiDungRecAdapter.RecyclerViewHolder> {
    private Context context;
    List<NguoiDung> arrNguoiDung;
    private LayoutInflater inflater;
    public NguoiDungDao nguoiDungDao;

    public NguoiDungRecAdapter(Context context, List<NguoiDung> arrNguoiDung) {
        this.context=context;
        this.nguoiDungDao=new NguoiDungDao(context);
        this.arrNguoiDung=arrNguoiDung;
        this.inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    //tao view
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, final int i) {
        View view=inflater.inflate(R.layout.item_nguoi_dung, null);
        RecyclerViewHolder viewHolder=new RecyclerViewHolder(view);
        viewHolder.ivIcon=(ImageView) view.findViewById(R.id.ivIcon);
        viewHolder.tvName=(TextView) view.findViewById(R.id.tvName);
        viewHolder.tvPhone=(TextView) view.findViewById(R.id.tvPhone);
        viewHolder.ivDelete=(ImageView) view.findViewById(R.id.ivDelete);

        return viewHolder;
    }

    //gan du lieu
    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        NguoiDung nguoiDung=arrNguoiDung.get(position);
        holder.tvName.setText(nguoiDung.getUserName());
        holder.tvPhone.setText(nguoiDung.getPhone());
        holder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //lay id
                //xoa trong db
                String a=arrNguoiDung.get(position).getUserName();
                nguoiDungDao.DeleteNguoiDungBuID(a);
                NguoiDung nguoiDung=arrNguoiDung.get(position);
                arrNguoiDung.remove(nguoiDung);//xoa list
                //cap nhat thay doi
                notifyDataSetChanged();

            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context=view.getContext();
                Intent intent=new Intent(context, NguoiDungDetailActivity.class);

                Bundle bundle=new Bundle();
                //bundle.putString("userName_key");

                //  Bundle bundle  = new Bundle();
                bundle.putString("userName_key", arrNguoiDung.get(position).getUserName());
                bundle.putString("passWord_key", arrNguoiDung.get(position).getPassWord());
                bundle.putString("phone_key", arrNguoiDung.get(position).getPhone());
                bundle.putString("hoTen_key", arrNguoiDung.get(position).getHoTen());

                intent.putExtras(bundle);
                context.startActivity(intent);

//

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

