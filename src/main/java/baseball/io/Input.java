package baseball.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input extends EndOrRe {

    private final int listSize;
    private final InputValidity inputValidity;

    public Input(int listSize) {
        this.listSize = listSize;
        this.inputValidity = new InputValidity();
    }

    public List<Character> readAndMakeInputList() {
        String inputString = Console.readLine();
        inputValidity.validStringLength(inputString, listSize);
        return stringToList(inputString);
    }

    public Integer endOrReNum() {
        return super.makeOneOrTwoInputList();
    }

    /**
     * 테스트를 위한 메소드 문자열을 입력 받았다고 생각하고 클래스의 메소드들을 테스트한다.
     *
     * @param inputString Console.readLine()으로 입력받은 문자열이라고 가정한 파라미터
     * @return 입력받은 문자열을 리스트로 만들어 반환
     */
    public List<Character> testReadAndMakeInputList(String inputString) {
        inputValidity.validStringLength(inputString, listSize);
        return stringToList(inputString);
    }

    private List<Character> stringToList(String inputString) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < inputString.length(); i++) {
            list.add(inputString.charAt(i));
        }
        inputValidity.validForList(list);
        return list;
    }
}
