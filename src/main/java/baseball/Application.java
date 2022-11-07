package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;


public class Application {

    // RandomNumberGenerator 내부로 들어갈 예정
    static void generateRandomNumber(ArrayList<Integer> answer) {
        while (answer.size() != 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    // 파싱을 사용하지 않아 불필요해질 예정
    static ArrayList<Integer> parseStringIntoInteger(String guess) {
        int guessIntFormat = Integer.parseInt(guess);
        ArrayList<Integer> parsed = new ArrayList<>();

        for (int divisor = 100; divisor != 0; guessIntFormat %= divisor, divisor /= 10) {
            parsed.add(guessIntFormat / divisor);
        }
        return parsed;
    }

    // Guess 내부로 들어갈 예정
    static boolean checkValidityOfGuess(String guess) throws IllegalArgumentException {
        Integer guessIntFormat = Integer.parseInt(guess);
        ArrayList<Integer> guessParsed = parseStringIntoInteger(guess);
        ;
        Set<Integer> uniqueElementOnly;

        if (guessIntFormat < 123 || guessIntFormat > 987) {
            throw new IllegalArgumentException("범위를 준수하지 않았습니다.");
        }

        for (Integer toCheck : guessParsed) {
            if (toCheck == 0) {
                throw new IllegalArgumentException("1부터 9까지의 수로만 이루어져야 합니다.");
            }
        }

        uniqueElementOnly = new HashSet<>(guessParsed);
        if (uniqueElementOnly.size() != guessParsed.size()) {
            throw new IllegalArgumentException("숫자의 중복이 있습니다.");
        }

        return true;
    }

    //BallStrikeChecker 내부로 들어갈 예정
    static ArrayList<Integer> countBallAndStrike(ArrayList<Integer> guessList, ArrayList<Integer> answers) {
        ArrayList<Integer> ballStrikeCnt = new ArrayList<>() {{
            add(0);
            add(0);
        }};
        Integer strikeCnt;
        Integer ballCnt;

        for (int idx = 0; idx < guessList.size(); idx++) {
            int guess = guessList.get(idx);
            if (guess == answers.get(idx)) {
                strikeCnt = ballStrikeCnt.get(1);
                ballStrikeCnt.set(1, ++strikeCnt);
            } else if (answers.contains(guess)) {
                ballCnt = ballStrikeCnt.get(0);
                ballStrikeCnt.set(0, ++ballCnt);
            }
        }

        return ballStrikeCnt;
    }

    // Board 내부로 들어갈 예정. 로직도 if else 문 쓰지 않고 string concat 활용 예정
    static void showResult(ArrayList<Integer> ballStrikeCnt) {
        Integer ball = ballStrikeCnt.get(0);
        Integer strike = ballStrikeCnt.get(1);

        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else if (strike == 3) {
            threeStrike = 1;
            System.out.println("3스트라이크");
        } else if (ball == 0) {
            System.out.printf("%d스트라이크\n", strike);
        } else if (strike == 0) {
            System.out.printf("%d볼\n", ball);
        } else {
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
        }
    }

    // 내부에 기술된 메소드들 각각 다른 클래스로 찢어져 들어갈 예정
    static void judgeGuess(String guess, ArrayList<Integer> answer) {
        ArrayList<Integer> guessParsed;
        ArrayList<Integer> ballStrikeCnt;

        guessParsed = parseStringIntoInteger(guess);
        ballStrikeCnt = countBallAndStrike(guessParsed, answer);
        showResult(ballStrikeCnt);
    }

    static void runLoop() {
        /*
        RandomNumberGenerator answer = new RandomNumberGenerator();
        Guess myGuess;
        BallStrikeChecker checker = new BallStrikeChecker();
        ResultBoard board;

        while(checker.threeStrike){
            System.out.println("숫자를 입력해주세요 : ");
            myGuess= new Guess(Console.readLine());
            checker.countBallAndStrike(answer,myGuess);
            board = new ResultBoard(checker.judgement);
            board.showResult();
        }*/
    }

    static void endOrRestart()  {
        //NextBehavior next;

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

       /* next = new NextBehavior(Console.readLine());
        if (next.decision == 1) {
            initializeAndStartGame();
            return;
        }
        if (next.decision == 2) {
            return;
        }*/

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
