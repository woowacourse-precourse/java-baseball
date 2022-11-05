package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";

    private static final String START = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT = "숫자를 입력해주세요 : ";
    private static final String SUCCESS = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String END = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private Computer computer;
    private Boolean isEnd;

    public void start() {
        computer = new Computer();
        isEnd = false;
        System.out.println(START);
        play();
    }

    private void play() {
        while (isEnd.equals(false)) {
            System.out.println(INPUT);
            printResult(computer.getResultOfInput(getInput()));
        }
    }

    private static String getInput() {
        try {
            return Console.readLine();
        } catch (Exception e) {
            throw new IllegalArgumentException("입력값이 없습니다. 애플리케이션을 종료합니다.");
        }
    }

    private void end() {
        System.out.println(END);
        isEnd = true;
    }

    private void printResult(Result result) {
        if (result.equals(Result.NOTHING)) {
            System.out.println(NOTHING);
            return;
        }

        System.out.println(getBallString() + getStrikeString());
        if (result.equals(Result.ANSWER)) {
            System.out.println(SUCCESS);
            end();
        }
    }

    private String getStrikeString() {
        if (computer.getStrikeCount() > 0) {
            return computer.getStrikeCount().toString() + STRIKE + " ";
        } else {
            return "";
        }
    }

    private String getBallString() {
        if (computer.getBallCount() > 0) {
            return computer.getBallCount().toString() + BALL + " ";
        } else {
            return "";
        }
    }
}
