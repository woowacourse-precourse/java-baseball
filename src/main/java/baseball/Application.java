package baseball;

public class Application {
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            BullsAndCows bullsAndCows = new BullsAndCows(new BullsAndCowsResult());

            while (!bullsAndCows.getBullsAndCowsResult().isFinish()) {
                bullsAndCows.startGame();
            }

            boolean bullsAndCowsContinue = bullsAndCows.isContinue();
            if (!bullsAndCowsContinue) {
                break;
            }
        }
    }
}