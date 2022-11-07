package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    public String getPlayerInputNumbersString() {
        String input = Console.readLine();
        Validator.validatePlayerInputNumbersString(input);
        return input;
    }

    public String getPlayerResponseAfterGame() {
        String response = Console.readLine();
        Validator.validateResponse(response);
        return response;
    }
}
