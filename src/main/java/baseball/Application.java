package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.domain.Balls;
import baseball.domain.Result;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean keepGame = true;
        while (keepGame){
            startGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            keepGame = restartOrNot();
        }

    }
    private static void startGame() {
        Balls computerBalls = new Balls(makeRandomNumbers());
        Balls playerBalls;
        Result result;
        boolean keepReading = true;
        while (keepReading) {
            System.out.print("숫자를 입력해주세요 : ");
            playerBalls = new Balls(readLine());
            result = computerBalls.play(playerBalls);
            System.out.println(result);
            if (result.equals(new Result(0,3))) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
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
