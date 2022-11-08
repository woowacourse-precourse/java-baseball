package baseball.io;

import camp.nextstep.edu.missionutils.Console;

public class InputImpl implements Input {
    @Override
    public String input(String prompt) {
        System.out.print(prompt);
        return Console.readLine();
    }
}
