package baseball.model;

import baseball.controller.GamePlay;
import baseball.util.Util;
import camp.nextstep.edu.missionutils.Console;

public class User {
    public int[] inputNumber() {
        int[] inputNumbers = new int[3];
        String readLine = Console.readLine();
        Util.isCorrectInput(readLine);
        for (int i = 0; i < 3; i++) {
            inputNumbers[i] = Integer.parseInt(readLine.substring(i, i + 1));
        }
        return inputNumbers;
    }

    public boolean inputRestartNumber() {
        int restartNumber = Integer.parseInt(Console.readLine());
        Util.isCorrectInputRestartNumber(restartNumber);
        if (restartNumber == 2) {
            return true;
        }
        GamePlay.restart = false;

        return false;
    }
}
