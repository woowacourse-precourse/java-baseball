package baseball.starter;

import baseball.computer.Computer;
import baseball.referee.Referee;
import baseball.user.User;
import baseball.validator.UserInputValueValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameStarter {
    public List<List<String>> initializeNewGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");

        List<String> userInputValue = new User().stringConvertToStringList(Console.readLine());
        List<String> computerGeneratedValue = new Computer().generateNumber();
        return new ArrayList<>() {{
            add(userInputValue);
            add(computerGeneratedValue);
        }};
    }

    public void operateRefereeJudgement(List<String> userInputValue, List<String> computerGeneratedValue) {
        Referee referee = new Referee();
        String option = "";

        while (referee.judgement(computerGeneratedValue, userInputValue).get("strikeCount") != 3) {
            referee.sayJudgement(referee.judgement(computerGeneratedValue, userInputValue));
            System.out.print("숫자를 입력해주세요 : ");
            userInputValue = new User().stringConvertToStringList(
                    Console.readLine());

            if (referee.judgement(computerGeneratedValue, userInputValue).get("strikeCount") == 3) {
                referee.sayGameEnded();
                option = Console.readLine();
                UserInputValueValidator.getInstance().validate(List.of(option));
            }
        }

        if (Integer.parseInt(option) == 1) {
            List<List<String>> initializedGame = initializeNewGame();
            userInputValue = initializedGame.get(0);
            computerGeneratedValue = initializedGame.get(1);
            operateRefereeJudgement(userInputValue, computerGeneratedValue);
        } else if (Integer.parseInt(option) != 2) {
            throw new IllegalArgumentException();
        }
    }
}
