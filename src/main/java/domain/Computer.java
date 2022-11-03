package domain;

import Controller.game;

import java.util.List;

public class Computer {
    private static List<Integer> number_List;
    public static void number_set(){
        Computer.number_List= game.get_ThreeRandomNumbers();
    }
    public static String number_get(){
        String numbers="";
        for (Integer item : Computer.number_List){
            numbers.concat(String.valueOf(item));
        }
        return numbers;
    }
}
