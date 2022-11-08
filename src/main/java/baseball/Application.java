package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        do{
            while(true){//strickCount!=3
                //input
                List<Integer> input = valueToList(Integer.parseInt(Console.readLine()));
                //count strike and ball
            }
            //end game
        }while(true);//replay or exit
    }

    public static List<Integer> valueToList(int value){
        List<Integer> list = new ArrayList<>();

        while (value / 10 != 0) {
            list.add(0, value % 10);
            value /= 10;
        }
        list.add(0, value % 10);
        return list;
    }
}