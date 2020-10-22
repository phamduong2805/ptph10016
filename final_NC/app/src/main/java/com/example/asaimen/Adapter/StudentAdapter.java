package com.example.asaimen.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asaimen.Dao.StudentDao;
import com.example.asaimen.Model.Student;
import com.example.asaimen.R;

import java.util.List;

public class StudentAdapter extends BaseAdapter {
    private List<Student> studentList ;
    private Context context;
     public LayoutInflater inflater;
    StudentDao studentDao;

    public StudentAdapter(Context context, List<Student> studentList) {
        this.context=context;
        this.studentDao=new StudentDao(context);
        this.studentList=studentList;
        this.inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {
        return studentList.size();
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
//        view = inflater.inflate(R.layout.item_student,null);
//        TextView tvMaLop= view.findViewById(R.id.tvMaLop1);
//        TextView tvMaSV= view.findViewById(R.id.tvMaSV1);
//        TextView tvTenSV= view.findViewById(R.id.tvTenSV1);
//        ImageView imDelete = view.findViewById(R.id.ivDelete);
//        imDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String a = studentList.get(i).getMaSV();
//                  studentDao.DeleteStudent(a);
//                 Student student = studentList.get(i);
//                 studentList.remove(student);
//                 notifyDataSetChanged();
//
//            }
//        });
//
//        Student student = studentList.get(i);
//
//        tvMaSV.setText(student.getMaSV());
//        tvTenSV.setText(student.getTenSV());
//        tvMaLop.setText(student.getMaLop());

        viewHoder hoder;
        if (view==null){
            view=inflater.inflate(R.layout.item_student,null);
            hoder= new viewHoder();
            hoder.tvMaSV=(TextView)view.findViewById(R.id.tvMaSV1);
            hoder.tvTenSV=(TextView)view.findViewById(R.id.tvTenSV1);
            hoder.tvMaLop=(TextView)view.findViewById(R.id.tvMaLop1);
            hoder.imDelete=(ImageView)view.findViewById(R.id.ivDelete);
            hoder.imDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String a = studentList.get(i).getMaSV();
                    studentDao.DeleteStudent(a);//xoa trong database
                    Student student = studentList.get(i);
                    studentList.remove(student);
                    notifyDataSetChanged();
                }
            });

            view.setTag(hoder);

        }else {
            hoder=(viewHoder)view.getTag();
        }
        Student student = studentList.get(i);
           hoder.tvMaSV.setText(student.getMaSV());
           hoder.tvTenSV.setText(student.getTenSV());
           hoder.tvMaLop.setText(student.getMaLop());
        return view;
    }
    public static class viewHoder{
        TextView tvMaLop,tvTenSV,tvMaSV;
        ImageView imDelete;
    }
}
