package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int playGame = 0;
        while (playGame == 0) {
            playGame = gameResult(comparing(computersNumbers(), readUsersNumbers()));


        }


    }

    public static ArrayList<Integer> computersNumbers() {

        ArrayList<Integer> computerRandomNumbers = new ArrayList<Integer>();
        while (computerRandomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerRandomNumbers.contains(randomNumber)) {
                computerRandomNumbers.add(randomNumber);
            }
        }
        System.out.print(computerRandomNumbers);
        return computerRandomNumbers;
    }

    public static boolean inputRequirements(int input1, int input2, int input3) {
        if ((input1 != input2) && (input2 != input3) && (input1 != input3)) {
            if ((input1 < 10) && (input2 < 10) && (input3 < 10) && (input1 > 0) && (input2 > 0) && (input3 > 0)) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Integer> readUsersNumbers() {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> usersNumbers = new ArrayList<Integer>();

        System.out.print("숫자를 입력해주세요: ");
        int inputNumber1 = scanner.nextInt();
        int inputNumber2 = scanner.nextInt();
        int inputNumber3 = scanner.nextInt();

        if (inputRequirements(inputNumber1, inputNumber2, inputNumber3)) {
            usersNumbers.add(0, inputNumber1);
            usersNumbers.add(1, inputNumber2);
            usersNumbers.add(2, inputNumber3);
        } else {
            throw new IllegalArgumentException("잘못된 값이 입력되었습니다.");
        }
        return usersNumbers;
    }

    public static ArrayList<Integer> comparing(ArrayList<Integer> computerNumbers, ArrayList<Integer> userNumbers) {

        ArrayList<Integer> hintResult = new ArrayList<Integer>();

        int strike = 0;
        int ball = 0;
        for (int arrayIndex = 0; arrayIndex < 3; arrayIndex++) {
            if (computerNumbers.get(arrayIndex) == userNumbers.get(arrayIndex)) {
                strike++;
            }
            if (computerNumbers.contains(userNumbers.get(arrayIndex))) {
                ball++;
            }
        }

        ball = ball - strike;

        hintResult.add(0, strike);
        hintResult.add(1, ball);

        return hintResult;
    }

    public static int gameResult(ArrayList<Integer> hintScore) {
        int gameStatus = 0;
        if (hintScore.get(0) == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            gameStatus = 1;
        } else if (hintScore.get(0) == 0 && hintScore.get(1) == 0) {
            System.out.println("낫싱");
        } else {
            if (hintScore.get(0) == 0) {
                System.out.printf("%1$d볼", hintScore.get(1));
            } else if (hintScore.get(1) == 0) {
                System.out.printf("%2$d스트라이크", hintScore.get(0));
            } else {
                System.out.printf("%1$d볼 %2$d스트라이크", hintScore.get(1), hintScore.get(0));
            }
        }
        return gameStatus;
    }

    public static int restartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
        Scanner scanner = new Scanner(System.in);
        int answer = scanner.nextInt();
        if (answer == 1) {
            return 0;
        } else if (answer == 2) {
            return 1;
        } else {
            throw new IllegalArgumentException("잘못된 값이 입력되었습니다.");
        }

    }


}


