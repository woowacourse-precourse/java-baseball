package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

/**
 * 숫자를 맞추는 유저 클래스
 */
public class User {
    private String number;

    public void inputNumber() {
        this.number = Console.readLine();
    }

}
