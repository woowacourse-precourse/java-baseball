package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    private static final int MIN = 100;
    private static final int MAX = 999;
    private static final Scanner stdinScanner = new Scanner(System.in);
    private static int answerNumber;

    private static List<Integer> gameResult(int inputNumber){
        ArrayList<Integer> resultList = new ArrayList<>();


    }

    private static boolean eachGame(){
        System.out.print("숫자를 입력해주세요 : ");
        int inputNumber = stdinScanner.nextInt();

        return false;
    }

    private static void baseballGameRun(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        answerNumber = (int)((Math.random()*(MAX - MIN)) + MIN);
        System.out.println(answerNumber);
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        baseballGameRun();
    }
}
