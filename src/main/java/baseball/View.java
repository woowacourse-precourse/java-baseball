package baseball;

public class View {

    private static final String LINE_SEPARATOR = System.lineSeparator();

    private static class ViewHolder {

        private static final View INSTANCE = new View();

    }

    private View() {

    }

    public static View getInstance() {
        return ViewHolder.INSTANCE;
    }

    public void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printPlayerTurn() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printNoting() {
        System.out.println("낫싱");
    }

    public void printCorrect() {
        StringBuilder correctMsg = new StringBuilder();

        correctMsg.append("3스트라이크").append(LINE_SEPARATOR)
            .append("3개의 숫자를 모두 맞히셨습니다! 게임 종료").append(LINE_SEPARATOR)
            .append("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        System.out.println(correctMsg);
    }

    public void printBallAndStrike(int countOfBall, int countOfStrike) {
        if (countOfBall != 0 && countOfStrike != 0) {
            System.out.printf("%d볼 %d스트라이크%s", countOfBall, countOfStrike, LINE_SEPARATOR);
            return;
        }

        if (countOfBall != 0) {
            System.out.printf("%d볼%s", countOfBall, LINE_SEPARATOR);
            return;
        }

        System.out.printf("%d스트라이크%s", countOfStrike, LINE_SEPARATOR);
    }

}
