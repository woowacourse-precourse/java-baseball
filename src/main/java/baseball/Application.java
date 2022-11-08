package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
        String userNumber;

        System.out.println("숫자 야구 게임을 시작합니다.");

        System.out.print("숫자를 입력해주세요: ");
        Scanner sc = new Scanner(System.in);
        userNumber = Console.readLine();

        if (validNumber(userNumber)) {
            System.out.println("통과");
        } else {
            System.out.println("오류");
        }
    }

    private boolean validNumber(String userNumber) {
        List<String> userNumberList = new ArrayList<>(Arrays.asList(userNumber.split("")));
        if (userNumber.length() == 3 && userNumberList.size() == userNumberList.stream().distinct().count()) {
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        Application numberBaseballGame = new Application();
        numberBaseballGame.start();
    }
}