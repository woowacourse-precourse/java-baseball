package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        Computer computer = new Computer();
        System.out.println(computer.Answer);
        Player player = new Player();

        player.guessAnswer();
        computer.resetHintMap();
        computer.makeHintMap(player.Answer);
        computer.giveHint();
    }
}
