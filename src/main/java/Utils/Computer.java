package Utils;

import java.util.List;

public class Computer {
    public static List<Integer> threeNumber_List;
    public static void setThreeNumber_List(){
        Computer.threeNumber_List=game.anotherThree_RandomNumber();
    }
    public static String getThreeNumber(){
        String threeNum="";
        for (Integer item : Computer.threeNumber_List){
            threeNum.concat(String.valueOf(item));
        }
        return threeNum;
    }
}
