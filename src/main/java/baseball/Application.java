package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.domain.Balls;
import baseball.domain.MESSAGE;
import baseball.domain.Result;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println(MESSAGE.GAME_START);
        boolean keepGame = true;
        while (keepGame){
            inGame();
            System.out.println(MESSAGE.GAME_RESTART);
            keepGame = restartOrNot();
        }

    }
    private static void inGame() {
        Balls computerBalls = new Balls(makeRandomNumbers());
        Balls playerBalls;
        Result result;
        boolean keepReading = true;
        while (keepReading) {
            System.out.print(MESSAGE.READ_NUMBER);
            playerBalls = new Balls(readLine());
            result = computerBalls.play(playerBalls);
            System.out.println(result);
            if (result.equals(new Result(0,3))) {
                System.out.println(MESSAGE.GAME_END);
                keepReading = false;
            }
        }
    }
    private static List<Integer> makeRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    private static boolean restartOrNot() {
        boolean keepGame = true;
        String restart = readLine();
        if (!(restart.equals("1")||restart.equals("2"))) {
            throw new IllegalArgumentException("1혹은 2의 값을 입력해주세요");
        }
        if (restart.equals("2")) {
            keepGame = false;
        }
        return keepGame;
    }
}
