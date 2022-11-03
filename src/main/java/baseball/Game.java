package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    static Scanner sc = new Scanner(System.in);

    public Game() {
        title();
    }
    private void title() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public void play() {
        System.out.println("숫자를 입력해주세요 : ");

        // TODO computerNumber, userNumber 받기

        // TODO compare computerNumber,userNumber

        // TODO print result (X strike, X ball)

        // TODO Restart or Not
    }
    public boolean end() {
        // TODO get User's Input
        // TODO check Execption

        return true;
    }
    private List<Integer> getComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    private List<Integer> getUserNumber() {
        String input = sc.nextLine();

        // Exception 1. not Number
        for(char c : input.toCharArray()) {
            if (48 <= c && c <= 57) return null;
        }
        // Exception 2. not 3 Number
        if (input.length() != 3) return null;

        List<Integer> userNumbers = new ArrayList<>();
        for(char c : input.toCharArray()) {
            userNumbers.add((int) c);
        }

        return userNumbers;
    }

    // TODO Method: boolean restart
}
