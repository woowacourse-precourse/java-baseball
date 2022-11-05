package baseball;

import baseball.baseball.Digits;
import baseball.baseball.Result;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;

public class GameConsole {

    private String readLine() {
        return Console.readLine();
    }

    private List<Integer> readIntegerList() throws IllegalArgumentException {
        try {
            return readLine().trim().chars()
                    .mapToObj(charPoint -> String.valueOf((char) charPoint))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }

    private Digits readDigits() throws IllegalArgumentException {
        return new Digits(readIntegerList());
    }

    private void writeLine(String s) {
        System.out.println(s);
    }

    private void write(String s) {
        System.out.print(s);
    }

    public void printInit() {
        writeLine("숫자 야구 게임을 시작합니다.");
    }

    public Digits inputDigits() {
        write("숫자를 입력해주세요 : ");
        return readDigits();
    }

    public void printGameResult(Result result) {
        writeLine(result.toString());
    }

    public void printComplete() {
        writeLine("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public boolean inputShallReplay() throws IllegalArgumentException {
        writeLine("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputVal = readLine();

        if (inputVal.equals("1"))
            return true;
        else if (inputVal.equals("2"))
            return false;
        else
            throw new IllegalArgumentException("1과 2중 하나만 입력하세요");
    }
}
