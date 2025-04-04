package com.example.tlustudents;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentsAdapter extends RecyclerView.Adapter<StudentViewHolder> {
    private Student[] students;

    public StudentsAdapter(Student[] students) {
        this.students = students;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        ViewGroup parent = null;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent,false);
        

    }

    @Override
    public int getItemCount() {
        return students.length;
    }
}
