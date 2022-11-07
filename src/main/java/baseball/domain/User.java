package baseball.domain;

import baseball.utils.Message;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Integer> userNum;

    public User() {
    }

    public List<Integer> getUserNum() {
        return userNum;
    }

    private void setUserNum(List<Integer> userNum) {
        this.userNum = userNum;
    }

    private boolean isValid(List<Integer> userNum, Game game) {
        if (userNum.size() != game.getDigit()) {
            return false;
        }
        if (userNum.size() != userNum.stream().distinct().count()) {
            return false;
        }
        for (int num : userNum) {
            if (num < game.getStartRange() || num > game.getEndRange()) {
                return false;
            }
        }
        return true;
    }

    public void pickUserNum(Game game) throws IllegalArgumentException {
        Message.printInput();
        String userInput = Console.readLine();

        List<Integer> userNum = new ArrayList<>();
        for (char x : userInput.toCharArray()) {
            userNum.add(x - '0');
        }
        if (!isValid(userNum, game)) {
            throw new IllegalArgumentException();
        }
        setUserNum(userNum);
    }

}
