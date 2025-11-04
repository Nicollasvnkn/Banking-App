package org.example.Junior_Exercises.Exercise9;

public class Person {
    private String name;
    private final int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }

    public String introduce (){
        return "Hi, I'm " + name + " and i'm " + age + " years old. ";
    }

    @Override
    public String toString() {
        return "Person {name='" + name + "' age=" + age + "}";
    }
}
