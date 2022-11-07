package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;

public class Game {
    private final int INPUT_LENGTH = 3;
    private Computer computer;
    public Game(){
    }

    public void init(Computer computer){
        System.out.println("숫자 야구 게임을 시작합니다.");

        this.computer = computer;

        String inputNumber = input();
        inputCheck(inputNumber);

        computer.checkResult(inputNumber);

    }

    private String input(){
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        return input;
    }
    private void inputCheck(String input){
        if(isInputCorrectSize(input) && isInputNumeric(input) && isInputDuplicate(input)){
            return;
        }
        throw new IllegalArgumentException();
    }

    private boolean isInputCorrectSize(String input){
        if (input.length() != INPUT_LENGTH) {
            return false;
        }
        return true;
    }

    private boolean isInputNumeric(String input){
        return (input.matches("[0-9]+"));
    }

    private boolean isInputDuplicate(String input){
        Set<Character> duplicateCheck = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            if (!duplicateCheck.add(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
