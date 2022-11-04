package baseball;

import camp.nextstep.edu.missionutils.Console;


enum MessageType {
    BALL_MESSAGE("볼 "),
    STRIKE_MESSAGE("스트라이크"),
    NOTHING_MESSAGE("낫싱");

    private final String message;

    MessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

public class Application {

    static User user = new User();
    static Computer computer = new Computer();
    static GameScores gameScores = new GameScores();

    public static boolean isGameOver() {
        return gameScores.getStrikeCount() == 3;
    }

    public static int getGameSelect() {
        String gameSelect = Console.readLine();
        if (!gameSelect.equals("1") && !gameSelect.equals("2")) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            getGameSelect();
        }
        return Integer.parseInt(gameSelect);
    }

    public static void startGameLogic() {
        computer.setComputerNumber();
        do {
            gameScores.gameScoresZero();
            System.out.print("숫자를 입력해주세요 : ");
            user.setUserNumber();
            if (user.getUserNumber().isEmpty()) {
                break;
            }
            gameScores.printGameResult(user.getUserNumber(), computer.getComputerNumber());
        } while (!isGameOver());
    }

    public static void main(String[] args) {
        int gameSelect;
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            startGameLogic();
            if (user.getUserNumber().isEmpty()) {
                break;
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            gameSelect = getGameSelect();
        } while (gameSelect != 2);
    }
}
