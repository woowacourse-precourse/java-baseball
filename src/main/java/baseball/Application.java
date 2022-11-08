package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        try {
            gameStart();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public static void gameStart() {
        List<Integer> computerPickNums = computerPick();
        gamePlaying(computerPickNums);
        }

    public static List<Integer> computerPick() {
        List<Integer> computerPickNums = new ArrayList<>();
        while (computerPickNums.size() < 3) {
            pushComNum(computerPickNums);
        }
        return computerPickNums;
    }

    public static void pushComNum(List<Integer> computerPickNums) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!computerPickNums.contains(randomNumber)) {
            computerPickNums.add(randomNumber);
        }
    }

    public static void gamePlaying(List<Integer> computerPickNums) {
        List<Integer> playerPickNums = playerPick();
        int strike = findStrike(computerPickNums, playerPickNums);
        int ball = findball(computerPickNums, playerPickNums);
            게임종료_후_재시작(strike, ball, computerPickNums);    
        }

    public static List<Integer> playerPick() {
        List<Integer> answer = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 :");
        int playerInput = Integer.parseInt(Console.readLine());
        if (playerInput < 100 || playerInput > 999) {
            예외_테스트();
        }
        int numOne = (int) (playerInput / 100) % 10;
        int numTwo = (int) (playerInput / 10) % 10;
        int numThree = playerInput % 10;
        if (numOne == 0 || numTwo == 0 || numThree == 0) {
            예외_테스트();
        }
        if (numOne == numTwo || numTwo == numThree || numThree == numOne) {
            예외_테스트();
        }
        answer.add(numOne);
        answer.add(numTwo);
        answer.add(numThree);
        return answer;
    }

    public static void 예외_테스트() {
        throw new IllegalArgumentException();
    }

    public static int findStrike(List<Integer> computerPickNums, List<Integer> playerPickNums) {
        int strike = 0;
        if (computerPickNums.get(0) == playerPickNums.get(0)) {
            strike++;
        }
        if (computerPickNums.get(1) == playerPickNums.get(1)) {
            strike++;
        }
        if (computerPickNums.get(2) == playerPickNums.get(2)) {
            strike++;
        }
        return strike;
    }

    public static int findball(List<Integer> computerPickNums, List<Integer> playerPickNums) {
        int ball = 0;
        if (playerPickNums.get(0) == computerPickNums.get(1)) {
            ball++;
        }
        if (playerPickNums.get(0) == computerPickNums.get(2)) {
        	ball++;
        }
        if (playerPickNums.get(1) == computerPickNums.get(2)) {
            ball++;
        }
        if (playerPickNums.get(1) == computerPickNums.get(0)) {
        	ball++;
        }
        if (playerPickNums.get(2) == computerPickNums.get(0)) {
            ball++;
        }
        if (playerPickNums.get(2) == computerPickNums.get(1)) {
        	ball++;
        }
        return ball;
    }

    public static void 게임종료_후_재시작(int strike, int ball, List<Integer> computerPickNums) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            gamePlaying(computerPickNums);
        } else if (strike == 0) {
            System.out.println(ball + "볼");
            gamePlaying(computerPickNums);
        } else if (ball == 0 && strike != 3) {
            System.out.println(strike + "스트라이크");
            gamePlaying(computerPickNums);
        } else if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            gameReloader();
        } else {
            System.out.println(ball + "볼" + " " + strike + "스트라이크");
            gamePlaying(computerPickNums);
        }
    }

    public static void gameReloader() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int coin = Integer.parseInt(Console.readLine());
        if (coin == 1) {
            gameStart();
        } else if (coin == 2) {
        } else {
            예외_테스트();
        }
    }
}
