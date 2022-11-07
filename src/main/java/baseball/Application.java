package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
    private static void gameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static List<Integer> makeRandomAnswer(){
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {

            int randomNumber = Randoms.pickNumberInRange(1,9);

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }

        }

        return computer;
    }

    public static void exceptionCheck(String input){
        int asciiNumberZero = 48;
        int asciiNumberNine = 57;

        // 숫자의 개수가 3개가 아닌경우
        if(input.length() != 3){
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        // 0을 입력한 경우
        if(input.contains("0")) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        // 숫자가 아닌것을 입력한 경우
        for(int i = 0; i < 3; i++){

            if((int)input.charAt(i) < asciiNumberZero || asciiNumberNine < (int)input.charAt(i)){
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }

        }
        // 중복된 숫자를 입력한 경우
        int i = 0;

        for(i = 0; i < 2; i++){

            if(input.charAt(i) == input.charAt(i+1)){
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }

        }

    }

    private static List<Integer> userInput(){
        List<Integer> input = new ArrayList<>();

        System.out.print("숫자를 입력해주세요 : ");
        String inputString = Console.readLine();

        exceptionCheck(inputString);

        int index = 0;

        while (input.size() < 3){
            int inputNumber = Integer.parseInt(inputString.substring(index, index+1));
            input.add(inputNumber);
            index++;
        }

        return input;
    }
}
