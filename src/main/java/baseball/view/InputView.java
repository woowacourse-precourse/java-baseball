package baseball.view;

import baseball.util.Validator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static final String SELECT_RESTART = "게임을 새로 시작하려면1, 종료하려면 2를 입력하세요.";
    private static final Validator validator = new Validator();


    public String inputGameNumber(){
        System.out.print(INPUT_NUMBER);

        String numbers = Console.readLine();
        validator.isValidator(numbers);

        return numbers;
    }

    public boolean selectReStartGame(){
        System.out.println(SELECT_RESTART);

        String select = Console.readLine();
        validator.isRightSelect(select);

        if(select.equals("1"))
            return true;

        return false;
    }
}