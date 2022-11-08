package baseball;

public class Controller {
    private boolean newGame; // 새 게임을 진행하는지 여부

    public Controller() {
        this.newGame = true;
    }

    public void runGame() // 게임 진행 및 출력문 출력
    {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Player player = new Player();
        Computer computer = new Computer();
        while (newGame) {
            computer.initComputer();
            while (!computer.endGame()) {
                System.out.print("숫자를 입력해주세요 : ");
                player.inputPlayerNumber();
                computer.setStrikeCount(computer.countStrike(player.getPlayerNumberList()));
                computer.setBallCount(computer.countBall(player.getPlayerNumberList()));
                computer.printResult();
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            newGame = player.inputNewGame();
        }
    }
}
