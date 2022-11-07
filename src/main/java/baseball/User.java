package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {

    public String input;
    protected String INPUT_NOTICE_FOR_ANSWER = "숫자를 입력해주세요 : ";
    protected String INPUT_NOTICE_FOR_OPTION = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void setInputForAnswer() {
        System.out.print(INPUT_NOTICE_FOR_ANSWER);
        this.input = readLine();
    }

    public boolean checkInputForAnswer() {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException();
        }
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

    public void setInputForOption() {
        System.out.println(INPUT_NOTICE_FOR_OPTION);
        this.input = readLine();
    }

    public boolean checkInputForOption() {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException();
        }
        return true;
    }

}
