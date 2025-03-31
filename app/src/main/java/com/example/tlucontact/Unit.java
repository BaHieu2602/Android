package com.example.tlucontact;

public class Unit {
    private String name;
    private String phone;
    private String location;

    public Unit(String name, String phone, String location) {
        this.name = name;
        this.phone = phone;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {  // Thêm phương thức này
        return location;
    }

    public void setLocation(String location) {  // Thêm phương thức này
        this.location = location;
    }
}
