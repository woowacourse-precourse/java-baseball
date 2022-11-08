package baseball.domain;

import baseball.util.ListUtil;
import baseball.validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.contants.Contants.*;

public class User {

    public List<Integer> inputUserAnswer() {
        String input = Console.readLine().trim();
        List<Integer> userInputs = ListUtil.stringToIntegerList(input);
        InputValidator.validateInPlaying(userInputs);
        return userInputs;
    }

    public boolean inputKeepPlaying() {
        String choice = Console.readLine().trim();
        InputValidator.validateNotInPlaying(choice);
        return choice.equals(NEW_GAME);
    }
}
