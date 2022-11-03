package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Application {
    public static void main(String[] args) {
        System.out.print("숫자 야구 게임을 시작합니다.\n");
    }

    public int isLegalInput(int input) {
        int front = input / 100;
        int middle = (input % 100) / 10;
        int rear = input % 10;

        if (input < 123 || input > 987
                || front == middle
                || front == rear
                || middle == rear) {
            return -1;
        }
        return input;
    }
    private static boolean isQuit(int input) {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
        if (input == 2) {
            return true;
        }
        else if (input == 1) {
            return false;
        }
        throw new IllegalArgumentException();
    }

    private static int readInt() {
        try {
            return (Integer.parseInt(Console.readLine()));
        } catch (NoSuchElementException ex) {
            return -1;
        }
    }

    private static int generateRandomValue() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return ((computer.get(0) * 100) + (computer.get(1) * 10) + computer.get(2));
    }
}
