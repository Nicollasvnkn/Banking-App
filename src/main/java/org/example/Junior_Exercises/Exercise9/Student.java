package org.example.Junior_Exercises.Exercise9;

public class Student extends Person{
    private String course;
    private String registrationId;

    public Student(String name, int age, String course, String registrationId) {
        super(name, age);
        this.course = course;
        this.registrationId = registrationId;
    }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public String getRegistrationId() { return registrationId; }
    public void setRegistrationId(String registrationId) { this.registrationId = registrationId; }

    @Override
    public String introduce() {
        return super.introduce() + "i'm studying " + course + " (ID: " + registrationId + ").";
    }

    @Override
    public String toString(){
        return "Student{name='" + getName() + "', age=" + getAge() +
                ", course='" + course + "' resistrationId='" + registrationId + "'}";
    }
}