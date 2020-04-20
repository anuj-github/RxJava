package com.rxjava.tutorial.models;

public class Shape {
    private String color;
    private String shape;

    public Shape(String color, String shape) {
        this.color = color;
        this.shape = shape;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "color='" + color + '\'' +
                ", shape='" + shape + '\'' +
                '}';
    }
}
