package baseball.controller;

import baseball.domain.Baseball;

import java.util.Arrays;
import java.util.List;

import static baseball.exception.BaseballException.vaildNum;
import static baseball.exception.BaseballException.vaildNumArr;
import static baseball.view.Printer.showRequestInput;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Number {

    /** 사용자로부터 숫자를 받는 함수 */
    public static int getInputNums() {
        showRequestInput();
        int nums = 0;
        try {
            nums = Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            // 0인채로 리턴
        }
        return nums;
    }

    /** 사용자 입력값을 정수 ArrayList 반환 */
    static List<Integer> getNumsArr(int num) {
        List<Integer> numsArr = Arrays.asList(0,0,0);
        vaildNum(num);

        for (int i=0; i<numsArr.size(); i++){
            numsArr.set(2 - i, num % 10);
            num = num/10;
        }

        vaildNumArr(numsArr);
        return numsArr;
    }

    static Baseball checkAnswer(List<Integer> answer, List<Integer> input) {
        Baseball result = new Baseball();
        // strike 판별
        for (int i=0; i<answer.size(); i++) {
            if(answer.get(i) == input.get(i)) {
                result.strike();
            } else if (answer.contains(input.get(i))) {
                result.ball();
            }
        }
        return result;
    }

    // 모두 맞춘 경우
    public static boolean clear(Baseball game) {
        if (game.getStrike()==3) {
            return true;
        }
        return false;
    }
}
