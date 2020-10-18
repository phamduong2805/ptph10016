package com.example.asaimen.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asaimen.Dao.HoaDonChiTietDao;
import com.example.asaimen.Dao.NguoiDungDao;
import com.example.asaimen.Model.HoaDonChiTiet;
import com.example.asaimen.R;

import java.util.List;

public class HoDonChiTietRecAdapter extends RecyclerView.Adapter<HoDonChiTietRecAdapter.RecyclerViewHoder> {
    private Context context;
    private List<HoaDonChiTiet> hoaDonChiTietList;
    private LayoutInflater inflater;
    public HoaDonChiTietDao hoaDonChiTietDao;
    EditText username,phone;

    public HoDonChiTietRecAdapter(Context context,List<HoaDonChiTiet> hoaDonChiTietList){
        this.context=context;
        this.hoaDonChiTietDao=new HoaDonChiTietDao(context);
        this.hoaDonChiTietList=hoaDonChiTietList;
        this.inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @NonNull
    @Override
    public RecyclerViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =inflater.inflate(R.layout.item_hoadon,null);
            RecyclerViewHoder hoder = new RecyclerViewHoder(view);
        hoder.ivIcon=(ImageView) view.findViewById(R.id.ivIcon);
        hoder.tvMaSach=(TextView) view.findViewById(R.id.tvMaHoaDon);
        hoder.tvSoLuongMua=(TextView) view.findViewById(R.id.tvNgayMua);
        hoder.ivDelete=(ImageView) view.findViewById(R.id.ivDelete4);
        return hoder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHoder holder, final int position) {
        final HoaDonChiTiet hoaDonChiTiet = hoaDonChiTietList.get(position);
        holder.tvMaSach.setText(hoaDonChiTiet.getMaSach());
        holder.tvSoLuongMua.setText(hoaDonChiTiet.getSoLuongMua());
        holder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = hoaDonChiTietList.get(position).getMaHoaDon();
                hoaDonChiTietDao.DeleteHoDonChiTiet(a);

                HoaDonChiTiet hoaDonChiTiet = hoaDonChiTietList.get(position);
                hoaDonChiTietList.remove(hoaDonChiTiet);
                notifyDataSetChanged();
            }
        });


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
                        hoaDonChiTietDao = new HoaDonChiTietDao(context);
                        hoaDonChiTiet.setMaSach(username.getText().toString());
                        hoaDonChiTiet.setSoLuongMua(phone.getText().toString());
                        hoaDonChiTietDao.Update(hoaDonChiTiet);
                        notifyDataSetChanged();
                        Toast.makeText(context, "Update thành công", Toast.LENGTH_LONG).show();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });


    }

    @Override
    public int getItemCount() {
        return hoaDonChiTietList.size();
    }

    public class RecyclerViewHoder extends RecyclerView.ViewHolder{
        ImageView ivIcon, ivDelete;
        TextView tvMaSach, tvSoLuongMua;


        public RecyclerViewHoder(@NonNull View itemView) {
            super(itemView);
            this.ivIcon=ivIcon;
            this.ivDelete=ivDelete;
            this.tvMaSach=tvMaSach;
            this.tvSoLuongMua=tvSoLuongMua;
        }

    }



}
