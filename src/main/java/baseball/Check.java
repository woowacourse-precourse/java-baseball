package baseball;

import java.util.ArrayList;

public class Check {
    public void checkNumberInput(ArrayList<String> inputs, String input, int SIZE) throws IllegalArgumentException {
        if (input.length() != SIZE)
            throw new IllegalArgumentException("3자리 수를 입력해주세요");   // 예외, 3자리 수가 아닌 경우
        else {
            inputs.clear();
            for (int i = 0; i < SIZE; i++)
                inputs.add(Character.toString(input.charAt(i)));

            if (checkSameNum(inputs))
                throw new IllegalArgumentException("서로 다른 3자리 수를 입력해주세요");  //예외, 같은 수가 입력된 경우
        }
    }

    public boolean checkSameNum(ArrayList<String> inputs) {
        boolean flag = false;
        for (String s : inputs)
            flag = compare(inputs, s, inputs.indexOf(s));
        return flag;
    }

    public boolean compare(ArrayList<String> inputs, String s, int startIndex) {
        boolean flag = false;
        for (int i = startIndex + 1; i < inputs.size(); i++) {
            if (s.equals(inputs.get(i))) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public boolean checkAnswer(String continued) {
        if (continued.equals("1"))
            return false;
        else if (continued.equals("2"))
            return true;
        else
            throw new IllegalArgumentException("게임을 새로 시작하려면 1," +
                    " 종료하려면 2를 입력하세요");   //예외, 1 or 2 이외의수 입력
    }
}