package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class InputReplay implements Input{

    @Override
    public String input(int size) {
        final String INPUT_TEXT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        String inputReplay;
        System.out.println(INPUT_TEXT);
        inputReplay = Console.readLine();
        validateInput(inputReplay, size);
        return inputReplay;
    }

    @Override
    public void validateInput(String input, int size) {
        Pattern p = Pattern.compile("[1-2]{"+size+"}");
        if (!p.matcher(input).matches()) {
            throw new IllegalArgumentException();
        }
    }
}
