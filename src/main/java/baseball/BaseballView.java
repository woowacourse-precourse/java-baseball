package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class BaseballView {

    ArrayList<Integer> inputNumbers = new ArrayList<>();

    //// TODO: 2022-11-07 입력값 예외처리
    public void inputPlayerNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        String str = Console.readLine();
        removeInputNumbers();
        convertInput(str);
    }

    private void removeInputNumbers() {
        inputNumbers.clear();
    }

    public ArrayList<Integer> getInputNumbers() {
        return inputNumbers;
    }

    private void convertInput(String str) {
        for(int i = 0 ; i < str.length(); ++i) {
            inputNumbers.add(Character.getNumericValue(str.charAt(i)));
        }

    }

    //// TODO: 2022-11-07 입력값에 대한 예외처리
    public int continueGame() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
        String str = Console.readLine();
        return Character.getNumericValue(str.charAt(0));
    }

    public void printBallcount(int strike, int ball){
        if(strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }
        System.out.println("스트라이크: " + strike);
        System.out.println("볼: " + ball);
    }

}


