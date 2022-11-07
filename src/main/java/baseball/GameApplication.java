package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.regex.Pattern;

public class GameApplication {
    private static final String GAME_START_SENTENCE = "숫자 야구 게임을 시작합니다.";
    private static final String RESTART_OR_EXIT_SENTENCE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String NOTHING_SENTENCE = "낫싱";
    private static final String STRIKE_SENTENCE = "스트라이크";
    private static final String BALL_SENTENCE = "볼";
    private static final String RIGHT_ANSWER_SENTENCE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String pattern = "^[1-2]$";

    private List<Integer> computer;
    private List<Integer> user;
    private int[] result;

    public GameApplication() {
    }

    // 게임 애플리케이션 시작 메소드
    public void gameStart() {
        while (true) {
            baseballGame();
            System.out.println(RESTART_OR_EXIT_SENTENCE);
            if (restartOrExit()) break;
        }
    }

    // 하나의 야구숫자게임을 진행하는 메소드
    private void baseballGame() {
        System.out.println(GAME_START_SENTENCE);

        GameNumber computerNumber = new GameNumber();
        GameNumber userNumber = new GameNumber();
        GameNumber resultNumber = new GameNumber();

        // 컴퓨터의 랜덤 숫자 저장
        computer = computerNumber.getComputerNumber();

        while (true) {
            // 사용자의 랜덤 숫자 저장
            user = userNumber.getUserNumber();
            // 결과 저장
            result = resultNumber.getResult(computer, user);

            // 결과 프린트
            System.out.println(printResult(result));

            // 3스트라이크 시 게임 종료
            if (executeApplication(result)) break;
        }
    }

    // 재시작 || 종료를 입력하는 메소드
    private boolean restartOrExit() {
        String input = Console.readLine();

        // 예외처리
        isRightInput(input);

        if (input.equals("2")) {
            return true;
        }
        return false;
    }

    // 입력 문자가 1과2 이외의 것일 경우, 자바 정규식 사용
    private void isRightInput(String input) {
        if (!(Pattern.matches(pattern, input))) {
            throw new IllegalArgumentException();
        }
    }

    // 결과를 프린트하는 메소드
    public String printResult(int[] result) {
        StringBuilder sb = new StringBuilder();
        // result[0] = strike, result[1] = ball
        if (isSame(0, result[0]) && isSame(0, result[1])) { // strike ball 둘다 0인 경우
            sb.append(NOTHING_SENTENCE);
            return sb.toString();
        }
        if (isSame(0, result[1])) { // ball 이 0인 경우
            sb.append(result[0] + STRIKE_SENTENCE);
            return sb.toString();
        }
        if (isSame(0, result[0])) { // strike 가 0인 경우
            sb.append(result[1] + BALL_SENTENCE);
            return sb.toString();
        }
        sb.append(result[0] + BALL_SENTENCE + " " + result[1] + STRIKE_SENTENCE); // 둘다 0 보다 클 경우
        return sb.toString();
    }

    // 3스트라이크 시 프로그램 진행/종료 결정하는 메소드
    public boolean executeApplication(int[] result) {
        if (isSame(3, result[0])) { // strike == 3
            System.out.println(RIGHT_ANSWER_SENTENCE);
            return true;
        }
        return false;
    }

    // 파라미터 두개를 비교하는 메소드
    private boolean isSame(int num, int compareNum) {
        return num == compareNum;
    }
}
