package com.ncic.stream.pojo;

import java.util.Objects;

public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private double height;

    public Student() {
    }

    public Student(String name, Integer age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public Student(Integer id,String name, Integer age, double height) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Double.compare(student.getHeight(), height) == 0 &&
                Objects.equals(name, student.getName()) &&
                Objects.equals(age, student.getAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getHeight());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
}
