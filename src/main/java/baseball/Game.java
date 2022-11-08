package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Game {
    public static final int MAX_ANSWER_SIZE = 3;
    public static final int MIN_ANSWER_NUMBER = 1;
    public static final int MAX_ANSWER_NUMBER = 9;

//    private final static Opponent opponent = new Opponent();
    private List<Integer> answerList;

    public void start() {
        while (true) {
            if (play() == 2) {
                break;
            }
        }
    }

    public int play() {
        initAnswerList();
        System.out.println(GameMessage.START.message());

        guessWithHint();
        System.out.println(GameMessage.CORRECT.message());

        System.out.println(GameMessage.REPLAY_OR_END.message());
        return Integer.parseInt(Console.readLine());
    }

    private void initAnswerList() {
        answerList = new ArrayList<>();
        while (answerList.size() < MAX_ANSWER_SIZE) {
            int randomNum = Randoms.pickNumberInRange(MIN_ANSWER_NUMBER,
                    MAX_ANSWER_NUMBER);
            if (!answerList.contains(randomNum)) {
                answerList.add(randomNum);
            }
        }

        System.out.println("randomNumberList = " + answerList);
    }

    public void guessWithHint() {
        Hint hint = new Hint(answerList);
        while (true) {
            System.out.print(GameMessage.TYPE_USER_GUESS.message());
            String input = Console.readLine();
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
