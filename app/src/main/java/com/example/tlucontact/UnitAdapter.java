package com.example.tlucontact;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.List;

public class UnitAdapter extends RecyclerView.Adapter<UnitAdapter.UnitViewHolder> {
    private List<Unit> unitList;
    private View.OnClickListener editListener, deleteListener;

    public UnitAdapter(List<Unit> unitList, View.OnClickListener editListener, View.OnClickListener deleteListener) {
        this.unitList = unitList;
        this.editListener = editListener;
        this.deleteListener = deleteListener;
    }

    @NonNull
    @Override
    public UnitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_unit, parent, false);
        return new UnitViewHolder(view);
    }

    @Override

    public void onBindViewHolder(UnitViewHolder holder, int position) {
        if (unitList == null || unitList.isEmpty()) {
            return;
        }

        Unit unit = unitList.get(position);
        if (unit == null) {
            return;
        }

        holder.tvUnitName.setText(unit.getName() != null ? unit.getName() : "Không có tên");
        holder.tvUnitPhone.setText(unit.getPhone() != null ? unit.getPhone() : "Không có số điện thoại");
        holder.tvLocation.setText(unit.getLocation() != null ? unit.getLocation() : "Không có địa điểm");

        // Xử lý sự kiện khi nhấn nút sửa
        holder.btnEditUnit.setOnClickListener(v -> {
            if (editListener != null) {
                v.setTag(position);
                editListener.onClick(v);
            }
        });

        // Xử lý sự kiện khi nhấn nút xóa
        holder.btnDeleteUnit.setOnClickListener(v -> {
            if (deleteListener != null) {
                v.setTag(position);
                deleteListener.onClick(v);
            }
        });
    }



    @Override
    public int getItemCount() {
        return unitList.size();
    }
    public void updateUnit(int position, Unit newUnit) {
        unitList.set(position, newUnit);
        notifyItemChanged(position);
    }
    public void removeUnit(int position) {
        unitList.remove(position);
        notifyItemRemoved(position);
    }



    public static class UnitViewHolder extends RecyclerView.ViewHolder {
        TextView tvUnitName, tvUnitPhone, tvLocation;
        Button btnEditUnit, btnDeleteUnit; // Thêm hai nút này

        public UnitViewHolder(View itemView) {
            super(itemView);
            tvUnitName = itemView.findViewById(R.id.tvUnitName);
            tvUnitPhone = itemView.findViewById(R.id.tvUnitPhone);
            tvLocation = itemView.findViewById(R.id.tvLocation);
            btnEditUnit = itemView.findViewById(R.id.btnEditUnit);  // Nút sửa
            btnDeleteUnit = itemView.findViewById(R.id.btnDeleteUnit); // Nút xóa
        }
    }



}
