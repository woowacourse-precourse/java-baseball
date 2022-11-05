package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static List<Integer> pickComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static void checkPlayerInput(String line) {
        if (line == null || line.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c < '1' || c > '9') {
                throw new IllegalArgumentException();
            }
        }

        if (line.charAt(0) == line.charAt(1) || line.charAt(0) == line.charAt(2) || line.charAt(1) == line.charAt(2)) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> inputPlayerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String line = Console.readLine();
        checkPlayerInput(line);

        List<Integer> player = new ArrayList<>();
        for (String s : line.split("")) {
            player.add(Integer.parseInt(s));
        }
        return player;
    }
}
