package com.example.asaimen.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asaimen.Dao.SachDao;
import com.example.asaimen.Model.Sach;
import com.example.asaimen.R;

import java.util.List;

public class SachRecAdapter extends RecyclerView.Adapter<SachRecAdapter.RecyViewHolder>  {
    private Context context;
    private List<Sach> sachList;
    private LayoutInflater inflater;
    public SachDao sachDao;

    public SachRecAdapter(Context context,List<Sach> sachList){
        this.context=context;
        this.sachDao=new SachDao(context);
        this.sachList=sachList;
        this.inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @NonNull
    @Override
    public RecyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =inflater.inflate(R.layout.item_book,null);
        RecyViewHolder viewHolder =new RecyViewHolder(view);
        viewHolder.ivIcon=(ImageView)view.findViewById(R.id.ivIcon);
        viewHolder.tvBookName=(TextView)view.findViewById(R.id.tvBookName);
        viewHolder.tvSoLuong=(TextView)view.findViewById(R.id.tvSoLuong);
        viewHolder.tvBookPrice=(TextView)view.findViewById(R.id.tvBookPrice);
        viewHolder.ivDelete=(ImageView)view.findViewById(R.id.ivDelete);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyViewHolder holder, final int position) {
        final Sach sach =sachList.get(position);
        holder.tvBookName.setText(sach.getTenSach());
        holder.tvSoLuong.setText(sach.getSoLuong());
        holder.tvBookPrice.setText(sach.getGiaBan());
        holder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = sachList.get(position).getMaSach();
                sachDao.DeleteSach(a);
                Sach sach = sachList.get(position);
                sachList.remove(sach);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return sachList.size();
    }

    public class RecyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivIcon, ivDelete;
        TextView tvBookName, tvSoLuong, tvBookPrice;

        public RecyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.ivIcon=ivIcon;
            this.tvBookName=tvBookName;
            this.tvSoLuong=tvSoLuong;
            this.tvBookPrice=tvBookPrice;
            this.ivDelete=ivDelete;
        }
    }

}
