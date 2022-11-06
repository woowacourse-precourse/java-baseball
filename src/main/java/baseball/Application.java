package baseball;

import java.util.List;

public class Application {

    private static final String GAME_START_STRING = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_OVER_STRING = "게임 종료";
    private static final String THREE_STRIKE = "3스트라이크";

    public static void main(String[] args) {
        System.out.println(GAME_START_STRING);
        boolean isPlayAgain = true;

        while (isPlayAgain) {
            Player computer = new Player();
            computer.setComputerNumbers();
            List<Integer> computerNumbers = computer.getNumbers();

            String answer = "";
            Player user = new Player();
            while (!answer.equals(THREE_STRIKE)) {
                user.input();
                List<Integer> userNumbers = user.getNumbers();
                answer = Game.start(computerNumbers, userNumbers);
                System.out.println(answer);
            }
            isPlayAgain = Game.isPlayAgain();
        }

        System.out.println(GAME_OVER_STRING);
    }
}
