package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_RESTART_OR_STOP = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private final Computer computer;
    private final User user;
    private final GameService gameService;

    public Game() {
        computer = new Computer();
        user = new User();
        gameService = new GameService();
    }

    public void start() {
        System.out.println(START_MESSAGE);

        computer.generateAnswer();
        do {
            user.setUserNumber(inputUserNumber());
        } while (gameService.getPlayResult(user.getUserNumber(), computer.getAnswer()));

        if ("1".equals(inputRestartOrStop())) {
            start();
        }
    }

    public String inputRestartOrStop() {
        System.out.println(INPUT_RESTART_OR_STOP);
        String userInput = Console.readLine();
        InputException.checkInputRestartValidation(userInput);
        return userInput;
    }

    public String inputUserNumber() {
        System.out.println(INPUT_MESSAGE);
        String userInput = Console.readLine();
        InputException.checkInputNumberValidation(userInput);
        return userInput;
    }

}
