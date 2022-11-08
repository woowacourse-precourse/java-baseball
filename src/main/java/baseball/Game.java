package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {

    boolean finished;
    static Scanner sc = new Scanner(System.in);

    public Game() {
        title();
        finished = false;
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

        if (strikes == 3) {
            setFinished();
        }
    }

    public boolean replay() throws IllegalArgumentException {
        String input = getUserInput();

        // Exception: 한자리 숫자가 아니거나, 1 or 2를 입력하지 않았을 경우
        if (input.length() != 1 || "12".contains(input)) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요");
        }

        if (input.charAt(0) == '2') {
            setFinished();
        }

        return finished;
    }

    private void setFinished(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        this.finished = true;
    }

    public boolean isFinished() {
        return finished;
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
        String input = sc.next();

        for(char c : input.toCharArray()) {
            if (c < 48 || 57 < c)
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
