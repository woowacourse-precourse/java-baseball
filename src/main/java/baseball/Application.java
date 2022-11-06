package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> targetNumbers = makeRandomWithoutDuplicate();
        System.out.println(targetNumbers);
        System.out.println("숫자 야구 게임을 시작합니다.");
        Game game = new Game(scanner);
        game.play(targetNumbers);

    }

    private static List<Integer> makeRandomWithoutDuplicate() {

        List<Integer> randomValues = new ArrayList<>();
        while (randomValues.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomValues.contains(randomNumber)) {
                randomValues.add(randomNumber);
            }
        }
        return randomValues;
    }


}
