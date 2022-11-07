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

    void start() { // 게임 실행

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
        } while (convertListToInt(targetNumber) != convertListToInt(playerNumber));
        
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

        return List.get(0) * 100 + List.get(1) * 10 + List.get(0);
    }

}