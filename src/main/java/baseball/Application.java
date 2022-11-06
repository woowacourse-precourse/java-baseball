package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import java.util.*;


public class Application {
    private static final int NUMBER_INDEX = 0;
    private static final int NUMBER_SIZE = 3;
    private static final List<String> userPickNumber = new ArrayList<>();

    public static void main(String[] args) {
        String computerRandomNumber = "";
        String userInputNumber ="";

       computerRandomNumber =  computerRandomNumber();
        gameStartMessage();
        userInputNumber = inputUserPickNumber();
        int strike = howManyStrike(userInputNumber,computerRandomNumber);
        int ball = howManyBall(userInputNumber,computerRandomNumber);
        int nothing = nothing(userInputNumber,computerRandomNumber);
        System.out.println("스트라이크: "+strike + "볼"+ ball);

    }

    public static String computerRandomNumber(){
        String [] number = new String[3];
        StringBuffer numbers = new StringBuffer();
        for(int i=0; i<number.length; i++){
            String num = String.valueOf(pickNumberInRange(1,9));
            if(!num.equals(number[i])) {
                number[i] = num;
                numbers.append(num);
            }
        }
        return numbers.toString();
    }


    public static void gameStartMessage (){
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.println("숫자를 입력 해 주세요.");

    }
    private static String inputUserPickNumber(){
        return readLine();
    }


    public static int howManyStrike (String userNumber, String answerNumber){
        int strikeCount = 0;

        for(int i = 0; i<userNumber.length();i++){
            char userNum = userNumber.charAt(i);
            char answerNum = answerNumber.charAt(i);
            if(userNum == answerNum){
                strikeCount ++;
            }
        }return strikeCount;
    }

    public static int howManyBall(String userNumber, String answerNumber){
        int ballCount = 0;
        for(int i = 0 ; i<userNumber.length()-1; i++){
            char userNum = userNumber.charAt(i);
            char answerNum = answerNumber.charAt(i+1);
            if(userNum == answerNum){
                ballCount++;
            }
        }return ballCount;
    }

    public static int nothing(String userNumber, String answerNumber){
        int nothing = 0;
        for(int i = 0; i<userNumber.length();i++){
            char user = userNumber.charAt(i);
            nothing += answerNumber.indexOf(user);
        }return nothing;
    }


    public static void NothingMessage(int nothing){
        if(nothing == -3){
            System.out.println("낫싱");
        }
    }


    public static void strikeMessage(int strike){
        System.out.println(strike + "스트라이트");

    }

    public static void ballMessage(int ball){
        System.out.println(ball + "볼");
    }

    public static void strikeResult(int strike){
        if(strike == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다!. 게임종료");
        }
    }

    public static void restartOrEnd(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
    }



}

