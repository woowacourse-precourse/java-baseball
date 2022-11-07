package baseball.domain;

import baseball.util.Input;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class User {

    private final int INPUT_SIZE = 3;

    // userNumber를 생성하여 다른 클래스 파일에서 사용하기 위한 대체 기능
    public List<Integer> getUserNumberList() {
        return createUserNumberList(Input.input());
    }

    // userNumber가 여러가지 조건에 부합하는지 확인하는 기능
    private List<Integer> createUserNumberList(String input) {
        char[] inputArray = validCharacter(input.toCharArray());
        List<Integer> inputList = charToIntegerList(inputArray);
        validSize(inputList);
        validDuplicate(inputList);
        validNumber(inputList);
        return inputList;
    }

    // 사용자가 입력한 값이 숫자인지 아닌지 예외처리
    private char[] validCharacter(char[] inputArray) {
        for (char c : inputArray) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException();
            }
        }
        return inputArray;
    }

    // char배열에서 List<Integer>로 바꿔주어 반환
    private List<Integer> charToIntegerList(char[] inputArray) {
        List<Integer> inputList = new ArrayList<>();
        for (char c : inputArray) {
            inputList.add(Integer.parseInt(String.valueOf(c)));
        }
        return inputList;
    }

    // 입력한 글자가 3글자가 맞는지 검사하는 기능
    private void validSize(List<Integer> inputList) {
        if (inputList.size() != INPUT_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    // 입력한 글자가 중복된 글자를 포함하고 있는지 검사하는 기능
    private void validDuplicate(List<Integer> inputList) {
        HashSet<Integer> checkDuplicate = new HashSet<>(inputList);
        if (checkDuplicate.size() != INPUT_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    //입력된 숫자에 0이 포함되어 있는지 검사하는 기능
    private void validNumber(List<Integer> inputList) {
        if (inputList.contains(0)) {
            throw new IllegalArgumentException();
        }
    }
}
