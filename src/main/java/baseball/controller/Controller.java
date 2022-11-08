package baseball.controller;

import baseball.game.Game;
import baseball.view.InputView;
import baseball.view.OutputView;

import static baseball.config.ControllerConstants.COMMAND_ERROR_MESSAGE;
import static baseball.config.ControllerConstants.COMMAND_INPUT_MESSAGE;
import static baseball.config.ControllerConstants.INIT_MESSAGE;

/**
 * 게임을 작동시키기 위한 컨트롤러입니다
 */
public final class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    private Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        initController();
    }

    /**
     * Controller객체를 생성하기 위한 정적 팩토리 메서드 입니다
     *
     * @param inputView  사용자의 입력을 담당하는 인스턴스를 받습니다
     * @param outputView 사용자의 출력을 담당하는 인스턴스를 받습니다
     * @return View를 가지게 된 Controller객체
     */
    public static Controller createWithViews(InputView inputView, OutputView outputView) {
        return new Controller(inputView, outputView);
    }

    /**
     * 게임을 받아서 컨트롤러에서 게임을 실행시키는 메서드
     *
     * @param game Game인터페이스를 구현한 게임 객체
     */
    public void runGame(Game game) {
        CommandKey commandKey = CommandKey.RETRY;

        while (commandKey != CommandKey.FINISH) {
            RandomInRange randomGenerator = new MissionRandom();
            game.play(randomGenerator);
            commandKey = getCommandFromInput();
        }
    }

    private CommandKey getCommandFromInput() {
        try {
            printCommandInputMessage();
            String inputLine = inputView.readLine();
            int key = Integer.parseInt(inputLine);
            return CommandKey.from(key);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            throw new IllegalArgumentException(COMMAND_ERROR_MESSAGE, e);
        }
    }

    private void printCommandInputMessage() {
        outputView.print(COMMAND_INPUT_MESSAGE);
    }

    void initController() {
        outputView.print(INIT_MESSAGE);
    }
}
