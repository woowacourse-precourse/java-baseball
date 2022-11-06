package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    private String userInput;
    private List<Integer> userInputNumber = new ArrayList<>();
    private boolean flag = false;
    private Integer isProgramEnd = 1;

    public String getUserNumber() {
        System.out.print("숫자를 입력해 주세요 : ");
        String userInput = readLine();
        return userInput;
    }

    public void setUserInputStringToNumber(String userInput) {
        List<Integer> tempUserInputNumber = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Integer tempNum = Integer.parseInt(String.valueOf(userInput.charAt(i)));
            tempUserInputNumber.add(tempNum);
        }
        this.userInputNumber = tempUserInputNumber;
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

    public List<Integer> getUserInputNumber() {
        return userInputNumber;
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
