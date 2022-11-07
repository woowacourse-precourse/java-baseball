package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        printProgramStart();
        gameStart();

        while(restartOrNot() == 1)
            gameStart();
    }

    private static void printProgramStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static void printGameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static boolean isAnswerNumberValid(int answerNum) {
        int hundred = answerNum / 100;
        int ten = (answerNum % 100) / 10;
        int one = answerNum % 10;

        if (hundred == 0 || ten == 0 || one == 0)
            return false;

        if (hundred == ten || hundred == one || ten == one)
            return false;

        return true;
    }

    private static List<Integer> makeAnswerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    private static boolean isInteger(String inputValue) {

        try {
            Integer.parseInt(inputValue);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private static boolean isInputValid(String inputValue) {

        if (!isInteger(inputValue))
            throw new IllegalArgumentException("정수가 아닌 값을 입력했습니다.");

        int inputNumber = Integer.parseInt(inputValue);

        if (inputNumber < 123 || inputNumber > 987)
            throw new IllegalArgumentException("제한범위를 벗어나는 값을 입력했습니다.");

        if (!isAnswerNumberValid(inputNumber))
            // 랜덤 정답 숫자 유효성과 같은 제한조건을 검사
            throw new IllegalArgumentException("0 또는 중복되는 수가 입력되었습니다.");

        return true;
    }

    private static int tryAnswer() {
        int answerTrialNum;
        System.out.print("숫자를 입력해주세요 : ");
        String answerTrialInput = Console.readLine();

        if (!isInputValid(answerTrialInput))
            throw new IllegalArgumentException("정답 입력값 오류");

        answerTrialNum = Integer.parseInt(answerTrialInput);
        return answerTrialNum;
    }

    private static int countStrike(List<Integer> answerDigits, List<Integer> trialDigits) {
        int strikeCnt = 0;

        if (answerDigits.get(0) == trialDigits.get(0))
            strikeCnt++;

        if (answerDigits.get(1) == trialDigits.get(1))
            strikeCnt++;

        if (answerDigits.get(2) == trialDigits.get(2))
            strikeCnt++;

        return strikeCnt;
    }

    private static int countBall(List<Integer> answerDigits, List<Integer> trialDigits){
        int ballCnt = 0;

        if(trialDigits.get(0) == answerDigits.get(1) || trialDigits.get(0) == answerDigits.get(2))
            ballCnt++;

        if(trialDigits.get(1) == answerDigits.get(0) || trialDigits.get(1) == answerDigits.get(2))
            ballCnt++;

        if(trialDigits.get(2) == answerDigits.get(0) || trialDigits.get(2) == answerDigits.get(1))
            ballCnt++;

        return ballCnt;
    }

    private static boolean isTrialCorrect(int ballCnt, int strikeCnt){

        if(strikeCnt == 3) {
            System.out.println("3스트라이크");
            printGameEnd();
            return true;
        }

        else if(ballCnt > 0 && strikeCnt > 0)
            System.out.println(Integer.toString(ballCnt) + "볼 " + Integer.toString(strikeCnt) + "스트라이크");

        else if(ballCnt > 0 && strikeCnt == 0)
            System.out.println(Integer.toString(ballCnt) + "볼");

        else if(ballCnt == 0 && strikeCnt > 0)
            System.out.println(Integer.toString(strikeCnt) + "스트라이크");

        else if(ballCnt == 0 && strikeCnt == 0)
            System.out.println("낫싱");

        return false;
    }

    private static List<Integer> getThreeDigitsValues(int number){
        // 세 자리의 정수가 입력되면 각 자릿수를 List에 담아 반환
        List<Integer> digits = new ArrayList<>();
        digits.add(number / 100);
        digits.add((number%100) / 10);
        digits.add(number%10);
        return digits;
    }

    private static void gameStart(){
        int trialNum = tryAnswer();
        List<Integer> answerDigits = makeAnswerNumber();
        List<Integer> trialDigits = getThreeDigitsValues(trialNum);

        while(!isTrialCorrect(countBall(answerDigits, trialDigits), countStrike(answerDigits, trialDigits))) {
            trialNum = tryAnswer();
            trialDigits = getThreeDigitsValues(trialNum);
        }
    }

    private static int restartOrNot(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String Input = Console.readLine();
        int restartChoice = Integer.parseInt(Input);

        if(restartChoice != 1 && restartChoice != 2)
            throw new IllegalArgumentException("재시작 여부 입력값이 잘못되었습니다.");

        return restartChoice;
    }
}