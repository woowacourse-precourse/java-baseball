package baseball.starter;

import baseball.computer.Computer;
import baseball.referee.Referee;
import baseball.user.User;
import baseball.user.UserInputValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGameStarter {

    static UserInputValidator userInputValidator = new UserInputValidator();

    public List<List<String>> operate() {

        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");

        List<String> userInputValue = new User(userInputValidator)
                .stringConvertToStringList(Console.readLine());

        List<String> computerGeneratedValue = new Computer().generateNumber();

        return new ArrayList<>() {{
            add(userInputValue);
            add(computerGeneratedValue);
        }};
    }
}
