package baseball;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public int ball = 0;
    public int strike = 0;
    public boolean answer = true;
    public List<Integer> inputNum = new ArrayList<>();
    public List<Integer> comNum = new ArrayList<>();

    public Application() throws IllegalArgumentException {
        createNum();
        startGame();
    }

    public void createNum() {
        while (comNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!comNum.contains(randomNumber)) {
                comNum.add(randomNumber);
            }
        }
    }
    public void startGame() throws IllegalArgumentException {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (answer) {
            try {
                getInputNum();
                setAnswer();
                showResult();
                checkAnswer();
            } catch (IllegalArgumentException e){
                answer = false;
                throw e;
            }
        }
    }

    public void getInputNum() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        String numChar = Console.readLine();

        if (numChar.length() != 3){
            throw new IllegalArgumentException();
        }

        // numChar로 받은 input을 stream으로 List<Integer> 타입으로 변환
        inputNum = Arrays.stream(numChar.split("")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public void setAnswer() {
        for (int number: inputNum) {
            if (inputNum.indexOf(number) == comNum.indexOf(number)) {
                strike += 1;
            } else if (comNum.contains(number)) {
                ball += 1;
            }
        }
    }

    public void showResult() {
        if (ball != 0 && strike != 0) {
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
        } else if (ball != 0) {
            System.out.printf("%d볼\n", ball);
        } else if (strike != 0) {
            System.out.printf("%d스트라이크\n", strike);
        } else {
            System.out.print("낫싱\n");
        }
    }

    public void checkAnswer() {
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            startOrNot();
        } else {
            resetStrikeBall();
        }
    }

    public void resetStrikeBall() {
        strike = 0;
        ball = 0;
    }

    public void startOrNot() throws IllegalArgumentException {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String cont = Console.readLine();
        if (cont.equals("1")) {
            resetAll();
        } else if (cont.equals("2")) {
            answer = false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void resetAll() {
        strike = 0;
        ball = 0;
        answer = true;
        inputNum = new ArrayList<>();
        comNum = new ArrayList<>();
        createNum();
    }

    public static void main(String[] args) {
        new Application();
    }
}