package baseball;

import java.util.ArrayList;
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

    private static List<Integer> seperate3Numbers(int input){
        List<Integer> separated = new ArrayList<>();
        for (int i = 2; i >= 0; i--) {
            int digit = input / (int) Math.pow(10, i);
            input = input % (int) Math.pow(10, i);
            separated.add(digit);
        }
        return separated;
    }

    public static void main(String[] args) {
        List<Integer> answer = generateRandom3Numbers();
        System.out.println(answer);
        boolean gameOn = startGame();
        Scanner sc = new Scanner(System.in);
        while (gameOn) {
            int userInput = sc.nextInt();
            List<Integer> separatedInput = seperate3Numbers(userInput);

            System.out.println(separatedInput);
            gameOn = false;
        }
    }
}
