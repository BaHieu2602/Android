package com.example.tlustudents;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentViewHolder extends RecyclerView.ViewHolder {
    private ImageView imAvatar;
    private TextView txtName;
    private TextView txtSid;
    public StudentViewHolder(@NonNull View itemView) {
        super(itemView);
        imAvatar = itemView.findViewById(R.id.avt);
        txtName = itemView.findViewById(R.id.txt_student_name);
        txtSid = itemView.findViewById(R.id.txt_student_sid);
    }

    public void bind(Student std){
        imAvatar.setImageResource(std.getAvatar());
        txtName.setText(std.getFullname());
        txtSid.setText(std.getSid());
    }
}
