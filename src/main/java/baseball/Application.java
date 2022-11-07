package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static List<Integer> createAnswerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    public static void main(String[] args) {
        List<Integer> answer = createAnswerNumber();
        System.out.println("start baseball");

        String inputNum = Console.readLine();
        List<Integer> arrayTrial = splitAnswerNumber(inputNum);

        while(checkStrike(arrayTrial, answer) != 3) {
            inputNum = Console.readLine();
            arrayTrial = splitAnswerNumber(inputNum);
            int ballcount = checkBall(arrayTrial, answer);
            int strikecount = checkStrike(arrayTrial, answer);
            System.out.println(ballcount);
            System.out.println(strikecount);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    public static List<Integer> splitAnswerNumber(String number) {
        Integer intNum = Integer.valueOf(number);
        List<Integer> splited_trial_number = new ArrayList<>();

        while (intNum > 0) {
            splited_trial_number.add(intNum%10);
            intNum /= 10;
        }

        Collections.reverse(splited_trial_number);
//        10으로 나눈 나머지가 순차적으로 추가되므로 . 원하는 리스트 값은 큰 자리수부터 추가된 리스트이므로 reverse 처리한다.
        return splited_trial_number;
    }

    public static Integer checkStrike(List<Integer> trial, List<Integer> answer) {
        Integer strikeCount = 0;
        for(int i=0; i<3; i++){
            if (trial.get(i) == answer.get(i)) strikeCount++;
        }
        return strikeCount;
    }

    public static Integer checkBall(List<Integer> trial, List<Integer> answer) {
        Integer ballCount = 0;
        for(int i: trial){
            if (answer.contains(i)){
                ballCount++;
            }
        }
        return ballCount - checkStrike(trial, answer);
    }

}
