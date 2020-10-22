package com.example.asaimen.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asaimen.Dao.NguoiDungDao;
import com.example.asaimen.Model.NguoiDung;
import com.example.asaimen.R;

import java.util.List;

public class NguoiDungAdapter extends BaseAdapter {
    List<NguoiDung> arrNguoiDung;
    Context context;
    public LayoutInflater inflater;
    NguoiDungDao nguoiDungDao;

    public NguoiDungAdapter(Activity context, List<NguoiDung> arrNguoiDung) {
        super();
        this.context=context;
        this.arrNguoiDung=arrNguoiDung;
        this.inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        NguoiDungDao nguoiDungDao=new NguoiDungDao(context);
    }

    @Override
    public int getCount() {
        return arrNguoiDung.size();
    }

    @Override
    public Object getItem(int i) {
        return arrNguoiDung.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {//chua co view,tao view va setTag
            holder=new ViewHolder();
            view=inflater.inflate(R.layout.item_nguoi_dung, null);
            holder.img=(ImageView) view.findViewById(R.id.ivIcon);
            holder.txtName=(TextView) view.findViewById(R.id.tvName);
            holder.txtPhone=(TextView) view.findViewById(R.id.tvPhone);
            holder.imgDelete=(ImageView) view.findViewById(R.id.ivDelete);
            holder.imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //lay id
                    //xoa trong database
                    //   nguoiDungDao.DeleteNguoiDungBuID(arrNguoiDung.get(i).getUserName());
                    NguoiDung nguoiDung=arrNguoiDung.get(i);
                    arrNguoiDung.remove(nguoiDung);//xoa tren list
                    //cap nhat thay doi
                    notifyDataSetChanged();
                }
            });
            //tao template view
            view.setTag(holder);
        } else {//neu da co view thi doc view
            holder=(ViewHolder) view.getTag();
        }
        //gan du lieu
        NguoiDung nguoiDung=(NguoiDung) arrNguoiDung.get(i);
        holder.txtName.setText(nguoiDung.getHoTen());
        holder.txtPhone.setText(nguoiDung.getPhone());
        return view;
    }

    public static class ViewHolder {
        ImageView img;
        TextView txtName, txtPhone;
        ImageView imgDelete;
    }
}
