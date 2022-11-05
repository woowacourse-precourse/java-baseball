package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        do {
            playGame();
        } while (restartGame());
    }
    public static void playGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computerAnswer = generateNumber();
        boolean isCorrectAnswer = false;
        while (!isCorrectAnswer) {
            isCorrectAnswer = checkAnswer(computerAnswer, getPlayerAnswer());
        }
    }
    public static List<Integer> generateNumber() {
        List<Integer> computerAnswer = new ArrayList<>();
        while (computerAnswer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerAnswer.contains(randomNumber)) {
                computerAnswer.add(randomNumber);
            }
        }
        return computerAnswer;
    }
    public static List<Integer> getPlayerAnswer() {
        System.out.print("숫자를 입력해주세요 : ");
        String playerAnswerStr = Console.readLine();
        List<Integer> playerAnswer = stringToIntegerList(playerAnswerStr);

        validateNumber(playerAnswer);

        return playerAnswer;
    }
    public static List<Integer> stringToIntegerList(String inputStr) {
        String[] inputStrArr = inputStr.split("");
        List<Integer> inputIntList = new ArrayList<>();
        for (int i = 0; i < inputStrArr.length; i++) {
            int tmp = Integer.parseInt(inputStrArr[i]);
            inputIntList.add(tmp);
        }
        return inputIntList;
    }
    public static boolean validateNumber(List<Integer> playerAnswer) {
        //length check
        if (playerAnswer.size() != 3) {
            throw new IllegalArgumentException("length error");

        }

        //same check
        if (playerAnswer.size() != playerAnswer.stream().distinct().count()) {
            throw new IllegalArgumentException("duplicate error");
        }

        //number only check
        String regExp = "^[1-9]+$";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            String st = Integer.toString(playerAnswer.get(i));
            sb.append(st);
        }
        String s = sb.toString();
        if (!s.matches(regExp)) {
            throw new IllegalArgumentException("not number error");
        }

        return true;
    }
    public static boolean checkAnswer(List<Integer> computerAnswer, List<Integer> playerAnswer) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (computerAnswer.get(i).equals(playerAnswer.get(i))) {
                strike++;
            } else if (computerAnswer.contains(playerAnswer.get(i))) {
                ball++;
            }
        }
        printResult(strike, ball);
        if(strike == 3){
            return true;
        }else{
            return false;
        }
    }
    private static void printResult(int strike, int ball) {
        if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }


    public static boolean restartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String s = Console.readLine();
        if (s.equals("1")) {
            return true;
        } else if (s.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException("not 1,2: input erroooor");
        }
    }
}
