package com.example.asaimen.Adapter;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asaimen.Dao.LopDao;
import com.example.asaimen.Dao.StudentDao;
import com.example.asaimen.Model.Lop;
import com.example.asaimen.R;
import com.example.asaimen.activity_list_class;

import java.util.ArrayList;
import java.util.List;

public class LopAdapter extends BaseAdapter {
    List<Lop> arrLop;
    Context context;
    public LayoutInflater inflater;
    LopDao lopDao;

    public LopAdapter(Context context, List<Lop> arrLop) {
        this.context=context;
        this.lopDao=new LopDao(context);
        this.arrLop=arrLop;
        this.inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public int getCount() {
        return arrLop.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup parent) {
//        view = inflater.from(parent.getContext()).inflate(R.layout.ruw,parent,false);
//        TextView stt = view.findViewById(R.id.txtr1);
//        TextView maLop = view.findViewById(R.id.txtr2);
//        TextView tenLop = view.findViewById(R.id.txtr3);
//        ImageView ivDelete = view.findViewById(R.id.ivDeletelop);
//        ivDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//               String a = arrLop.get(i).getMaLop();
//               lopDao.DeleteLop(a);
//               Lop lop = arrLop.get(i);
//               arrLop.remove(lop);
//               notifyDataSetChanged();
//
//            }
//        });
//        Lop lop = arrLop.get(i);
//
//        String s = String.valueOf(i);
//        stt.setText(s);
//        maLop.setText(lop.maLop);
//        tenLop.setText(lop.tenLop);


        viewHoder hoder;
        if (view == null) {
            hoder=new viewHoder();
            view=inflater.inflate(R.layout.ruw, null);
            hoder.stt=(TextView) view.findViewById(R.id.txtr1);
            hoder.maLop=(TextView) view.findViewById(R.id.txtr2);
            hoder.tenLop=(TextView) view.findViewById(R.id.txtr3);
            hoder.ivDelete=(ImageView) view.findViewById(R.id.ivDeletelop);
            hoder.ivDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String a =arrLop.get(i).getMaLop();
                    lopDao.DeleteLop(a);//xoa trong database
                    Lop lop = arrLop.get(i);
                    arrLop.remove(lop);//xoa trong list
                    notifyDataSetChanged();
                }
            });
            view.setTag(hoder);
        } else {
            hoder=(viewHoder) view.getTag();
        }
        Lop lop=(Lop) arrLop.get(i);
        String s=String.valueOf(i);
        hoder.stt.setText(s);
        hoder.maLop.setText(lop.getMaLop());
        hoder.tenLop.setText(lop.getTenLop());
        return view;

    }

    public static class viewHoder {
        ImageView ivDelete;
        TextView stt, maLop, tenLop;

    }
}
