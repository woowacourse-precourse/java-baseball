package baseball;

public class Game {
    private RandomNumber random_number = new RandomNumber();

    public Game () {

    }

    public boolean routine () {
        while (true) {
            RoutineForOneInput routineForOneInput = new RoutineForOneInput(random_number.getRandomNumber());
            if (routineForOneInput.routine()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return true;
            }
        }
    }
}
