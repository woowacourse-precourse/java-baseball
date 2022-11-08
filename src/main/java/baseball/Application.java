package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        Application agent = new Application();
        while(agent.StartBaseballGame()){
        }
    }

    public boolean isEnd(String number){

        int tempNum = Integer.parseInt(number);

        if (tempNum == 1){
            return true;
        } else if (tempNum == 2) {
            return false;
        }

        throw new IllegalArgumentException();
    }

    public boolean CheckInput(String number){

        for (int i = 0; i < number.length(); i++){  // 서로 다른 숫자인지 확인하는 부분
            if (number.indexOf(number.charAt(i)) != i) {
                throw new IllegalArgumentException();
            }
        }

        int tempNum = Integer.parseInt(number);

        if (100 <= tempNum && tempNum < 1000){
            return true;
        }
        throw new IllegalArgumentException();
    }

    public ArrayList<Integer> GetHint(String number, String input){

        ArrayList<String> tempNumber = new ArrayList<>();
        ArrayList<String> tempInput = new ArrayList<>();
        ArrayList<Integer> tempReturn = new ArrayList<>(Arrays.asList(0, 0));

        for (int i = 0; i < number.length(); i++){
            tempNumber.add(number.substring(i, i+1));
            tempInput.add(input.substring(i, i+1));
        }
