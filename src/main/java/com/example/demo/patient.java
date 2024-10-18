package com.example.demo;

public class patient  extends person{
    private int   age ;   // repalce it by room
    private String  gender;  // replace it by state

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
