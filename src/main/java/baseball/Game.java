package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;

public class Game {
    private final int INPUT_LENGTH = 3;
    private Computer computer;
    public Game(){
    }

    public void init(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        run(new Computer());
    }

    private void run(Computer computer) {
        this.computer = computer;

        String inputNumber = input();

        while (!computer.checkResult(inputNumber)) {
            inputNumber = input();
        }

        int statusNumber = askRetry();
        if (statusNumber == 1) {
            this.run(new Computer());
        }
    }



    private String input(){
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        inputCheck(input);
        return input;
    }
    private void inputCheck(String input){
        isInputCorrectSize(input);
        isInputNumeric(input);
        isInputDuplicate(input);
    }

    private void isInputCorrectSize(String input){
        if (input.length() != INPUT_LENGTH) {
            throw new IllegalArgumentException("3 자리의 수를 입력해야 합니다.");
        }

    }

    private void isInputNumeric(String input){
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException("숫자만 입력해야 합니다.");
        }
    }

    private void isInputDuplicate(String input){
        Set<Character> duplicateCheck = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            if (!duplicateCheck.add(input.charAt(i))) {
                throw new IllegalArgumentException("중복되지 않는 숫자만 합니다.");
            }
        }
    }

    private int askRetry(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String status = Console.readLine();
        if (!status.equals("1") && !status.equals("2")) {
            throw new IllegalArgumentException("1 혹은 2를 입력해야 합니다.");
        }
        int statusNumber = Integer.parseInt(status);
        return statusNumber;
    }

}
