package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Game {
    private static final int _strike = 0;
    private static final int _ball = 1;


    public int scanUserValue() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = scanInput();
        int num = -1;

        try {
            num = Integer.parseInt(input);
        }
        catch (NumberFormatException ex) {
            return -1;
        }

        int front = num / 100;
        int middle = (num % 100) / 10;
        int rear = num % 10;

        if (num < 123 || num > 987
                || front == middle
                || front == rear
                || middle == rear) {
            return -1;
        }
        return num;
    }

    public List<Integer> calcRoundResult(int userValue, int opponentValue) {
        List<Integer> ret = new ArrayList<>();

        return ret;
    }

    public int printHint(List<Integer> roundResult) {
        int ballCount = roundResult.get(_ball);
        int strikeCount = roundResult.get(_strike);

        if (ballCount != 0 && strikeCount != 0) {
            System.out.print(ballCount + "볼 " + strikeCount + "스트라이크");
        }
        else if (ballCount != 0) {
            System.out.print(ballCount + "볼");
        }
        else if (strikeCount != 0) {
            System.out.print(strikeCount + "스트라이크");
        } else {
            System.out.print("낫싱");
        }

        if (strikeCount == 3) {
            System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
        }
        return strikeCount;
    }

    public boolean scanIsEnd() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
        String input = Console.readLine();

        if (input.equals("1")) {
            return false;
        }
        else if (input.equals("2")) {
            return true;
        }
        throw new IllegalArgumentException();
    }

    private String scanInput() {
        try {
            return (Console.readLine());
        } catch (NoSuchElementException ex) {
            return "";
        }
    }
}
