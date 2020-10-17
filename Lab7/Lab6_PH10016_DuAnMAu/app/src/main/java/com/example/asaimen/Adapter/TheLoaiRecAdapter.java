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

import com.example.asaimen.Dao.TheLoaiDao;
import com.example.asaimen.Model.TheLoai;
import com.example.asaimen.R;

import java.util.List;

public class TheLoaiRecAdapter extends RecyclerView.Adapter<TheLoaiRecAdapter.RecyclerViewHolder> {
    private Context context;
    private List<TheLoai> theLoaiList;
    private LayoutInflater inflater;
    public TheLoaiDao theLoaiDao;
    EditText tentl,vitri;

    public TheLoaiRecAdapter(Context context, List<TheLoai> theLoaiList) {
        this.context=context;
        this.theLoaiDao=new TheLoaiDao(context);
        this.theLoaiList=theLoaiList;
        this.inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.item_theloai, null);
        RecyclerViewHolder viewHolder=new RecyclerViewHolder(view);
        viewHolder.ivIcon=(ImageView) view.findViewById(R.id.ivIcon);
        viewHolder.tvMaTheLoai=(TextView) view.findViewById(R.id.tvMaTheLoai);
        viewHolder.tvTenTheLoai=(TextView) view.findViewById(R.id.tvTenTheLoai);
        viewHolder.ivDelete=(ImageView) view.findViewById(R.id.ivDelete);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, final int position) {
        final TheLoai theLoai=theLoaiList.get(position);
        holder.tvMaTheLoai.setText(theLoai.getTenTL());
        holder.tvTenTheLoai.setText(theLoai.getViTri());
        holder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = theLoaiList.get(position).getMaTL();
                theLoaiDao.DeleteTheLoai(a);//xoa trong database
                TheLoai theLoai = theLoaiList.get(position);
                theLoaiList.remove(theLoai);//xoa trong list
                notifyDataSetChanged();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final View layout = inflater.inflate(R.layout.activity_nguoi_dung_detail,null);
                AlertDialog.Builder builder =   new AlertDialog.Builder(context);
                builder.setTitle("Sua");
                builder.setView(layout);
                builder.setCancelable(false);
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tentl=layout.findViewById(R.id.edPhone);
                        vitri=layout.findViewById(R.id.edFullName);
                        theLoaiDao = new TheLoaiDao(context);
                        theLoai.setTenTL(tentl.getText().toString());
                        theLoai.setViTri(vitri.getText().toString());
                        theLoaiDao.updateTheLoai(theLoai);
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
        return theLoaiList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        ImageView ivIcon, ivDelete;
        TextView tvMaTheLoai, tvTenTheLoai;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            this.ivIcon=ivIcon;
            this.tvMaTheLoai=tvMaTheLoai;
            this.tvTenTheLoai=tvTenTheLoai;
            this.ivDelete=ivDelete;
        }
    }
}
