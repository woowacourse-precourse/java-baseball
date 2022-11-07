package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final int ON = 1;
    private List<Integer> targetNumber = new ArrayList<>();
    private List<Integer> playerNumber = new ArrayList<>();

    private int gameState = ON;

    void start() {
        while (this.gameState == ON) {
            setTargetNumber(targetNumber);
            System.out.println("숫자 야구 게임을 시작합니다.");
            startBaseBall(targetNumber, playerNumber);
        }
        System.out.println("게임 종료");
    }

    void setTargetNumber(List<Integer> targetNumber) { // 1. 랜덤 숫자 만들기
        targetNumber.clear();
        while (targetNumber.size() < 3) {
            targetNumber.add(makeRandomNumber(targetNumber));
        }
    }

    int makeRandomNumber(List<Integer> targetNumber) { // 1.1 랜덤한 숫자를 중복하지 않고 선택하기
        int randomNumber = 0;

        do {
            randomNumber = Randoms.pickNumberInRange(1, 9);
        } while (targetNumber.contains(randomNumber));

        return randomNumber;
    }

    void startBaseBall(List<Integer> targetNumber, List<Integer> playerNumber) { // 2. 야구 게임 시작

        do {
            setUserNumber(playerNumber);
            System.out.println(checkUserNumber(targetNumber, playerNumber));
        } while (convertListToInt(targetNumber) != convertListToInt(playerNumber));

        setGameState();
    }

    void setUserNumber(List<Integer> playerNumber) { // 2.1 사용자에게 숫자 입력받기
        playerNumber.clear();

        System.out.print("숫자를 입력해주세요 : ");

        String inputNum = Console.readLine();
        isValidNum(inputNum);

        int playerNum = Integer.parseInt(inputNum);
        System.out.println(playerNum);
        for (int i = 100; i > 0; i /= 10) {
            playerNumber.add(playerNum / i);
            playerNum %= i;
        }
    }

    void isValidNum(String s) { // 2.2 사용자가 입력한 숫자가 유효한 숫자인지 확인하기

        if (s.length() != 3)
            throw new IllegalArgumentException("유효하지 않은 값");

        try {
            Double.parseDouble(s);

        } catch (IllegalArgumentException e) {
            System.out.println("유효하지 않은 값");
        }

    }

    int convertListToInt(List<Integer> List) { // 2.3 list를 integer로 바꾸기
//        String num = String.join("", (CharSequence) List);

        return List.get(0) * 100 + List.get(1) * 10 + List.get(0);
    }

    String checkUserNumber(List<Integer> targetNumber, List<Integer> playerNumber) { //3. 입력 받은 숫자와 원래 숫자를 비교해 힌트 출력 or 맞으면 정답 처리
        BaseBall baseBall = new BaseBall();

        baseBall.setStrike(countStrike(targetNumber, playerNumber, baseBall));
        baseBall.setBall(countBall(targetNumber, playerNumber, baseBall));
        return baseBall.toString();
    }

    int countStrike(List<Integer> targetNumber, List<Integer> playerNumber, BaseBall baseBall) { //3.1 입력 받은 숫자의 Strike 숫자 세기
        for (int index = 0; index < targetNumber.size(); index++) {
            baseBall.setStrike(checkStrike(targetNumber.get(index), playerNumber.get(index), baseBall.getStrike()));
        }

        return baseBall.getStrike();
    }

    int checkStrike(int targetNumber, int playNumber, int strike) { //3.2 입력 받은 숫자의 Strike 판별하기
        if (targetNumber == playNumber)
            return strike + 1;
        return strike;
    }

    int countBall(List<Integer> targetNumber, List<Integer> playerNumber, BaseBall baseBall) { //3.3 입력 받은 숫자의 Ball 숫자 세기
        for (int index = 0; index < targetNumber.size(); index++) {
            baseBall.setBall(checkBall(index, playerNumber.get(index), targetNumber, baseBall.getBall()));
        }

        return baseBall.getBall();
    }

    int checkBall(int playerIndex, int playerNumber, List<Integer> targetNumber, int ball) { //3.4 입력 받은 숫자의 Ball 판별하기
        if (targetNumber.indexOf(playerNumber) != playerIndex && targetNumber.contains(playerNumber))
            return ball + 1;
        return ball;
    }

    void setGameState() { // 4. 재시작 할지, 종료할지 선택
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");

        int playerNum = Integer.parseInt(Console.readLine());

        this.gameState = playerNum;
    }
}