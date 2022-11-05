package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameApplication {
    private static final String GameStart_sentence = "숫자 야구 게임을 시작합니다.";
    private static final String RestartOrExit_sentence = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String Nothing_sentence = "낫싱";
    private static final String Strike_sentence = "스트라이크";
    private static final String Ball_sentence = "볼";
    private static final String RightAnswer_sentence = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private List<Integer> computer;
    private List<Integer> user;
    private int[] result;

    public GameApplication() {
    }

    public void gameStart() {
        while (true) {
            baseballGame();

            System.out.print(RestartOrExit_sentence);
            if (RestartOrExit()) break;
        }
    }

    // 재시작 || 종료를 입력하는 메소드
    private boolean RestartOrExit() {
        String input = Console.readLine();
        isRightInput(input);
        if (input.equals("2")) {
            return true;
        }
        return false;
    }

    // 입력 문자가 이 이외의 것일 경우
    private void isRightInput(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException();
        }
    }

    private void baseballGame() {
        System.out.println(GameStart_sentence);

        GameNumber computerNumber = new GameNumber();
        GameNumber userNumber = new GameNumber();
        GameNumber resultNumber = new GameNumber();

        computer = computerNumber.getComputerNumber();

        while (true) {
            user = userNumber.getUserNumber();
            // 결과 저장
            result = resultNumber.getResult(computer, user);

            // 결과 프린트
            System.out.println(printResult(result));

            if (executeApplication(result)) break;
        }
    }

    // 결과를 프린트하는 메소드
    public String printResult(int[] result) {
        StringBuilder sb = new StringBuilder();
        // result[0] = strike, result[1] = ball
        if (isSame(0, result[0]) && isSame(0, result[1])) { // strike ball 둘다 0인 경우
            sb.append(Nothing_sentence);
            return sb.toString();
        }
        if (isSame(0, result[1])) { // ball 이 0인 경우
            sb.append(result[0] + Strike_sentence);
            return sb.toString();
        }
        if (isSame(0, result[0])) { // strike 가 0인 경우
            sb.append(result[1] + Ball_sentence);
            return sb.toString();
        }
        sb.append(result[0] + Ball_sentence + " " + result[1] + Strike_sentence); // 둘다 0 보다 클 경우
        return sb.toString();
    }

    // 3스트라이크 시 프로그램 진행/종료 결정하는 메소드
    public boolean executeApplication(int[] result) {
        if (isSame(3, result[0])) { // strike == 3
            System.out.println(RightAnswer_sentence);
            return true;
        }
        return false;
    }

    // 파라미터 두개를 비교하는 메소드
    private boolean isSame(int num, int compareNum) {
        return num == compareNum;
    }
}
