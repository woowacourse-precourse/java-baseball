package baseball;
import camp.nextstep.edu.missionutils.Console;

public class Game {
    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Computer computer = new Computer();
        Player player = new Player();

        while (true) {
            player.EnterNumberOfPlayer();
            InputException.checkExceptionNumber(player.playersNumber);

            String resultMessage = computer.compareWithNumberOfPlayer(player.playersNumber);
            System.out.println(resultMessage);
            if (resultMessage.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
        Game.checkGameRestart();
    }

    public static void checkGameRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String option = Console.readLine();

        if (option.equals("1")) {
            Game.startGame();
        }

        if (option.equals("2")) {
            System.out.println("게임을 종료합니다.");
        }

        if (!option.equals("1") && !option.equals("2")) {
            throw new IllegalArgumentException("옵션을 벗어나는 숫자를 입력했습니다.");
        }
    }
}
