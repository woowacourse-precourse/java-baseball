package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {


    List<Integer> computer = new ArrayList<>();
    String prediction = null;
    String[] splitprediction = prediction.split("");
    int[] ArrPrediction = new int[splitprediction.length];
    int[] ArrComputer = new int[computer.size()];
    int strike = 0;
    int ball = 0;
    int inputEndOrRestart;


    public void makeRandomValue() {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public int[] compareRandomValue() {
        int[] ArrComputer = new int[computer.size()];
        for (int b = 0; b < computer.size(); b++) {
            ArrComputer[b] = computer.get(b).intValue();
        }
        return ArrComputer;
    }

    public int[] setPrediction() {
        System.out.println("숫자를 입력하세요");
        String prediction = Console.readLine();
        String[] splitprediction = prediction.split("");
        int[] intprediction = new int[splitprediction.length];
        for (int i = 0; i < splitprediction.length; i++) {
            ArrPrediction[i] = Integer.parseInt(splitprediction[i]);
        }
        return ArrPrediction;
    }

    public void isNotNumber() {
        for (int c = 0; c < prediction.length(); c++) {
            char charPrediction = prediction.charAt(c);
            if ('0' > charPrediction || '9' < charPrediction) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void setStrikeAndBall() {
        for (int a = 0; a < ArrPrediction.length; a++) {
            if (ArrPrediction[a] == ArrComputer[a]) {
                strike += 1;
                System.out.println(strike + "스트라이크");
            } else if (Arrays.asList(ArrComputer).contains(ArrPrediction)) {
                ball += 1;
                System.out.println(ball + "볼");
            } else System.out.println("낫싱");
        }
    }

    public void fourBall() {
        if (ball == 4) {
            ball = 0;
            strike += 1;
        }
    }

    public void gameEndOrRestart() {
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다 게임종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력해주세요");
            String EndOrRestart = Console.readLine();
            int inputEndOrRestart = Integer.parseInt(EndOrRestart);
            if (inputEndOrRestart == 1) {
                System.out.println("게임을 새로 시작합니다");
                makeRandomValue();
                compareRandomValue();
                setPrediction();
                isNotNumber();
                setStrikeAndBall();
                isNotNumber();
                setStrikeAndBall();
                fourBall();
            } else if (inputEndOrRestart == 0) {
                System.out.println("게임을 종료합니다");
            }

        }
    }

}
