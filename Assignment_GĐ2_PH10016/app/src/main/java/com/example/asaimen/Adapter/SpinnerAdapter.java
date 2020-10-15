package com.example.asaimen.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.asaimen.Dao.LopDao;
import com.example.asaimen.Model.Lop;
import com.example.asaimen.R;
import com.example.asaimen.activity_add_student;

import java.util.ArrayList;
import java.util.List;

public class SpinnerAdapter extends BaseAdapter {
    List<Lop> arrLop;
    Context context;
    public LayoutInflater inflater;
    LopDao lopDao;

    public SpinnerAdapter(Context context,List<Lop> arrLop) {
        this.arrLop=arrLop;
        this.context=context;
        this.arrLop=arrLop;
        this.inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LopDao nguoiDungDao=new LopDao(context);
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
    public View getView(int i, View view, ViewGroup parent) {
        view = inflater.inflate(R.layout.spinner,null);
        TextView textView = view.findViewById(R.id.txt_spinner);
        Lop lop = arrLop.get(i);
        textView.setText(lop.getMaLop());
        return view;
    }
}
