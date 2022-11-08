package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {


    private static boolean checkRepeate(){
        boolean isRepeate = true;
        // TODO: 입력받고, 게임 재시작 여부 판단
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

    private static boolean checkDuplicateNum(String input){
        boolean isDuplicate = true;
        // TODO: 입력값 중 중복숫자 여부 확인
        return isDuplicate;
    }

    private static boolean checkException(String input){
        boolean isOK = true;
        // TODO: 입력값이 예외인지 확인, 예외일시 IllegalArgumentException 발생
        return isOK;
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
        // TODO: 플레이
    }


    public static void main(String[] args) {
        String answer;

        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            answer = makeAnswer();
            playBaseball(answer);

        } while(checkRepeate());
        System.out.println("게임 종료");
    }
}
