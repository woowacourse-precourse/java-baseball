package baseball;

public class OutputView {
    final String START_MESSAGE = "숫자야구 게임을 시작합니다.";
    final String FINISH_GAME_MESSAGE = Computer.NUMBER_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    final String KEEP_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    final String END_PROGRAM_MESSAGE = "프로그램을 종료합니다.";
    final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    final String NOTHING = "낫싱";

    void printStart() {
        System.out.println(START_MESSAGE);
    }

    void printKeepGame() {
        System.out.println(FINISH_GAME_MESSAGE);
        System.out.println(KEEP_GAME_MESSAGE);
    }

    void printEndProgram() {
        System.out.println(END_PROGRAM_MESSAGE);
    }

    void printInput() {
        System.out.print(INPUT_MESSAGE);
    }

    void printResult(int strike, int ball) {
        if (strike == 0 & ball == 0) {
            System.out.println(NOTHING);
            return;
        }
        if (ball != 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike != 0) {
            System.out.print((strike + "스트라이크"));
        }
        System.out.println();
    }
}
