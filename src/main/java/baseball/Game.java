package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

import static baseball.GameMessage.*;
import static baseball.GameOption.*;

class Game {
    private List<Integer> answerList;

    public void start() {
        while (true) {
            if (play() == EXIT.option()) {
                break;
            }
        }
    }

    private int play() {
        answerList = initAnswerList();
        System.out.println(START.message());

        Hint hint = new Hint(answerList);
        while (true) {
            System.out.print(TYPE_USER_GUESS.message());

            List<Integer> guess = getUserGuess();
            if (isCorrect(guess))
                break;

            System.out.println(hint.retrieve(guess));
        }

        System.out.println(CORRECT.message());
        System.out.println(REPLAY_OR_END.message());

        return getRegameOption();
    }

    private int getRegameOption() {
        int input = Integer.parseInt(Console.readLine());
        if (input != REPLAY.option() && input != EXIT.option())
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_OPTION.message());
        return input;
    }

    private List<Integer> initAnswerList() {
        List<Integer> answerList = new ArrayList<>();
        while (answerList.size() < ANSWER_SIZE.option()) {
            int randomNum = Randoms.pickNumberInRange(MIN_ANSWER_NUMBER.option(),
                    MAX_ANSWER_NUMBER.option());
            if (!answerList.contains(randomNum)) {
                answerList.add(randomNum);
            }
        }

        return answerList;
    }

    private List<Integer> getUserGuess() {
        String input = Console.readLine();
        List<Integer> guess = formatInputToGuess(input);

        validateInputDuplicate(guess);
        validateInputSize(guess);
        validateInputRange(guess);

        return guess;
    }

    private List<Integer> formatInputToGuess(String input) {
        List<Integer> guess;
        try {
            guess = Arrays.stream(input.split(""))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_GUESS_NUMBER_FORMAT.message());
        }
        return guess;
    }

    private void validateInputRange(List<Integer> guess) {
        for (int g : guess) {
            if (!(MIN_ANSWER_NUMBER.option() <= g && g <= MAX_ANSWER_NUMBER.option()))
                throw new IllegalArgumentException(ILLEGAL_ARGUMENT_GUESS_RANGE.message());
        }
    }

    private void validateInputSize(List<Integer> guess) {
        if (guess.size() != ANSWER_SIZE.option())
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_GUESS_SIZE.message());
    }

    private void validateInputDuplicate(List<Integer> guess) {
        Set<Integer> inputSet = new HashSet<>();
        for (Integer num : guess) {
            if (inputSet.contains(num)) {
                throw new IllegalArgumentException(ILLEGAL_ARGUMENT_GUESS_DUPLICATE.message());
            }
            inputSet.add(num);
        }
    }

    private boolean isCorrect(List<Integer> guess) {
        return guess.get(0).equals(answerList.get(0))
                && guess.get(1).equals(answerList.get(1))
                && guess.get(2).equals(answerList.get(2));
    }
}
