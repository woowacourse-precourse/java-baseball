package baseball.game;

import baseball.domain.BaseballNumberBundle;
import baseball.domain.GameProgress;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static final int NUMBER_OF_BASEBALL = 3;
    private static final String SEPARATOR_PATTERN = "[\n]*[\t]*[ ]*[.]*[,]*[/]*";

    public BaseballNumberBundle inputBaseballNumbers() {
        List<Integer> list = new ArrayList<Integer>();

        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();  // 사용자로부터 3개의 숫자값을 입력받음
        input = removeSeparator(input);
        for (String s : input.split("")) {
            numberValid(s);
            int number = Integer.parseInt(s);
            list.add(number);
        }
        baseballValid(list);

        return new BaseballNumberBundle(list);
    }

    public GameProgress inputGameProgress() {
        String input = Console.readLine();  // 사용자로부터 1개의 숫자값을 입력받음
        input = removeSeparator(input);
        numberValid(input);

        // 입력된 숫자를 GameProgress 형태로 반환
        int number = Integer.parseInt(input);
        progressValid(number);
        return GameProgress.values()[number - 1];
    }

    public String removeSeparator(String input) {
        return input.replaceAll(SEPARATOR_PATTERN, "");
    }

    public void numberValid(String input) {
        if (!input.matches("[1-9]+")) {
            throw new IllegalArgumentException();
        }
    }

    public void baseballValid(List<Integer> list) {
        if (list.size() > NUMBER_OF_BASEBALL) {
            throw new IllegalArgumentException();
        }
    }

    public void progressValid(int number) {
        if (number != GameProgress.CONTINUE.getProgress() && number != GameProgress.STOP.getProgress()) {
            throw new IllegalArgumentException();
        }
    }
}
