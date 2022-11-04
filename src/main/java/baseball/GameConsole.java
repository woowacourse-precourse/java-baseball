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

    private int readInt() {
        return Integer.parseInt(readLine());
    }

    private List<Integer> readIntegerList() throws NumberFormatException {
        return readLine().trim().chars()
                .mapToObj(charPoint -> String.valueOf((char) charPoint))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public Digits readDigits() throws IllegalArgumentException {
        try {
            return new Digits(readIntegerList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    private void writeLine(String s) {
        System.out.println(s);
    }

    private void write(String s){
        System.out.print(s);
    }

    public void printInit() {
        writeLine("숫자 야구 게임을 시작합니다.");
    }

    public Digits inputDigits() {
        write("숫자를 입력해주세요 : ");
        return readDigits();
    }

    /**
     * @param result
     * @return 게임 종료 여부
     */
    public boolean printGameResult(Result result) {
        if (result.isComplete()) {
            printComplete();
            return true;
        }

        write(result.toString());
        return false;
    }

    private void printComplete() {
        writeLine("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public boolean inputShallReplay() {
        writeLine("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return readInt() == 1;
    }
}
