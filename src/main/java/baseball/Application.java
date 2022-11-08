package baseball;

import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
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

        for (int i = 0; i < number.length(); i++){
            if (tempNumber.get(i).equals(tempInput.get(i))){
                tempReturn.set(1, tempReturn.get(1) + 1);
            } else if (tempNumber.contains(tempInput.get(i))) {
                tempReturn.set(0, tempReturn.get(0) + 1);
            }
        }

        return tempReturn;
    }


}
