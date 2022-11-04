package baseball.model;

import baseball.util.Util;
import camp.nextstep.edu.missionutils.Console;

public class User {
    public int[] inputNumber(){
        String readLine = Console.readLine();
        Util.isCorrectInput(readLine);

        int[] inputNumbers = new int[3];
        for(int i = 0; i < 3; i++){
            inputNumbers[i] = Integer.parseInt(readLine.substring(i, i + 1));
        }

        return inputNumbers;
    }

    public int inputRestart() {
        return Integer.parseInt(Console.readLine());
    }
}
