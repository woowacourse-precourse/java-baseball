package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Integer> numbers;

    public void inputNumber() {
        String inputValue;
        System.out.print("숫자를 입력해주세요 : ");
        inputValue = Console.readLine();

        if(validateInput(inputValue)) {
            this.numbers = parseIntList(inputValue);
        }
    }

    public List<Integer> parseIntList(String inputValue) {
        List<Integer> result = new ArrayList<>();

        for(char c : inputValue.toCharArray()){
            result.add(Character.digit(c, 10));
        }

        return result;
    }

    public boolean inputFlag() throws IllegalArgumentException {
        char inputValue;
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        inputValue = Console.readLine().charAt(0);

        if(validateFlag(inputValue))
            return true;

        return false;
    }

    private boolean validateFlag(char inputValue) throws IllegalArgumentException {
        boolean flag = false;

        if(inputValue == '1')
            flag = true;

        else if(inputValue == '2')
            flag = false;

        else throw new IllegalArgumentException("1 혹은 2 이외의 숫자를 입력 하셨습니다.");

        return flag;
    }
    private boolean validateInput(String inputValue) throws IllegalArgumentException {
        // 사용자가 세 자리 숫자를 입력하였는 지를 확인
        if(inputValue.length() != 3)
            throw new IllegalArgumentException("입력하신 숫자가 세 자리가 아닙니다.");

        // 서로 다른 숫자를 입력하였는 지를 확인
        if(containsValue(inputValue))
            throw new IllegalArgumentException("입력하신 내용 중에 중복되는 숫자가 있습니다.");

        // 1부터 9사이의 숫자인 지를 확인
        for(char c : inputValue.toCharArray()) {
            if(!Character.isDigit(c) && !(c == '0')) {
                throw new IllegalArgumentException("입력하신 내용 중에 숫자가 아니거나, 0인 값이 있습니다.");
            }
        }

        return true;
    }

    private boolean containsValue(String inputValue) {
        char[] temp = new char[inputValue.length() + 1];

        for(int i = 0; i < inputValue.length(); i++)
            temp[i] = inputValue.charAt(i);

        temp[inputValue.length()] = '0';

        for(int i = 0; i < inputValue.length(); i++){
            if(temp[i] == temp[i + 1])
                return true;
        }

        return false;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
