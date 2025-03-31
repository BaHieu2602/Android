package com.example.tlucontact;

public class Employee {
    private String name;
    private String position;
    private String phone;
    private String email;
    private String department;

    public Employee(String name, String position, String phone, String email, String department) {
        this.name = name;
        this.position = position;
        this.phone = phone;
        this.email = email;
        this.department = department;
    }

    public String getName() { return name; }
    public String getPosition() { return position; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public String getDepartment() { return department; }
}
