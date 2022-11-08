package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Application {
    static boolean end = false;
    static boolean play = true;

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다");
        while (!end) {

            ComUserNumber.computerThreeRandomNumber(); // 컴퓨터가 3개의 랜덤 수 생성
            play = true;
            while (play) {
                System.out.println("숫자를 입력해주세요 :");
                ComUserNumber.userThreeInputNumber(); // 사용자가 3개의 수 입력

                GameProgress.checkStrikeCount();
                GameProgress.checkBallCount();        // 볼, 스트라이크 검사

                play = GameProgress.gamePlay();
            }
            end = GameProgress.gameReset();
        }
    }
}

class ComUserNumber {

    static final int MINIMUM_NUMBER = 1;
    static final int MAX_NUMBER = 9;
    static int comNumber1, comNumber2, comNumber3;
    static int userNumber1, userNumber2, userNumber3;
    public static String userThreeNumber;

    public static ArrayList<Integer> computerThreeRandomNumber() {
        ArrayList<Integer> comList = new ArrayList<>();
        while (true) {
            comNumber1 = Randoms.pickNumberInRange(MINIMUM_NUMBER, MAX_NUMBER);
            comNumber2 = Randoms.pickNumberInRange(MINIMUM_NUMBER, MAX_NUMBER);
            comNumber3 = Randoms.pickNumberInRange(MINIMUM_NUMBER, MAX_NUMBER);

            if ((comNumber1 != comNumber2) && (comNumber1 != comNumber3) && (comNumber2 != comNumber3)) {
                comList.add(comNumber1);
                comList.add(comNumber2);
                comList.add(comNumber3);

                break;
            }
        }
        return comList;
    }

    public static ArrayList<Integer> userThreeInputNumber() {
        ArrayList<Integer> userList = new ArrayList<>();
        userThreeNumber = Console.readLine();

        if (userThreeNumber.length() != 3) {
            throw new IllegalArgumentException("게임 종료");
        }
        String[] userNum = userThreeNumber.split("");
        int[] userThreeNum = new int[userThreeNumber.length()];
        for (int i = 0; i < userThreeNumber.length(); i++) {
            userThreeNum[i] = Integer.parseInt(userNum[i]);
        }
        for (int j = 0; j < userThreeNumber.length(); j++) {
            userList.add(Integer.parseInt(userNum[j]));
        }
        userNumber1 = userList.get(0);
        userNumber2 = userList.get(1);
        userNumber3 = userList.get(2);

        if ((userNumber1 == userNumber2) || (userNumber1 == userNumber3) || (userNumber2 == userNumber3)) {
            throw new IllegalArgumentException("게임 종료");
        }

        return userList;
    }
}

class GameProgress {

    static int strikeCount = 0;
    static int ballCount = 0;
    static int gameButton = 0;

    public static int checkStrikeCount() {
        if (ComUserNumber.comNumber1 == ComUserNumber.userNumber1) {
            strikeCount++;
        }
        if (ComUserNumber.comNumber2 == ComUserNumber.userNumber2) {
            strikeCount++;
        }
        if (ComUserNumber.comNumber3 == ComUserNumber.userNumber3) {
            strikeCount++;
        }

        return strikeCount;
    }

    public static int checkBallCount() {
        if ((ComUserNumber.comNumber1 == ComUserNumber.userNumber2) || (ComUserNumber.comNumber1
                == ComUserNumber.userNumber3)) {
            ballCount++;
        }
        if ((ComUserNumber.comNumber2 == ComUserNumber.userNumber1) || (ComUserNumber.comNumber2
                == ComUserNumber.userNumber3)) {
            ballCount++;
        }
        if ((ComUserNumber.comNumber3 == ComUserNumber.userNumber1) || (ComUserNumber.comNumber3
                == ComUserNumber.userNumber2)) {
            ballCount++;
        }

        return ballCount;
    }

    public static boolean gamePlay() {
        boolean play = true;
        if (strikeCount == 3) {
            System.out.println("3스트라이크");

            play = false;
        } else if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
            strikeCount = 0;
            ballCount = 0;

            play = true;
        } else {
            System.out.printf("%d볼 %d스트라이크", ballCount, strikeCount);
            strikeCount = 0;
            ballCount = 0;

            play = true;
        }
        return play;
    }

    public static boolean gameReset() {
        boolean end = true;
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        gameButton = Integer.parseInt(Console.readLine());
        if (gameButton == 1) {
            ballCount = 0;
            strikeCount = 0;
            end = false;
        }
        if (gameButton == 2) {
            System.out.println("게임 종료");
            end = true;
        }
        if (gameButton != 1 && gameButton != 2){
            throw new IllegalArgumentException("게임 종료");
        }
        return end;
    }
}
