package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static List<Integer> createThreeDigitsRandomNumber(){
        List<Integer> computer = new ArrayList<>();
        while(computer.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static boolean checkEnteredNumberIsValid(String str){
        String number = str.replaceAll("[^0-9]","");
        return number.length() == 3;
    }

    public static String countBallStrike(List<Integer> computer, List<Integer> user){
        int ballCount = 0, strikeCount = 0;

        for(int i=0;i<computer.size();i++){
            int computerNumber = computer.get(i);
            int userNumber = user.get(i);

            if(computerNumber == userNumber){
                strikeCount++;
            }
            else if(computer.contains(userNumber)){
                ballCount++;
            }
        }

        return toStringBallStrike(ballCount, strikeCount);
    }

    public static String toStringBallStrike(int ballCount, int strikeCount){
        if(ballCount + strikeCount == 0){
            return "낫싱";
        }

        StringBuffer result = new StringBuffer();

        if(ballCount != 0){
            result.append(Integer.toString(ballCount)+"볼");
        }
        if(strikeCount != 0){
            if(result.length() != 0){
                result.append(" ");
            }
            result.append(Integer.toString(strikeCount)+"스트라이크");
        }
        return result.toString();
    }

    public static boolean checkNumberLengthIsThree(String number){
        return number.length()==3;
    }

    public static boolean checkNumberIsDuplicated(String number){
        String[] arr = number.split("");
        HashSet<String> set = new HashSet<>(Arrays.asList(arr));
        return set.size() == 3;
    }


}
