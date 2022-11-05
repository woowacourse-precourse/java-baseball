package domain;

import Controller.game;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public static List<Integer> number_List;

    public static void setNumber(){
        Computer.number_List=game.get_ThreeRandomNumbers();
    }

    public static String getNumber(){
        String numbers="";

        for (Integer item : Computer.number_List){
            numbers+=Integer.toString(item);
        }

        return numbers;
    }

    public static List<Integer> getNumber_List(){
        return number_List;
    }
}
