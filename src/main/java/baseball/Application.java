package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while (true) {
            int randomNumber = makeRandomNumber();
            System.out.println(randomNumber);

            int userInputNumber = input();
            playGame(randomNumber, userInputNumber);

            if (restartOrEndGame() == 2) {
                System.out.println("게임을 종료합니다.");
                break;
            }
        }
    }


    public static int makeRandomNumber() {
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int num = (int) ((Math.random() * 9) + 1);
            numList.add(num);
        }
        return removeRepetitionNumber(numList);
    }


    public static int removeRepetitionNumber(List<Integer> numList) {
        String tmp = "";

        for (int i = 0; i < numList.size()-1; i++) {
            if (numList.get(i) != numList.get(i+1)) tmp += numList.get(i);
        }

        tmp += numList.get(numList.size()-1);
        tmp = tmp.substring(0,3);

        return Integer.parseInt(tmp);
    }


    public static int input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자를 입력해주세요: ");
        int n = sc.nextInt();

        return exceptionHandler(n);
    }


    public static int exceptionHandler(int n) {
        if (!(n >= 100 && n <1000)) throw new IllegalArgumentException("n은 세자리 숫자입니다.");

        return n;
    }


    public static void playGame(int computerInput, int userInput) {
        System.out.println("computerInput = " + computerInput);
        System.out.println("userInput = " + userInput);

        if (computerInput == userInput) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    public static int restartOrEndGame() {
        Scanner sc = new Scanner(System.in);
        System.out.println("게임 다시하기: 1 \n게임 종료: 2");
        int n = sc.nextInt();

        return n;
    }
}
