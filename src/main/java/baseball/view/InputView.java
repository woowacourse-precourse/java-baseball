package baseball.view;

import baseball.utils.ValidNumber;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PLEASE_INPUT = "숫자를 입력해주세요 : ";
    private static final String CHOICE_QUIT_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";

    public static String inputNumber() {
        System.out.print(PLEASE_INPUT);
        String inputNumber = Console.readLine();
        ValidNumber.validUserNumber(inputNumber);
        return inputNumber;
    }

    public static boolean restartChoiceNumber() {
        System.out.println(CHOICE_QUIT_RESTART);
        String restartChoiceNumber = Console.readLine();
        return ValidNumber.validRestartNumber(restartChoiceNumber);
    }
}
