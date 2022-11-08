package baseball.ui;
import baseball.model.Input;
import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class InputView {
    private Input input;

    public void getBaseballInput(){
        System.out.print("숫자를 입력해주세요 : ");
        try{
            String input = Console.readLine();
            checkInputValidation(input);
            this.input = new Input(input);
        }catch (NoSuchElementException e){
            throw new IllegalArgumentException("input을 입력해주세요");
        }
    }

    private void checkInputValidation(String input){
        checkInputSize(input);
        checkNumericValue(input);
        checkDuplicateValue(input);
    }

    private void checkInputSize(String input){
        if(input == null || input.length() != 3){
            throw new IllegalArgumentException("1~9 사이 자연수 3개를 입력해주세요.");
        }
    }

    private void checkNumericValue(String input){
        int notNumber = input.chars()
                .filter(ch -> !Character.isDigit(ch))
                .toArray()
                .length;
        if(notNumber != 0){
            throw new IllegalArgumentException("숫자가 아닌 값은 입력될 수 없습니다.");
        }
    }

    private void checkDuplicateValue(String input){
        Set<Character> inputSet = new HashSet<>();
        char[] inputChars = input.toCharArray();
        for(char inputChar : inputChars){
            inputSet.add(inputChar);
        }
        if(inputSet.size() != input.length()){
            throw new IllegalArgumentException("중복된 값은 입력될 수 없습니다.");
        }
    }

    public Input getInput() {
        return input;
    }
}
