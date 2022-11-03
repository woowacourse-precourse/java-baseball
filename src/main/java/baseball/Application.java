package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Application {
    private static final int _ball = 0;
    private static final int _strike = 1;

    public static void main(String[] args) {
        List<Integer> comp, userInput, result;
        boolean isInGame;

        System.out.print("숫자 야구 게임을 시작합니다.\n");

        while (true) {
            isInGame = true;
            comp = generateRandomValue();
            while (isInGame) {
                System.out.print("숫자를 입력해주세요 : ");
                userInput = splitDigits(isLegalInput(readInt()));
                result = getResult(userInput, comp);
                printHint(result);
                isInGame = !isGameEnd(result);
            }
            System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
            if (readInt() == 2) {
                break;
            }
        }
    }

    private static boolean isGameEnd(List<Integer> result) {
        if (result.get(_strike) == 3) {
            return true;
        }
        return false;
    }

    private static void printHint(List<Integer> result) {
        int ballCount = result.get(_ball);
        int strikeCount = result.get(_strike);

        if (ballCount > 0 && strikeCount > 0) {
            System.out.print(ballCount + "볼 " + strikeCount + "스트라이크\n");
        } else if (ballCount > 0) {
            System.out.print(ballCount + "볼\n");
        } else if (strikeCount > 0) {
            System.out.print(strikeCount + "스트라이크\n");
        } else {
            System.out.print("낫싱\n");
        }
    }

    private static List<Integer> getResult(List<Integer> input, List<Integer> comp) {
        List<Integer> result = new ArrayList<>();
        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < 3; ++i) {
            if (comp.contains(input.get(i))) {
                ballCount += 1;
            }
        }
        for (int i = 0; i < 3; ++i) {
            if (comp.get(i) == input.get(i)) {
                strikeCount += 1;
                ballCount -= 1;
            }
        }
        result.add(ballCount);
        result.add(strikeCount);

        return result;
    }

    private static List<Integer> splitDigits(int input) {
        List<Integer> digits = new ArrayList<>();
        int front = input / 100;
        int middle = (input % 100) / 10;
        int rear = input % 10;

        if (input == -1) {
            throw new IllegalArgumentException();
        }

        digits.add(front);
        digits.add(middle);
        digits.add(rear);

        return digits;
    }

    private static int isLegalInput(int input) {
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
        } else if (input == 1) {
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

    private static List<Integer> generateRandomValue() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
