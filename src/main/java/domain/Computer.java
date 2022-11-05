package domain;

import Controller.Game;
import Controller.Utils;

import java.util.List;

public class Computer {
    public static List<Integer> number_List;

    public static void setNumber(){
        Computer.number_List= Utils.get_ThreeRandomNumbers();
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
