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
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true){
            boolean gameResult = playGame();
            if(gameResult == false)
                break;

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String inputRestartOrExit = Console.readLine();
            if(inputRestartOrExit.equals("2")){
                break;
            }
        }
    }

    public static boolean playGame(){
        List<Integer> computerNumber = createThreeDigitsRandomNumber();
        System.out.println(computerNumber);
        while(true){
            System.out.print("숫자를 입력해주세요 : ");
            String inputNumber = Console.readLine();
            if(!checkNumberIsValid(inputNumber)){
                return false;
            }
            List<Integer> userNumber = changeStringToList(inputNumber);
            String result = countBallStrike(computerNumber, userNumber);
            System.out.println(result);
            if(result.equals("3스트라이크")){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return true;
            }
        }
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

    public static boolean checkNumberIsValid(String number){
        return checkNumberLengthIsThree(number) && checkNumberIsDuplicated(number);
    }

    public static boolean checkNumberLengthIsThree(String number){
        String changedNumber = number.replaceAll("[^1-9]","");
        return changedNumber.length()==3;
    }

    public static boolean checkNumberIsDuplicated(String number){
        String[] arr = number.split("");
        HashSet<String> set = new HashSet<>(Arrays.asList(arr));
        return set.size() == 3;
    }

    public static List<Integer> changeStringToList(String number){
        List<Integer> result = new ArrayList<>();
        char[] arr = number.toCharArray();
        for(int i=0;i<arr.length;i++){
            result.add(arr[i]-'0');
        }
        return result;
    }

}
