package org.example.Junior_Exercises.Exercise8;

public class Car {
        String brand;
        String color;
        int year;

    void start() {
        System.out.println("Car: " + brand + " is starting...");
    }

    public void showDetails(){
        System.out.println(this);
    }

    @Override
    public String toString(){
        return "Brand: " + brand + ", Color: " + color + ", Year: " + year;
    }
}
