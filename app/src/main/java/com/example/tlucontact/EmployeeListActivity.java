package com.example.tlucontact;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class EmployeeListActivity extends AppCompatActivity implements EmployeeAdapter.OnEmployeeActionListener {
    private List<Employee> employeeList;
    private EmployeeAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);

        recyclerView = findViewById(R.id.recyclerViewEmployees);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        employeeList = new ArrayList<>();
        loadInitialData();

        adapter = new EmployeeAdapter(employeeList, this, this);
        recyclerView.setAdapter(adapter);

        Button btnAdd = findViewById(R.id.btnAddEmployee);
        btnAdd.setOnClickListener(v -> showAddEmployeeDialog());

    }

    private void loadInitialData() {
        employeeList.add(new Employee("Lê Văn C", "Phó trưởng khoa", "0912345678", "c@tlu.edu.vn", "Khoa Xây Dựng"));
        employeeList.add(new Employee("Hoàng Thị D", "Trưởng bộ môn", "0923456789", "d@tlu.edu.vn", "Bộ môn Cơ khí"));
        employeeList.add(new Employee("Phạm Văn E", "Nhân viên", "0934567890", "e@tlu.edu.vn", "Phòng Hành Chính"));
        employeeList.add(new Employee("Nguyễn Thị F", "Chuyên viên", "0945678901", "f@tlu.edu.vn", "Phòng Đào Tạo"));
        employeeList.add(new Employee("Trần Văn G", "Giảng viên", "0956789012", "g@tlu.edu.vn", "Khoa Công Nghệ Thông Tin"));
        employeeList.add(new Employee("Đặng Thị H", "Thư ký", "0967890123", "h@tlu.edu.vn", "Văn Phòng Khoa"));
        employeeList.add(new Employee("Bùi Văn I", "Quản lý dự án", "0978901234", "i@tlu.edu.vn", "Phòng Khoa Học"));
        employeeList.add(new Employee("Lương Thị K", "Kế toán", "0989012345", "k@tlu.edu.vn", "Phòng Tài Chính"));
        employeeList.add(new Employee("Dương Văn M", "Trưởng phòng", "0990123456", "m@tlu.edu.vn", "Phòng Hợp Tác Quốc Tế"));
        employeeList.add(new Employee("Ngô Thị N", "Nhân viên thư viện", "0901234567", "n@tlu.edu.vn", "Thư Viện"));
    }


    private void showAddEmployeeDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thêm Nhân Viên");

        LinearLayout layout = createEmployeeInputLayout(null);
        builder.setView(layout);

        builder.setPositiveButton("Thêm", (dialog, which) -> {
            Employee newEmployee = getEmployeeFromInput(layout);
            if (newEmployee != null) {
                employeeList.add(newEmployee);
                adapter.notifyItemInserted(employeeList.size() - 1);
                Toast.makeText(this, "Đã thêm nhân viên", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Hủy", null);
        builder.show();
    }

    private void showEditEmployeeDialog(int position) {
        Employee employee = employeeList.get(position);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Chỉnh sửa Nhân Viên");

        LinearLayout layout = createEmployeeInputLayout(employee);
        builder.setView(layout);

        builder.setPositiveButton("Lưu", (dialog, which) -> {
            Employee updatedEmployee = getEmployeeFromInput(layout);
            if (updatedEmployee != null) {
                employeeList.set(position, updatedEmployee);
                adapter.notifyItemChanged(position);
                Toast.makeText(this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Hủy", null);
        builder.show();
    }

    private void showDeleteEmployeeDialog(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Xóa nhân viên");
        builder.setMessage("Bạn có chắc muốn xóa nhân viên này không?");

        builder.setPositiveButton("Xóa", (dialog, which) -> {
            employeeList.remove(position);
            adapter.notifyItemRemoved(position);
            Toast.makeText(this, "Xóa thành công", Toast.LENGTH_SHORT).show();
        });

        builder.setNegativeButton("Hủy", null);
        builder.show();
    }

    private LinearLayout createEmployeeInputLayout(Employee employee) {
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(30, 20, 30, 20);

        EditText inputName = new EditText(this);
        inputName.setHint("Tên nhân viên");
        inputName.setText(employee != null ? employee.getName() : "");
        layout.addView(inputName);

        EditText inputPosition = new EditText(this);
        inputPosition.setHint("Chức vụ");
        inputPosition.setText(employee != null ? employee.getPosition() : "");
        layout.addView(inputPosition);

        EditText inputPhone = new EditText(this);
        inputPhone.setHint("Số điện thoại");
        inputPhone.setInputType(InputType.TYPE_CLASS_PHONE);
        inputPhone.setText(employee != null ? employee.getPhone() : "");
        layout.addView(inputPhone);

        return layout;
    }

    private Employee getEmployeeFromInput(LinearLayout layout) {
        EditText inputName = (EditText) layout.getChildAt(0);
        EditText inputPosition = (EditText) layout.getChildAt(1);
        EditText inputPhone = (EditText) layout.getChildAt(2);

        String name = inputName.getText().toString().trim();
        String position = inputPosition.getText().toString().trim();
        String phone = inputPhone.getText().toString().trim();

        if (name.isEmpty() || position.isEmpty() || phone.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            return null;
        }

        return new Employee(name, position, phone, "email@tlu.edu.vn", "Phòng Ban");
    }

    @Override
    public void onEditEmployee(int position) {
        showEditEmployeeDialog(position);
    }

    @Override
    public void onDeleteEmployee(int position) {
        showDeleteEmployeeDialog(position);
    }

}
