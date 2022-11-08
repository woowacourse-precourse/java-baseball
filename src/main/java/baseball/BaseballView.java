package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BaseballView {

    ArrayList<Integer> inputNumbers = new ArrayList<>();

    public void inputPlayerNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        String str = Console.readLine();
        removeInputNumbers();

        inputVaildCheck(str);

        convertInput(str);
    }

    private void inputVaildCheck(String str) {
        inputLengthCheck(str);
        inputNumberCheck(str);
        inputOverlapCheck(str);
    }

    private void inputOverlapCheck(String str) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0 ; i < str.length(); ++i) {
            int number = Integer.parseInt(str.substring(i, i + 1));

            if(set.contains(number)) {
                throw new IllegalArgumentException("중복된 값을 입력했습니다.");
            }

            set.add(number);
        }
    }

    private void inputNumberCheck(String str) {
        if(str.matches("^[1-9]*$")) {
            return;
        }
        throw new IllegalArgumentException("1~9사이의 숫자를 입력해야 됩니다.");
    }

    private void inputLengthCheck(String str) {
        if(str.length() != 3){
            throw new IllegalArgumentException("입력한 문자의 길이가 3이 아닙니다.");
        }
    }

    private void removeInputNumbers() {
        inputNumbers.clear();
    }

    public ArrayList<Integer> getInputNumbers() {
        return inputNumbers;
    }

    private void convertInput(String str) {
        for(int i = 0 ; i < str.length(); ++i) {
            inputNumbers.add(Integer.parseInt(str.substring(i, i + 1)));
        }

    }

    public int continueGame() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
        String str = Console.readLine();

        continueValidCheck(str);

        return Character.getNumericValue(str.charAt(0));
    }

    private void continueValidCheck(String str) {
        if(str.matches("^[1-2]")) {
            return;
        }
        throw new IllegalArgumentException("1~2사이의 값을 입력해야 됩니다.");
    }

    public void printBallcount(int strike, int ball){
        if(strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }

        if(ball > 0) {
            System.out.print(ball + "볼 ");
        }

        if(strike > 0) {
            System.out.print(strike + "스트라이크");
        }

        System.out.println();
    }
}


