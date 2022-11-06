package baseball.service;

import baseball.domain.Computer;
import baseball.domain.User;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private Computer computer;
    private User user;
    private int strike, ball;

    public GameService() {
    }

    private void initGame() {
        computer = new Computer();
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void doTurn() throws IllegalArgumentException {
        strike = 0;
        ball = 0;
        pickUserNum();
    }

    private void pickUserNum() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        List<Integer> userNum = new ArrayList<>();
        for (char x : userInput.toCharArray()) {
            userNum.add(x - '0');
        }
        user = new User();
        if (!user.isValid(userNum)) {
            throw new IllegalArgumentException();
        }
        user.setUserNum(userNum);
    }

}
