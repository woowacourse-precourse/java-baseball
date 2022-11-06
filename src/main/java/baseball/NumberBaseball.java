package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class NumberBaseball {

    private final static int MIN_NUM = 1;
    private final static int MAX_NUM = 9;
    private final static int ARRAY_SIZE = 3;

    ArrayList<Integer> targetNumbers = new ArrayList<>();

    String inputNumber;

    int ballCount = 0;
    int strikeCount = 0;

    public void createTargetNumberList() {
        while (targetNumbers.size() < ARRAY_SIZE) {
            overlapNumberInNumberList(Randoms.pickNumberInRange(MIN_NUM,MAX_NUM));
        }
    }

    public void getPlayerNumber(){
        System.out.print("숫자를 입력해주세요 : ");

        inputNumber = Console.readLine();
    }

    private void overlapNumberInNumberList(int number) {
        if(targetNumbers.contains(number)) {
            return;
        }

        targetNumbers.add(number);
    }

    public void compareNumbers() {
        strikeCount = 0;
        ballCount = 0;

        for(int i = 0 ; i < 3 ; i++) {
            for(int j = 0 ; j < 3 ; j++) {
                if( Character.getNumericValue(inputNumber.charAt(i)) == targetNumbers.get(j)) {
                    if(i == j) {
                        strikeCount++;
                        break;
                    }
                    ballCount++;
                    break;
                }

            }
        }

        if(strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
            return;
        }

        System.out.println("스트라이크: " + strikeCount);
        System.out.println("볼: " + ballCount);
    }

}
