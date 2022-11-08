package baseball;

public class BaseballGame {
    private Computer computer;
    private Player player;

    BaseballGame(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
    }

    public void preceedEntireGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            playOneGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        } while (player.continueGame());
        finishEntireGame();
    }

    private void playOneGame() {
        computer.ready();
        while (!computer.isGameEnd) {
            System.out.print("숫자를 입력해주세요 : ");
            computer.giveResult(player.suggest());
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private void finishEntireGame() {
        System.out.println("게임을 완전히 종료합니다.");
    }
}



