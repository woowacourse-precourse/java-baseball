package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Application {
    private final String correctNumber;

    public Application() {
        int[] randomNumberSet = new int[3];
        for (int i = 0; i < 3; i++) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            randomNumberSet[i] = randomNumber;
        }

        correctNumber = Arrays.stream(randomNumberSet).mapToObj(String::valueOf).collect(Collectors.joining(""));
    }

    public void start() {
        // 숫자야구게임 시작
        System.out.println(correctNumber);
    }

    public static void main(String[] args) {
        Application numberBaseballGame = new Application();
        numberBaseballGame.start();
    }
}