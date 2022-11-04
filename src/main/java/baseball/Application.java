package baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    private static List<Integer> generateRandom3Numbers() {
        List<Integer> randomNums = new ArrayList<>();
        for (int repetition = 0; repetition < 3; repetition++) {
            randomNums.add(Randoms.pickNumberInRange(1, 9));
        }
        return randomNums;
    }

    private static boolean startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean gameStarted = true;
        return gameStarted;
    }

    private static List<Integer> seperate3Numbers(int input) {
        List<Integer> separated = new ArrayList<>();
        for (int i = 2; i >= 0; i--) {
            int digit = input / (int) Math.pow(10, i);
            input = input % (int) Math.pow(10, i);
            separated.add(digit);
        }
        return separated;
    }


    static final int NOTHING = 0;
    static final int BALL = 1;
    static final int STRIKE = 2;

    private static HashMap<Integer, Integer> checkBallOrStrike(List<Integer> answerList,
                                                               List<Integer> userInputList) {
        HashMap<Integer, Integer> comparedResult = new HashMap<>();
        comparedResult.put(BALL, 0);
        comparedResult.put(STRIKE, 0);
        comparedResult.put(NOTHING, 1);
        for (int comparingNum = 0; comparingNum < 3; comparingNum++) {
            if (answerList.contains(userInputList.get(comparingNum))) {
                comparedResult.put(NOTHING, 0);
                if (answerList.get(comparingNum) == userInputList.get(comparingNum)) {
                    int strikes = comparedResult.get(STRIKE);
                    strikes += 1;
                    comparedResult.put(STRIKE, strikes);
                } else {
                    int balls = comparedResult.get(BALL);
                    balls += 1;
                    comparedResult.put(BALL, balls);
                }
            }
        }
        return comparedResult;
    }

    private static boolean correctAnswer(HashMap<Integer,Integer> comparedResult){
        boolean correct;
        if (comparedResult.get(STRIKE)==3){
            correct=true;
        }else correct=false;
        return correct;
    }

    public static void main(String[] args) {
        List<Integer> answer = generateRandom3Numbers();
        System.out.println(answer);
        boolean gameOn = startGame();
        Scanner sc = new Scanner(System.in);
        while (gameOn) {
            int userInput = sc.nextInt();
            List<Integer> separatedInput = seperate3Numbers(userInput);
            HashMap<Integer,Integer> comparedResult=checkBallOrStrike(answer,separatedInput);
            gameOn=correctAnswer(comparedResult);


        }
    }
}
