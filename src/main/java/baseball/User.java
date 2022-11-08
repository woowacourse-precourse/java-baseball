package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class User {

    private final int INPUT_LENGTH = 3;

    public List<Integer> getUserPredictedAnswer() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine().trim();

        List<Integer> guess = ListUtil.stringToSeparatedIntegerList(input,INPUT_LENGTH);
        if (UserInputException.hasSameNumberInList(guess)) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }

        return guess;
    }




}
