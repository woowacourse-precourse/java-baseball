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
        HashMap<Integer, Integer> comparedMap = new HashMap<>();
        comparedMap.put(BALL, 0);
        comparedMap.put(STRIKE, 0);
        comparedMap.put(NOTHING, 1);
        for (int comparingNum = 0; comparingNum < 3; comparingNum++) {
            int answer = answerList.get(comparingNum);
            int input = userInputList.get(comparingNum);
            if (answerList.contains(input)) {
                comparedMap.put(NOTHING, 0);
                comparedMap = ballOrStrike(comparedMap, answer, input);
            }
        }
        return comparedMap;
    }

    private static boolean isStrike(int answer, int input) {
        if (answer == input) {
            return true;
        } else {
            return false;
        }
    }

    private static HashMap<Integer, Integer> ballOrStrike(HashMap<Integer, Integer> comparedMap, int answer, int input) {
        comparedMap.put(NOTHING, 0);
        if (isStrike(answer, input)) {
            addOneToMap(comparedMap, STRIKE);
        } else {
            addOneToMap(comparedMap, BALL);
        }

        return comparedMap;
    }

    private static HashMap<Integer, Integer> addOneToMap(HashMap<Integer, Integer> map, int key) {
        int oldNumber = map.get(key);
        map.put(key, oldNumber + 1);
        return map;
    }

    private static boolean correctAnswer(HashMap<Integer, Integer> comparedMap) {
        boolean correct;
        if (comparedMap.get(STRIKE) == 3) {
            correct = true;
        } else correct = false;
        return correct;
    }

    private static void printResult(HashMap<Integer, Integer> comparedMap) {
        int balls = comparedMap.get(BALL);
        int strikes = comparedMap.get(STRIKE);
        int nothing = comparedMap.get(NOTHING);

        if (comparedMap.get(NOTHING) != 0) {
            System.out.printf("낫싱");
        }
        if (comparedMap.get(BALL) != 0) {
            System.out.printf("%d볼 ", balls);
        }
        if (comparedMap.get(STRIKE) != 0) {
            System.out.printf("%d스트라이크", strikes);
        }
        System.out.printf("\n");
    }


    private static void playGame(){

    }

    public static void main(String[] args) {
        List<Integer> answer = generateRandom3Numbers();
        System.out.println(answer);
        boolean gameOn = startGame();
        Scanner sc = new Scanner(System.in);
        while (gameOn) {
            int userInput = sc.nextInt();
            List<Integer> separatedInput = seperate3Numbers(userInput);
            HashMap<Integer, Integer> comparedMap = checkBallOrStrike(answer, separatedInput);
            if (correctAnswer(comparedMap)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                userInput=sc.nextInt();
                if(userInput==1){
                    gameOn = startGame();
                    answer = generateRandom3Numbers();
                }
                else {
                    gameOn = !correctAnswer(comparedMap);
                }
            } else {
                printResult(comparedMap);
                gameOn = !correctAnswer(comparedMap);
            }
        }
    }
}
