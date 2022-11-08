package baseball.view;

import static baseball.constant.Finish.getFinishByCode;
import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.constant.Finish;
import baseball.hint.Hint;
import baseball.input.InputController;
import baseball.validator.AnswerValidator;
import baseball.validator.FinishValidator;
import java.util.List;

public class ConsoleView implements View {

    private final InputController inputController;
    private final AnswerValidator answerValidator = new AnswerValidator();
    private final FinishValidator finishValidator = new FinishValidator();

    public ConsoleView(InputController inputController) {
        this.inputController = inputController;
    }

    @Override
    public List<Integer> inputUser() {
        String input = inputString();
        return inputController.convertToIntegerList(input);
    }

    @Override
    public void printHint(Hint hint) {
        String hintMessage = inputController.convertHintToString(hint);
        System.out.println(hintMessage);
    }

    @Override
    public void printInlineMessage(String message) {
        System.out.print(message);
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public Finish inputFinishCode() {
        String input = readLine();
        finishValidator.checkValid(input);
        return getFinishByCode(input);
    }

    private String inputString() {
        String input = readLine();
        answerValidator.checkValid(input);
        return input;
    }
}