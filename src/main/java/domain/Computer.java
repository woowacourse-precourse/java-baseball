package domain;

import Controller.game;

import java.util.List;

public class Computer {
    private static List<Integer> Number_List;
    public static void number_set(){
        Computer.Number_List= game.getThree_RandomNumber();
    }
    public static String number_get(){
        String threeNum="";
        for (Integer item : Computer.Number_List){
            threeNum.concat(String.valueOf(item));
        }
        return threeNum;
    }
}
