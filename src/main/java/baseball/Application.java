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

    public static String returnResult(List<Integer> trial, List<Integer> answer) {
        int ballcount = checkBall(trial, answer);
        int strikecount = checkStrike(trial, answer);

        String result = "";
        if(ballcount >0 && strikecount >0) {
            result += ballcount + "볼 " + strikecount + "스트라이크";
        }
        else if (ballcount > 0) {
            result += ballcount +"볼";
        }
        else if(strikecount > 0) result += strikecount+"스트라이크";
        else result += "낫싱";

        return result;
    }
    public static boolean checkVal(String num) {
        return num.length() != 3;
    }

    public static List<Integer> inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputNum = Console.readLine();
        if (checkVal(inputNum)) throw new IllegalArgumentException("Invalid input");
        List<Integer> arrayTrial = splitAnswerNumber(inputNum);
        return arrayTrial;
    }

    public static void gamestart(){
        List<Integer> answer = createAnswerNumber();
        System.out.println("숫자 야구 게임을 시작합니다.");

        String result = "";
        while(!result.equals("3스트라이크")) {
            List<Integer> arrayTrial = inputNumber();
            result = returnResult(arrayTrial, answer);
            System.out.println(result);
        }
        stop();
    }
    public static void main(String[] args) {
        gamestart();

    }

    public static void stop() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputNum = Console.readLine();

        if(inputNum.equals("1")) gamestart();
        else if(inputNum.equals("2")) System.out.println("게임 종료");
        else System.out.println("잘못된 입력값입니다.");

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
