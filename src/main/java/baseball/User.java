package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {

    public String input;

    public void setInput() {
        this.input = readLine();
    }

    public boolean checkInputForAnswer() {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
        if ((input.charAt(0) == input.charAt(1))
            || (input.charAt(1) == input.charAt(2))
            || (input.charAt(2) == input.charAt(0))) {
            throw new IllegalArgumentException();
        }
        return true;
    }

}
