package com.abhiraj.module2.controllers;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaAndStreams {

    public static void main(String[] args) {

        //old way
        Walkable obj1 = new WalkSlow();


        //old way - by anonymous class
        Walkable obj2 = new Walkable() {
            @Override
            public void
            walk(int steps, boolean isStopAllowed) {
                System.out.println("Anonymous class: Walking moderately "+ steps + " steps and allow to stop: "+ isStopAllowed);
            }
        };


        //new way - lambda expression
        Walkable obj3 = (steps, isStopAllowed) -> {
            System.out.println("Lambda expression: Walking fast "+ steps + " steps and allow to stop: "+ isStopAllowed);
        };

        Walkable obj4 = (steps, isStopAllowed) -> System.out.println("Lambda expression single line: Walking very fast "+ steps + " steps and allow to stop: "+ isStopAllowed);

        obj1.walk(120, false);
        obj2.walk(70, false);
        obj3.walk(50, true);
        obj4.walk(30, true);

        //Streams
        List<String> fruits = List.of("Banana", "Pineapple", "Apple", "Mango");

//        List<Integer> fruitLength = fruits
//                .stream()
//                .map(fruit -> fruit.length())
//                .collect(Collectors.toList());
//
//        fruitLength.forEach(System.out::println);

//        Set<Integer> fruitLength = fruits
//                .stream()
//                .map(fruit -> fruit.length())
//                .collect(Collectors.toSet());
//
//        fruitLength.forEach(System.out::println);

        Map<String,Integer> fruitList = fruits
                .stream()
                //.map(fruit -> fruit.length())
                .collect(Collectors.toMap(
                        fruit -> fruit,
                        String::length
                ));

        System.out.println(fruitList);

//        Stream<String> stream = fruits.stream();
//
////        stream.forEach((phal) ->
////                System.out.println(phal)
////        );
//
//        //stream.forEach(System.out::println);
//
//        stream
//                .filter(fruit -> fruit.length()<6)
//                .sorted()
////                .map(String::length)
////                .map(fruitLength -> 2 * fruitLength)
//                .forEach(System.out::println);
    }

}

interface Walkable {
    void walk(int steps, boolean isStopAllowed);
}

class WalkSlow implements Walkable {

    @Override
    public void walk(int steps, boolean isStopAllowed) {
        System.out.println("Implemented class: Walking slow "+ steps + " steps and allow to stop: "+ isStopAllowed);
    }
}
