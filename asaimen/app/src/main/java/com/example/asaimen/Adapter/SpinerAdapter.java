package com.example.asaimen.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.asaimen.Dao.SachDao;
import com.example.asaimen.Model.Sach;
import com.example.asaimen.Model.TheLoai;
import com.example.asaimen.R;

import java.util.List;

public class SpinerAdapter extends BaseAdapter {
    List<TheLoai> theLoaiList;
    Context context;
    public LayoutInflater inflater;
    SachDao sachDao;

    public SpinerAdapter(Context context, List<TheLoai> theLoaiList) {
        this.theLoaiList=theLoaiList;
        this.context=context;
        this.inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        sachDao=new SachDao(context);
    }

    @Override
    public int getCount() {
        return theLoaiList.size();
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=inflater.inflate(R.layout.spinner, null);
        TextView textView=view.findViewById(R.id.txt_spinner);
        TheLoai theLoai=theLoaiList.get(i);
        textView.setText(theLoai.getMaTL());
        return view;
    }
}
