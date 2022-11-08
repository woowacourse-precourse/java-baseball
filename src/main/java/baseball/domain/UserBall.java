package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UserBall {
    private ArrayList<String> inputNumber;
    public ArrayList<Integer> userNumber;


    public void generateUserBall(String inputString) throws IllegalArgumentException{
        inputNumber = new ArrayList<String>();
        userNumber = new ArrayList<Integer>();
    }

    private void makeUserNumList(String inputString){
        for (int i = 0; i < inputString.length(); i++) {
            inputNumber.add(String.valueOf(inputString.charAt(i)));
        }
    }
}
