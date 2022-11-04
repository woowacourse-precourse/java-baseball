package baseball;

import java.util.Scanner;

public class User {
    int number;

    public void inputNumber() {
        Scanner stdInput = new Scanner(System.in);
        String inputValue;
        System.out.print("숫자를 입력해주세요 : ");

        inputValue = stdInput.nextLine();

        try {
            validateInput(inputValue);

        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        this.number = 0;
    }

    private boolean validateInput(String inputValue) throws IllegalAccessException {
        // 사용자가 세 자리 숫자를 입력하였는 지를 확인
        if(inputValue.length() != 3)
            throw new IllegalAccessException("[Exception] 입력하신 숫자가 세 자리가 아닙니다.");

        // To do : 서로 다른 숫자를 입력하였는 지를 확인

        // 1부터 9사이의 숫자인 지를 확인
        for(char c : inputValue.toCharArray()) {
            if(!Character.isDigit(c) && !(c == '0')) {
                throw new IllegalAccessException("[Exception] 입력에 0이 포함되어 있거나, 숫자가 아닌 값이 있습니다.");
            }
        }

        return true;
    }


}
