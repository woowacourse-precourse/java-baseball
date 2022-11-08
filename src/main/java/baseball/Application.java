package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {


    private static boolean checkRepeate(){
        boolean isRepeate = true;

        String input = readLine();
        System.out.println(input);

        if(input.equals("1")){
            isRepeate = true;
        } else if(input.equals("2")){
            isRepeate = false;
        } else{
            System.out.println("Hello");
            //throw new IllegalArgumentException();
        }

        return isRepeate;
    }

    private static String makeAnswer(){

        List<Integer> answerList = new ArrayList<>();
        while(answerList.size()<3){
            int tempNum = pickNumberInRange(1, 9);
            if(!answerList.contains(tempNum)) answerList.add(tempNum);
        }

        String answer = answerList.toString().replaceAll("[^0-9]","");
        System.out.println(answer);
        return answer;
    }

    private static void checkDuplicateNum(String input){
        // TODO: 입력값 중 중복숫자 여부 확인
    }

    private static void checkException(String input){
        // TODO: 입력값이 예외인지 확인, 예외일시 IllegalArgumentException 발생
    }

    private static int calStrike(String answer, String input){
        int strike = 0;

        return strike;
    }

    private static int calBall(String answer, String input){
        int ball = 0;

        return ball;
    }

    private static void printResult(int strike, int ball){

    }


    private static void playBaseball(String answer){
        String input;
        int strike = 0;
        int ball = 0;

        while(strike < 3){
            input = readLine();

            checkException(input);

            strike = calStrike(answer, input);
            ball = calBall(answer, input);

            printResult(strike, ball);
        }
    }


    public static void main(String[] args) {
        String answer;

        System.out.println("Start Baseball Game!");
        do {
            answer = makeAnswer();
            playBaseball(answer);

        } while(checkRepeate());
        System.out.println("Game end");
    }
}
