package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            BaseBallGame.play(CreateRandomNumber.create());
        } while (BaseBallGame.restart());
    }
}