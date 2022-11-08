package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Application {
    public static ArrayList<Integer> generateAnswer() {
        ArrayList<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber))
                answer.add(randomNumber);
        }
        return answer;
    }

    public static boolean isCorrectLength(String consoleInput) { return (consoleInput.length() == 3); }

    public static boolean isIntWithNonzeroDigits(String consoleInput) {
        char charInString;
        for (int index = 0; index < consoleInput.length(); index++) {
            charInString = consoleInput.charAt(index);
            if (charInString < '1' || charInString > '9')
                return false;
        }
        return true;
    }

    public static boolean isDigitDuplicated(String consoleInput) {
        boolean[] isUsed = new boolean[10];
        for (int digit = 1; digit < 10; digit++)
            isUsed[digit] = false;

        char charInString;
        int digit;
        for (int index = 0; index < consoleInput.length(); index++) {
            charInString = consoleInput.charAt(index);
            digit = (int)(charInString - '0');
            if (isUsed[digit]) return true;
            isUsed[digit] = true;
        }
        return false;
    }

    public static void validateInput(String consoleInput) {
        if (!isCorrectLength(consoleInput) || !isIntWithNonzeroDigits(consoleInput)) {
            throw new IllegalArgumentException("Input should be 3-digit integer with non-zero digits");
        } else if (isDigitDuplicated(consoleInput)) {
            throw new IllegalArgumentException("Input should consist of non-duplicated digits");
        }
    }

    public static ArrayList<Integer> separateDigit(int inputNumber) {
        ArrayList<Integer> digitArray = new ArrayList<>();
        int temp = inputNumber, remainder;
        while (temp != 0) {
            remainder = temp % 10;
            digitArray.add(0, remainder);
            temp /= 10;
        }
        return digitArray;
    }

    public static ArrayList<Integer> countBallAndStrike(ArrayList<Integer> answer, ArrayList<Integer> prediction) {
        ArrayList<Integer> noOfBallAndStrike = new ArrayList<Integer>();
        int noOfBall = 0, noOfStrike = 0;

        for (int digitOfAnswer : answer)
            if (prediction.contains(digitOfAnswer))
                noOfBall++;

        int digitOfAnswerAtIndex, digitOfPredictionAtIndex;
        for (int index = 0; index < 3; index++) {
            digitOfAnswerAtIndex = answer.get(index);
            digitOfPredictionAtIndex = prediction.get(index);
            if (digitOfAnswerAtIndex == digitOfPredictionAtIndex) {
                noOfStrike++;
                noOfBall--;
            }
        }
        noOfBallAndStrike.add(noOfBall);
        noOfBallAndStrike.add(noOfStrike);

        return noOfBallAndStrike;
    }

    public static String giveHint(ArrayList<Integer> answer, ArrayList<Integer> prediction) {
        ArrayList<Integer> noOfBallAndStrike = countBallAndStrike(answer, prediction);
        int noOfBall = noOfBallAndStrike.get(0);
        int noOfStrike = noOfBallAndStrike.get(1);

        StringBuilder hint = new StringBuilder();
        if (noOfBall != 0) hint.append(noOfBall).append("볼 ");
        if (noOfStrike != 0) hint.append(noOfStrike).append("스트라이크");
        if (noOfBall == 0 && noOfStrike == 0) hint.append("낫싱");
        return hint.toString();
    }

    public static String getConsoleInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public static void playOneGame() {
        ArrayList<Integer> answer = generateAnswer();
        ArrayList<Integer> prediction = new ArrayList<>();
        String consoleInput;
        while (!answer.equals(prediction)) {
            consoleInput = getConsoleInput();
            validateInput(consoleInput);

            int inputInInteger = Integer.parseInt(consoleInput);
            prediction = separateDigit(inputInInteger);
            String hint = giveHint(answer, prediction);
            System.out.println(hint);
        }
    }

    public static void announceStart() { System.out.println("숫자 야구 게임을 시작합니다."); }

    public static void announceEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    static class ExecutionCode {
        String code;
        ExecutionCode() { this.code = "1"; }
        void get() { this.code = Console.readLine(); }

        void validate() {
            if (!this.code.equals("1") && !this.code.equals("2"))
                throw new IllegalArgumentException("Execution code must be 1 or 2");
        }
    }

    public static void main(String[] args) {
        ExecutionCode executionCode = new ExecutionCode();
        while (executionCode.code.equals("1")) {
            announceStart();
            playOneGame();
            announceEnd();
            executionCode.get();
            executionCode.validate();
        }
    }
}