package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Application {
    static List<Integer> computerNumber = new ArrayList<>();
    static List<Integer> userNumber = new ArrayList<>();
    static Integer strikeCount = 0;
    static Integer ballCount = 0;

    public static void main(String[] args) {


    }


    public static void createRandomNumber(){
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }

    public static void userInputNumbers(BufferedReader br) throws IOException{

        userNumber.removeAll(userNumber);

        System.out.print("숫자를 입력해주세요 : ");
        String inputStr = br.readLine();
        String conversion = "";

        for(int i=0; i<inputStr.length(); i++) {
            if(inputStr.indexOf(inputStr.charAt(i)) == i){
                conversion += inputStr.charAt(i);
            }
        }

        if(!inputStr.matches("[0-9]{3}") && inputStr.equals(conversion)){
            throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
        }

        for(String inputSingleStr : conversion.split("")){
            userNumber.add(Integer.parseInt(inputSingleStr));
        }
    }

    public static Integer startUserGame(BufferedReader br) throws IOException{
        if(strikeCount != 3){
            userInputNumbers(br);
            countStrikeAndBall();
            printStrikeAndBall();
        }else if(strikeCount == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return answerNumber(br);
        }
        return 0;
    }

    public static void resetValue(){
        computerNumber = new ArrayList<>();
        userNumber = new ArrayList<>();
        strikeCount = 0;
        ballCount = 0;
    }

    public static Integer answerNumber(BufferedReader br) throws IOException{
        String newGameChoice = br.readLine();
        if(newGameChoice.equals("1") || newGameChoice.equals("2")){
            return Integer.parseInt(newGameChoice);
        }
        throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
    }

    public static void countStrikeAndBall(){
        strikeCount = 0;
        ballCount = 0;

        for(int i=0; i<computerNumber.size(); i++){
            if(computerNumber.get(i) == userNumber.get(i)){
                strikeCount++;
            }else if(computerNumber.contains(userNumber.get(i))){
                ballCount++;
            }
        }
    }

    public static void printStrikeAndBall(){
        if(ballCount > 0 && strikeCount > 0){
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }else if(strikeCount > 0){
            System.out.println(strikeCount + "스트라이크");
        }else if(ballCount > 0){
            System.out.println(ballCount + "볼");
        }else if(ballCount == 0 && strikeCount == 0){
            System.out.println("낫싱");
        }
    }
}

