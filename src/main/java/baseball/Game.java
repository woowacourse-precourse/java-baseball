package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    private List<Integer> answer;
    private BallCount ballcount;

    // Initializer
    public Game() {
        ballcount = new BallCount();
    }

    // <Func> : Initialize new game
    public void initGame() {
        setAnswer();
        ballcount.initCount();
    }

    // <Func> : Set random answer using pickNumberInRange()
    private void setAnswer() {
        answer = new ArrayList<>();

        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    // <Func> : Get certain answer for testing (Overloading)
    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }

    // <Func> : Check user's answer and real answer
    public BallCount checkAnswer(List<Integer> guess) {

        ballcount.initCount();
        for (int i = 0; i < 3; i++) {
            // same index same number
            if (answer.get(i) == guess.get(i)) {
                ballcount.strikeUp();
            } else if (answer.contains(guess.get(i))) {
                ballcount.ballUp();
            }
        }
        // Print ball count and init it
        printCount();

        return ballcount;
    }

    // <Func> : Print ball count
    private void printCount() {

        if (ballcount.getStrike() == 0 && ballcount.getBall() == 0) {
            System.out.println("낫싱");
        } else {
            if (ballcount.getBall() != 0) {
                System.out.print(ballcount.getBall() + "볼 ");
            }
            if (ballcount.getStrike() != 0) {
                System.out.print(ballcount.getStrike() + "스트라이크 ");
            }
            System.out.println();
        }
    }

    // <Func> : Check game is over and boolean value
    public boolean isOver() {

        if (ballcount.getStrike() == 3) {
            return true;
        }
        return false;
    }

    // <Func> : Check input String length
    public Boolean checkInputFormat(String input) {

        // for check Test
        if (input.length() >= 4) {
            throw new IllegalArgumentException();
        }

        return true;
    }

    // <Func> : Convert String to List<Integer>
    public List<Integer> convertString(String input) {
        List<Integer> inputToListInt = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            inputToListInt.add(Character.getNumericValue(input.charAt(i)));
        }

        return inputToListInt;
    }

    public boolean askRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String decide;
        while (true) {
            decide = readLine();
            if (decide.equals("1")) {
                return true;
            } else if (decide.equals("2")) {
                return false;
            } else {
                System.out.println("1과 2중 하나만을 입력해주세요.");
            }
        }
    }

    // <Func> : Run game
    public void run() {
        boolean keepGoing = true;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (keepGoing == true) {
            initGame();
            while (isOver() == false) {
                System.out.print("숫자를 입력해주세요 : ");
                String inputNum = readLine();

                checkInputFormat(inputNum);

                List<Integer> inputNumList = convertString(inputNum);
                checkAnswer(inputNumList);
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            keepGoing = askRestart();
        }
    }
}
