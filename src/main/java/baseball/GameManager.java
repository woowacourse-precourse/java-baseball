package baseball;

/**
 * 게임의 진행에 대한 책임을 지는 클래스
 */
public class GameManager {
    private static final String START_GAME = "숫자 야구 게임을 시작합니다.";
    private static final String PLEASE_INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static final String END_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_OR_END = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private final ComputerManager computerManager;
    private final InputNumber inputNumber;

    public GameManager() {
        this.computerManager = new ComputerManager();
        this.inputNumber = new InputNumber();
    }

    public void startGame() {
        System.out.println(START_GAME);

        while (true) {
            if (playBaseBall().equals("2")) {
                break;
            }
        }
    }

    private String playBaseBall() {
        computerManager.generateRandomNumber();

        while (true) {
            System.out.print(PLEASE_INPUT_NUMBER);
            String number = inputNumber.inputGameNumber();
            String compareResult = computerManager.compareWithUserNumber(number);

            if (compareResult.equals("3스트라이크")) {
                System.out.println(END_GAME);
                System.out.println(RESTART_OR_END);
                return inputNumber.inputRestartNumber();
            }

            System.out.println(compareResult);
        }
    }
}
