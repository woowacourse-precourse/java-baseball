package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.*;

class Game {

    private final static Opponent opponent = new Opponent();
    private List<Integer> answerList;

    public void start() {
        while (true) {
            if (play() == 2) {
                break;
            }
        }
    }

    public int play() {
        initRandomNum();
        System.out.println(GameMessage.START.message());
        guessWithHint();
        System.out.println(GameMessage.CORRECT.message());

        System.out.println(GameMessage.REPLAY_OR_END.message());
        int replay = Integer.parseInt(readLine());
        return replay;
    }

    private void initRandomNum() {
        answerList = new ArrayList<>();
        while (answerList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerList.contains(randomNumber)) {
                answerList.add(randomNumber);
            }
        }

        System.out.println("randomNumberList = " + answerList);
    }

    public void guessWithHint() {
        Hint hint = new Hint(answerList);
        while (true) {
            System.out.print(GameMessage.TYPE_USER_GUESS.message());
            String input = readLine();
            List<Integer> guess = Arrays.stream(input.split(""))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());

            if (isCorrect(guess))
                return;

            System.out.println(hint.retrieve(guess));
        }
    }


    private boolean isCorrect(List<Integer> guess) {
        return guess.get(0).equals(answerList.get(0))
                && guess.get(1).equals(answerList.get(1))
                && guess.get(2).equals(answerList.get(2));
    }
}
