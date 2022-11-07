package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Application {
    static void runLoop() {
        RandomNumberGenerator answer = new RandomNumberGenerator();
        Guess myGuess;
        BallStrikeChecker checker;
        ResultBoard board;

        do {
            System.out.print("숫자를 입력해주세요 : ");
            myGuess = new Guess(Console.readLine());
            checker = new BallStrikeChecker(answer, myGuess);
            board = new ResultBoard(checker.judgement);
            board.showResult();
        } while (!checker.threeStrike);
    }

    static void endOrRestart() {
        NextBehavior next;

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        next = new NextBehavior(Console.readLine());
        if (next.decision == 1) {
            initializeAndStartGame();
            return;
        }
        if (next.decision == 2) {
            return;
        }
    }

    static void initializeAndStartGame() {
        runLoop();
        endOrRestart();
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        initializeAndStartGame();
    }
}
