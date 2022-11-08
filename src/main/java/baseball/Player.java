package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Player {
    private ArrayList<Integer> numbers;
    private final CheckException check;

    public Player() {
        this.check = new CheckException();
    }

    public String inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public String inputGameStatusData() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return String.valueOf(Console.readLine());
    }

    public void decideNumbers(String input) {
        check.validateConsistsOfNumber(input);
        check.validateNumberLength(input);
        addNumber(input);
        check.validateOverlap(this.numbers.size());
    }

    public void addNumber(String input) {
        this.numbers = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            int number = Integer.parseInt(String.valueOf(input.charAt(i)));
            if (!this.numbers.contains(number)) {
                this.numbers.add(number);
            }
        }
    }

    public ArrayList<Integer> getNumbers() {
        return this.numbers;
    }
}
