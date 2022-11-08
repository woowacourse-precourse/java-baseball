package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

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

        for (int i = 0; i < number.length(); i++){
            if (tempNumber.get(i).equals(tempInput.get(i))){
                tempReturn.set(1, tempReturn.get(1) + 1);
            } else if (tempNumber.contains(tempInput.get(i))) {
                tempReturn.set(0, tempReturn.get(0) + 1);
            }
        }

        return tempReturn;
    }

    public String PrintHint(ArrayList<Integer> pitchResult){

        if (pitchResult.get(0) == 0 && pitchResult.get(1) == 0) {
            return "낫싱";
        } else if (pitchResult.get(0) == 0) {
            return Integer.toString(pitchResult.get(1)) + "스트라이크";
        } else if (pitchResult.get(1) == 0) {
            return Integer.toString(pitchResult.get(0)) + "볼";
        } else {
            return Integer.toString(pitchResult.get(0)) + "볼 " + Integer.toString(pitchResult.get(1)) + "스트라이크";
        }
    }

    public String MakeRandomNum(){
        return Integer.toString(Randoms.pickNumberInRange(100, 999));
    }
}
