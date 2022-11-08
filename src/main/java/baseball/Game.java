package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    
    public Game() {
        title();
    }
    private void title() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public void play() {
        System.out.println("숫자를 입력해주세요 : ");
        String userInput = getUserInput();

        List<Integer> computer = getComputerNumber();
        List<Integer> user = getUserNumber(userInput);

        // count stikes & balls
        int strikes = countStrikes(user,computer);
        int balls = countBalls(user,computer);

        // print: X strikes, X balls  OR  낫싱
        if (balls > 0) {
            System.out.print(balls+"볼 ");
        }
        if (strikes > 0) {
            System.out.print(strikes+"스트라이크");
        }
        if (balls + strikes == 0) {
            System.out.print("낫싱");
        }
        System.out.println(); // 한줄 내리기


    }
    public boolean end() {
        String input = getUserInput();
        if (input.length() != 1) {
            System.out.println("INPUT ERROR!");
            return true;
        }

        if (input.charAt(0) == '1') {
            return false;
        } else if (input.charAt(0) == '2') {
            return true;
        }

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
    private String getUserInput() throws IllegalArgumentException {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        for(char c : input.toCharArray()) {
            if (48 < c && c < 57)
                throw new IllegalArgumentException("숫자를 입력하세요.");
        }

        return input;
    }
    private List<Integer> getUserNumber(String user) throws IllegalArgumentException {
        // Exception: not 3 Number
        if (user.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자 입력");
        }

        List<Integer> userNumbers = new ArrayList<>();
        for(char c : user.toCharArray()) {
            userNumbers.add((int) c);
        }

        return userNumbers;
    }

    private int countStrikes(List<Integer> user, List<Integer> computer) {
        int count = 0;
        for(int i=0; i<3; i++) {
            if (user.get(i).equals( computer.get(i) )) count++;
        }

        return count;
    }

    private int countBalls(List<Integer> user, List<Integer> computer) {
        int count = 0;
        for(int number : user) {
            if (computer.contains(number)) count++;
        }

        return count;
    }
}
