package domain;

import Controller.game;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public static List<Integer> number_List;

    public static Computer getInstance(){
        return new Computer();
    }

    public void setNumber(){
        Computer.number_List=game.get_ThreeRandomNumbers();
    }

    public static String getNumber(){
        String numbers="";

        for (Integer item : Computer.number_List){
            numbers+=Integer.toString(item);
        }

        return numbers;
    }
}
