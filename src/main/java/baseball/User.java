package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    public static int INPUT_LENGTH = 3;
    private final List<Integer> values;

    public User(List<Integer> values){
        checkInputLength(values);
        checkNumberRange(values);
        checkNumberDifference(values);
        this.values = values;
    }

    public User(){
        values = getInputNumber();
        checkInputLength(values);
        checkNumberRange(values);
        checkNumberDifference(values);
    }
    static List<Integer> getInputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        List<Integer> inputNum = new ArrayList<>();
        for (int idx = 0; idx < input.length(); idx++) {
            inputNum.add(input.charAt(idx) - '0');
        }

        return inputNum;
    }

    static void checkInputLength(List<Integer> inputNum){
        if (inputNum.size() > INPUT_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    static void checkNumberRange(List<Integer> inputNum){
        for (int idx = 0; idx < INPUT_LENGTH; idx++) {
            if (inputNum.get(idx) < 1 || inputNum.get(idx) > 9) {
                throw new IllegalArgumentException("1~9 사이의 숫자를 입력해주세요");
            }
        }
    }

    static void checkNumberDifference(List<Integer> inputNum){
        int num1 = inputNum.get(0);
        int num2 = inputNum.get(1);
        int num3 = inputNum.get(2);
        if (num1 == num2 || num2 == num3 || num1 == num3) {
            throw new IllegalArgumentException();
        }
    }

    static int getExitOrRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputStatus = Console.readLine();
        checkStatusInput(inputStatus);
        int inputStatusNumber = Integer.parseInt(inputStatus);
        return inputStatusNumber;
    }

    static void checkStatusInput(String inputStatus){
        if (!inputStatus.equals("1") && !inputStatus.equals("2")) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getValues() {
        return values;
    }
}
