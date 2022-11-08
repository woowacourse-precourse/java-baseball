package baseball;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {

    private List<Integer> computer;

    public Game() {
        // 게임 시작 시 컴퓨터 숫자 생성
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        this.computer = computer;
    }

    public PlayResult playGame(String[] input) throws IllegalAccessException {
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 사용자가 잘못된 값을 입력할 경우
        if (input.length != 3) {
            throw new IllegalAccessException();
        }

        List<Integer> user = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            user.add(Integer.parseInt(input[i]));
        }

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j && computer.get(i) == user.get(j)) {
                    strike++;
                    break;
                } else if (computer.get(i) == user.get(j)) {
                    ball++;
                    break;
                }
            }
        }

        return new PlayResult(strike, ball);
    }
}
