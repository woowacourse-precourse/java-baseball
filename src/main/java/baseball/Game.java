package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.*;

class Game {

    private List<Integer> randomNumberList;


    public void start() {
        while (true) {
            if (play() == 2) {
                break;
            }
        }
    }

    public int play() {
        initRandomNum();
        System.out.println("숫자 야구 게임을 시작합니다");
        guessWithHint();
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int replay = Integer.parseInt(readLine());
        return replay;
    }

    private void initRandomNum() {
        randomNumberList = new ArrayList<>();
        while (randomNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber);
            }
        }

        System.out.println("randomNumberList = " + randomNumberList);
    }

    public void guessWithHint() {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = readLine();
            List<Integer> guess = Arrays.stream(input.split(""))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());

            if (isCorrect(guess))
                return;
            String hint = getHint(guess);
            System.out.println(hint);
        }
    }

    private String getHint(List<Integer> guess) {
        return " ";
    }

    private boolean isCorrect(List<Integer> guess) {
        return guess.get(0).equals(randomNumberList.get(0))
                && guess.get(1).equals(randomNumberList.get(1))
                && guess.get(2).equals(randomNumberList.get(2));
    }
}
