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
    public boolean answer = false;
    public List<Integer> inputNum = new ArrayList<>();
    public List<Integer> comNum = new ArrayList<>();

    public Application(){
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
    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (!answer){
            getInputNum();
            setAnswer();
            showResult();
            resetStrikeBall();
        }
    }

    public void getInputNum() {
        System.out.print("숫자를 입력해주세요 : ");
        String[] numChar = Console.readLine().split("");
        inputNum = Arrays.stream(numChar).map(Integer::parseInt).collect(Collectors.toList());
    }

    public void setAnswer() {
        for (int number: inputNum){
            if (inputNum.indexOf(number) == comNum.indexOf(number)){
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
            System.out.printf("%d스트라이크\n", ball);
        } else {
            System.out.print("낫싱\n");
        }
    }

    public void resetStrikeBall() {
        strike = 0;
        ball = 0;
    }

    public static void main(String[] args) {
        Application app = new Application();
    }
}
