package baseball.domain;

import baseball.util.ListUtil;
import baseball.validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class User {

    public List<Integer> inputUserAnswer() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine().trim();
        List<Integer> userInputs = ListUtil.stringToIntegerList(input);
        InputValidator.validateInPlaying(userInputs);
        return userInputs;
    }

    public boolean inputKeepPlaying() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
        String choice = Console.readLine().trim();
        InputValidator.validateNotInPlaying(choice);
        return Integer.parseInt(choice) == 1;
    }
}
