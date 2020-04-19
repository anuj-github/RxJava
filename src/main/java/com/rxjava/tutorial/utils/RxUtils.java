package com.rxjava.tutorial.utils;

import com.rxjava.tutorial.models.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RxUtils {

    private static final String [] colors = {"red", "green", "blue", "yellow", "white", "purple", "pink", "violet"};
    private static final String [] shapes = {"square", "rectangle", "circle", "cube", "pentagon", "hexagon", "stars"};
    public static List<Integer> getPositiveIntegers(int n){
        List<Integer> list = new ArrayList();
        for(int i =0; i<n;i++){
            list.add(i);
        }
        return list;
    }

    public static List<Shape> getShapes(int n){
        List<Shape> list = new ArrayList();
        for(int i =0; i<n;i++){
            list.add(new Shape(randomColor(), randomShape()));
        }
        return list;
    }

    private static String randomShape() {
        return shapes[getRandom(shapes.length)];
    }

    private static String randomColor() {
        return colors[getRandom(colors.length)];
    }

    private static int getRandom(int max){
        Random rand = new Random();
        return rand.nextInt(max)+1;
    }
}
