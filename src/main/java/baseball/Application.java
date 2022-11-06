package baseball;

import  camp.nextstep.edu.*;
import camp.nextstep.edu.missionutils.Randoms;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class Application {
    public static void main(String[] args) {

        ArrayList<Integer> computerNumberList = computerGetRandom3Number();

    }

    static ArrayList<Integer> computerGetRandom3Number() {

        ArrayList<Integer> computerNumberList = new ArrayList<>();
        while(computerNumberList.size() <3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computerNumberList.contains(randomNumber)){
                computerNumberList.add(randomNumber);
            }
        }
        return computerNumberList;
    }
}
