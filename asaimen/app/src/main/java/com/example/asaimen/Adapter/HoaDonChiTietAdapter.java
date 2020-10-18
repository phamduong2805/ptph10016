package com.example.asaimen.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.asaimen.Dao.HoaDonChiTietDao;
import com.example.asaimen.ListHoaDonActivity;
import com.example.asaimen.Model.HoaDon;
import com.example.asaimen.Model.HoaDonChiTiet;
import com.example.asaimen.R;

import java.util.List;

public class HoaDonChiTietAdapter extends BaseAdapter {
    List<HoaDonChiTiet> hoaDonChiTietList;
    Context context;
    public LayoutInflater inflater;
    HoaDonChiTietDao hoaDonChiTietDao;
    public HoaDonChiTietAdapter(Context context,List<HoaDonChiTiet> hoaDonChiTietList){
this.context=context;
this.hoaDonChiTietList=hoaDonChiTietList;
this.inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
hoaDonChiTietDao=new HoaDonChiTietDao(context);
    };



    @Override
    public int getCount() {
        return hoaDonChiTietList.size();
    }

    @Override
    public Object getItem(int i) {
        return hoaDonChiTietList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;
        if(view==null)
        {
            //tao view
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.item_hoadon,null);
            holder.ivIcon=(ImageView) view.findViewById(R.id.ivIcon);
            holder.tvMaSach=(TextView) view.findViewById(R.id.tvMaHoaDon);
            holder.tvSoLuongMua=(TextView) view.findViewById(R.id.tvNgayMua);
            holder.ivDelete=(ImageView) view.findViewById(R.id.ivDelete4);

            holder.ivDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    HoaDonChiTiet nd = hoaDonChiTietList.get(i);
                    hoaDonChiTietList.remove(nd);//xoa trong list, but doen't remove it in database
                   //update
                    hoaDonChiTietDao.DeleteHoDonChiTiet(nd.getMaHoaDon());//delete the NguoiDung in database
                    notifyDataSetChanged();
                }
            });

            //tao template tu view
            view.setTag(holder);
        }
        else //lay view da ton tai
        {
            holder = (ViewHolder)view.getTag();
        }
        //lay du lieu
        HoaDonChiTiet nd = (HoaDonChiTiet) hoaDonChiTietList.get(i);
        holder.tvMaSach.setText(nd.getMaSach());
        holder.tvSoLuongMua.setText(nd.getMaHoaDon());

        return view;
    }
    public static class ViewHolder {
        ImageView ivIcon, ivDelete;
        TextView tvMaSach, tvSoLuongMua;
    }
    public void changeDataset(List<HoaDonChiTiet> ls)
    {
        this.hoaDonChiTietList = ls;
        notifyDataSetChanged();
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
}
