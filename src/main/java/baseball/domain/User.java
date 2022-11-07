package baseball.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    private baseballGame baseballGame;
    private String number;


    public User() {
        baseballGame = null;
    }

    public void startBaseballGame() {
        baseballGame = new baseballGame();
        baseballGame.createRandomNumber();

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            baseballGame.initCounts();
            inputNumber();
        }
    }

    public void inputNumber() {
        number = readLine();
    }

}
