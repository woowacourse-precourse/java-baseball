package baseball;

public class Game {
    public final static String START_NOTIFICATION = "숫자 야구 게임을 시작합니다.";
    public final static String END_NOTIFICATION = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    Computer computer = new Computer();

    public void start() {
        System.out.println(START_NOTIFICATION);
    }

    public boolean isContainAnyNumber() {
        Player player = new Player();
        for (int i = 0; i < 3; i++) {
            if (computer.randomNumberListToString()
                    .contains(player.splitInputNumberToList().get(i))) {
                return true;
            }
        }
        return false;
    }
}
