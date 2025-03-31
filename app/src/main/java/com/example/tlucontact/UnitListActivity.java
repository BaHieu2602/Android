package com.example.tlucontact;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class UnitListActivity extends AppCompatActivity {
    private List<Unit> unitList;
    private UnitAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_list);

        recyclerView = findViewById(R.id.recyclerViewUnits);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        unitList = new ArrayList<>();
        loadInitialData();

        adapter = new UnitAdapter(unitList,
                this::onEditClick,
                this::onDeleteClick);
        recyclerView.setAdapter(adapter);

        // Nút Thêm đơn vị
        Button btnAdd = findViewById(R.id.btnAddUnit);
        btnAdd.setOnClickListener(v -> showAddUnitDialog());

        // Nút quay lại
        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> finish());
    }

    private void loadInitialData() {
        unitList.add(new Unit("Phòng Đào Tạo", "0123456789", "Tòa nhà A1"));
        unitList.add(new Unit("Phòng Tổ Chức", "0987654321", "Tòa nhà A2"));
        unitList.add(new Unit("Phòng Công Tác Sinh Viên", "0345678912", "Tòa nhà A3"));
        unitList.add(new Unit("Phòng Hành Chính - Quản Trị", "0912345678", "Tòa nhà A4"));
    }

    private void showAddUnitDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thêm Đơn Vị");

        LinearLayout layout = createUnitInputLayout(null);
        builder.setView(layout);

        builder.setPositiveButton("Thêm", (dialog, which) -> {
            Unit newUnit = getUnitFromInput(layout);
            if (newUnit != null) {
                unitList.add(newUnit);
                adapter.notifyItemInserted(unitList.size() - 1);
                recyclerView.scrollToPosition(unitList.size() - 1);
                Toast.makeText(this, "Đã thêm đơn vị", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Hủy", null);
        builder.show();
    }

    private void showEditUnitDialog(int position) {
        Unit selectedUnit = unitList.get(position);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Sửa Đơn Vị");

        LinearLayout layout = createUnitInputLayout(selectedUnit);
        builder.setView(layout);

        builder.setPositiveButton("Lưu", (dialog, which) -> {
            Unit updatedUnit = getUnitFromInput(layout);
            if (updatedUnit != null) {
                unitList.set(position, updatedUnit);
                adapter.notifyItemChanged(position);
                Toast.makeText(this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Hủy", null);
        builder.show();
    }

    private void showDeleteUnitDialog(int position) {
        new AlertDialog.Builder(this)
                .setTitle("Xóa Đơn Vị")
                .setMessage("Bạn có chắc muốn xóa đơn vị này?")
                .setPositiveButton("Xóa", (dialog, which) -> {
                    unitList.remove(position);
                    adapter.notifyItemRemoved(position);
                    adapter.notifyItemRangeChanged(position, unitList.size());
                    Toast.makeText(this, "Xóa thành công", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("Hủy", null)
                .show();
    }

    private void onEditClick(View v) {
        int position = (int) v.getTag();
        if (position >= 0 && position < unitList.size()) {
            showEditUnitDialog(position);
        }
    }

    private void onDeleteClick(View v) {
        int position = (int) v.getTag();
        if (position >= 0 && position < unitList.size()) {
            showDeleteUnitDialog(position);
        }
    }

    private LinearLayout createUnitInputLayout(Unit unit) {
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(30, 20, 30, 20);

        EditText inputName = new EditText(this);
        inputName.setHint("Tên đơn vị");
        inputName.setText(unit != null ? unit.getName() : "");
        layout.addView(inputName);

        EditText inputPhone = new EditText(this);
        inputPhone.setHint("Số điện thoại");
        inputPhone.setInputType(InputType.TYPE_CLASS_PHONE);
        inputPhone.setText(unit != null ? unit.getPhone() : "");
        layout.addView(inputPhone);

        EditText inputLocation = new EditText(this);
        inputLocation.setHint("Địa điểm");
        inputLocation.setText(unit != null ? unit.getLocation() : "");
        layout.addView(inputLocation);

        return layout;
    }

    private Unit getUnitFromInput(LinearLayout layout) {
        EditText inputName = (EditText) layout.getChildAt(0);
        EditText inputPhone = (EditText) layout.getChildAt(1);
        EditText inputLocation = (EditText) layout.getChildAt(2);

        String name = inputName.getText().toString().trim();
        String phone = inputPhone.getText().toString().trim();
        String location = inputLocation.getText().toString().trim();

        if (name.isEmpty() || phone.isEmpty() || location.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            return null;
        }

        return new Unit(name, phone, location);
    }
}
