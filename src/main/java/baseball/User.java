package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {
    public String getNewNumberString() {
        String numberString = Console.readLine();
        Validator.validateNumberString(numberString);
        return numberString;
    }

    public String getRestartResponse() {
        String response = Console.readLine();
        Validator.validateRestartResponse(response);
        return response;
    }
}
