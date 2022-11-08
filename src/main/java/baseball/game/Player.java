package baseball.game;

import baseball.domain.BaseballNumberBundle;
import baseball.domain.GameProgress;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static final String SEPARATOR_PATTERN = "[\n]*[\t]*[ ]*[.]*[,]*[/]*";
    public BaseballNumberBundle inputBaseballNumbers() {
        List<Integer> list = new ArrayList<Integer>();

        String input = Console.readLine();  // 사용자로부터 3개의 숫자값을 입력받음
        input = removeSeparator(input);
        for(String s : input.split("")) {
            numberValid(s);
            int number = Integer.parseInt(s);
            list.add(number);
        }
        baseballVaild();

        return new BaseballNumberBundle(list);
    }
    public GameProgress inputGameProgress() {
        String input = Console.readLine();  // 사용자로부터 1개의 숫자값을 입력받음
        input = removeSeparator(input);
        numberValid(input);
        int number = Integer.parseInt(input);

        progressVaild();
        return GameProgress.values()[number];
    }

    public String removeSeparator(String input) {
        return input.replaceAll(SEPARATOR_PATTERN, "");
    }
    public void numberValid(String input) {
        if(!input.matches("[0-9]+")) {
            throw new IllegalArgumentException("숫자가 아닌 입력이 들어왔습니다." + input);
        }
    }
    public void baseballVaild(){
    }
    public void progressVaild() {
    }
}
