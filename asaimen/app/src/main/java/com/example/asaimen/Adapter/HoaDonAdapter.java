package com.example.asaimen.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asaimen.Dao.HoaDonChiTietDao;
import com.example.asaimen.Dao.HoaDonDao;
import com.example.asaimen.Model.HoaDon;
import com.example.asaimen.Model.HoaDonChiTiet;
import com.example.asaimen.R;

import java.util.ArrayList;
import java.util.List;

public class HoaDonAdapter extends BaseAdapter {
    List<HoaDon> hoaDonList;
    List<HoaDon> arrHoaDon;
    Context context;
    public LayoutInflater inflater;
    HoaDonDao hoaDonDao;

    public HoaDonAdapter(Context context,List<HoaDon> hoaDonList){
        this.context=context;
        this.hoaDonList=hoaDonList;
        this.inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        hoaDonDao=new HoaDonDao(context);
    };
    @Override
    public int getCount() {
        return hoaDonList.size();
    }

    @Override
    public Object getItem(int i) {
        return hoaDonList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final  int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;
        if(view==null)
        {
            //tao view
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.item_hoadon,null);
            holder.ivIcon=(ImageView) view.findViewById(R.id.ivIcon);
            holder.tvMaHoaDon=(TextView) view.findViewById(R.id.tvMaHoaDon);
            holder.tvNgayMua=(TextView) view.findViewById(R.id.tvNgayMua);
            holder.ivDelete=(ImageView) view.findViewById(R.id.ivDelete4);

            holder.ivDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    HoaDon hoaDon = hoaDonList.get(i);
                    hoaDonList.remove(hoaDon);//xoa trong list, but doen't remove it in database
                    //update
                    hoaDonDao.deleteHoaDon(hoaDon.getMaHoaDon());//delete the NguoiDung in database
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
        HoaDon hoaDon = (HoaDon) hoaDonList.get(i);
        holder.tvMaHoaDon.setText(hoaDon.getMaHoaDon());
        holder.tvNgayMua.setText(hoaDon.getNgayMua().toString());

        return view;
    }
    public static class ViewHolder {
        ImageView ivIcon, ivDelete;
        TextView tvMaHoaDon, tvNgayMua;
    }


}
