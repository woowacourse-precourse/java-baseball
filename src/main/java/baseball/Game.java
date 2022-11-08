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
    public static final int REPLAY = 1;
    public static final int EXIT = 2;

    private List<Integer> answerList;

    public void start() {
        while (true) {
            if (play() == EXIT) {
                break;
            }
        }
    }

    public int play() {
        answerList = initAnswerList();
        System.out.println(GameMessage.START.message());

        Hint hint = new Hint(answerList);
        while (true) {
            System.out.print(GameMessage.TYPE_USER_GUESS.message());

            List<Integer> guess = getUserGuess();
            if (isCorrect(guess))
                break;

            System.out.println(hint.retrieve(guess));
        }

        System.out.println(GameMessage.CORRECT.message());
        System.out.println(GameMessage.REPLAY_OR_END.message());

        return getRegameOption();
    }

    private int getRegameOption() {
        int input = Integer.parseInt(Console.readLine());
        if(input != REPLAY && input != EXIT)
            throw new IllegalArgumentException("1 혹은 2를 입력하지 않으셨습니다.");
        return input;
    }

    private List<Integer> initAnswerList() {
        List<Integer> answerList = new ArrayList<>();
        while (answerList.size() < MAX_ANSWER_SIZE) {
            int randomNum = Randoms.pickNumberInRange(MIN_ANSWER_NUMBER,
                    MAX_ANSWER_NUMBER);
            if (!answerList.contains(randomNum)) {
                answerList.add(randomNum);
            }
        }

        System.out.println("randomNumberList = " + answerList);
        return answerList;
    }

    public List<Integer> getUserGuess() {
        String input = Console.readLine();
        List<Integer> guess = Arrays.stream(input.split(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        for(int g : guess){
            if(!(1 <= g && g <= 9))
                throw new IllegalArgumentException("입력 숫자 범위는 1~9 여야 합니다.");
        }
        return guess;
    }

    private boolean isCorrect(List<Integer> guess) {
        return guess.get(0).equals(answerList.get(0))
                && guess.get(1).equals(answerList.get(1))
                && guess.get(2).equals(answerList.get(2));
    }
}
