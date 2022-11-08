package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputMapping {
    public List<Integer> getGameNumberList(){
        return new ArrayList<>();
    }

    public int getConsoleInt(){
        try {
            String line = Console.readLine();
            if (line.isBlank() || !line.matches("\\d+"))
                throw new IllegalArgumentException();
            return Integer.parseInt(line);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("out of Int");
        }
    }

    private boolean nonValidateGameNumber(int inputNumber){
        if (inputNumber < 111 || inputNumber > 999)
            return true;
        while (inputNumber > 0){
            if (inputNumber % 10 == 0) {
                return true;
            }
            inputNumber /= 10;
        }
        return false;    }
}
