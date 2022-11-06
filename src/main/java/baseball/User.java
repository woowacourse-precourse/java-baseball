package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    private String userInput;
    private boolean flag = false;
    private Integer isProgramEnd = 1;

    public String getUserNumber() {
        System.out.print("숫자를 입력해 주세요 : ");
        String userInput = readLine();
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setIsProgramEnd(Integer isProgramEnd) {
        this.isProgramEnd = isProgramEnd;
    }

    public String getUserInput() {
        return userInput;
    }

    public boolean isFlag() {
        return flag;
    }

    public Integer getIsProgramEnd() {
        return isProgramEnd;
    }
}
