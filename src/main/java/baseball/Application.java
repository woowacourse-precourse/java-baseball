package baseball;

import baseball.util.BaseBallGame;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Application {
    private static final int RESTART_CODE = 1;
    private static final int END_CODE = 2;


    public static void main(String[] args) {
        int statusCode = 0;

        do {
            System.out.println("숫자 야구 게임을 시작합니다.");

            List<Integer> threeRandomValue = notDuplicatedThreeRandomValue();
            
            BaseBallGame baseBallGame = new BaseBallGame(threeRandomValue);
            baseBallGame.gameStart();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            statusCode = askRestartOrEnd();
        } while (statusCode == RESTART_CODE);

        if (statusCode != END_CODE) {
            throw new IllegalArgumentException();
        }

    }


    private static int askRestartOrEnd() throws IllegalArgumentException {
        String restartOrEndOrError = Console.readLine();

        if (!restartOrEndOrError.matches("[12]")) {
            throw new IllegalArgumentException();
        }

        return Integer.valueOf(restartOrEndOrError);
    }


    private static List<Integer> notDuplicatedThreeRandomValue() {
        List<Integer> randomValues = new ArrayList<>();
        while (randomValues.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!randomValues.contains(randomNumber)) {
                randomValues.add(randomNumber);
            }
        }

        return List.copyOf(randomValues);
    }
}
