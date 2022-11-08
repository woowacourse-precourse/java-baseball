package baseball.Model;

import baseball.Model.Computer.Answer;
import baseball.Model.Computer.Computer;
import baseball.Model.Player.Player;

public final class Game {

    private static final int END_GAME = 2;

    private final Player player;
    private final Computer computer;

    public Game() {
        player = new Player();
        computer = new Computer();
    }

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            progress(computer.createAnswer());
        } while (player.chooseToContinue() != END_GAME);
    }

    public void progress(Answer answer) {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            if (player.guessAnswer(answer)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                break;
            }
        }
    }
}
