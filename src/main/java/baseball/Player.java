package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {

    public Player() {

    }

    public Balls makePlayerBalls() {
        System.out.print("숫자를 입력해주세요 : ");
        String playerInput = Console.readLine();
        return new InputTranslator().translateInput(playerInput);
    }
}
