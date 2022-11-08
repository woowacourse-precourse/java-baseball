package baseball.view;

import baseball.message.Messages;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String startMessage() {
        System.out.print(Messages.INPUT);
        return Console.readLine();
    }

    public static String askNextGame() {
        System.out.println(Messages.ASK_NEXTGAME);
        return Console.readLine();
    }

}
