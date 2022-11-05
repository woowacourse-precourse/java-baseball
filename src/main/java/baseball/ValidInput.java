package baseball;

public class ValidInput {
    String userInput;

    public ValidInput(String userInput) {
        this.userInput = userInput;
    }

    public void inspectInputLength() throws IllegalArgumentException {
        // 문자열 길이 검사
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요!");
        }
    }

    public void inspectAlphabetOrSpecialCharacter() throws IllegalArgumentException {
        // 문자열에 숫자 외에 다른 것이 있는지 검증
        if (!(String.valueOf(userInput).matches("^[0-9]*$"))) {
            throw new IllegalArgumentException("숫자 외에 다른 문자가 검출되었습니다!");
        }
    }

    public void inspectDuplicatedNumber() throws IllegalArgumentException {
        // 사용자의 입력을 char형 배열에 한 글자씩 저장
        char[] userInputArray = userInput.toCharArray();

        // 입력에 중복된 숫자가 있는지 확인
        if (userInputArray[0] == userInputArray[1]) {
            throw new IllegalArgumentException("입력에 동일한 숫자가 존재합니다.");
        }
        if (userInputArray[1] == userInputArray[2]) {
            throw new IllegalArgumentException("입력에 동일한 숫자가 존재합니다.");
        }
        if (userInputArray[0] == userInputArray[2]) {
            throw new IllegalArgumentException("입력에 동일한 숫자가 존재합니다.");
        }
    }
}
