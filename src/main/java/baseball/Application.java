package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
//        do {
//            playGame();
//        } while (restartGame());
    }

    public static void playGame() {
        List<Integer> computerAnswer = generateNumber();
        boolean isCorrect;
        do {
            List<Integer> playerAnswer = getPlayerAnswer();
            isCorrect = checkAnswer(computerAnswer, playerAnswer);
        } while (isCorrect);

    }

    public static boolean checkAnswer(List<Integer> computerAnswer, List<Integer> playerAnswer) {
        boolean isCorrect = false;
        int strike = 0;
        int ball = 0;
        for(int i = 0;i < 3 ;i++){
            if(computerAnswer.get(i).equals(playerAnswer.get(i))){
                strike++;
            }else if(computerAnswer.contains(playerAnswer.get(i))){
                ball++;
            }
        }
        if(strike == 3){
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            isCorrect = true;
        }else if(strike == 0 && ball == 0){
            System.out.println("낫싱");
        }else{
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        return isCorrect;
    }

    public static List<Integer> generateNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> getPlayerAnswer() {
        String playerAnswerStr = Console.readLine();
        List<Integer> playerAnswerList = stringToIntegerList(playerAnswerStr);

        validateNumber(playerAnswerList);

        return playerAnswerList;
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

    public static boolean restartGame() {
        String s = Console.readLine();
        if(s.equals("1")){
            return true;
        }else if(s.equals("2")){
            return false;
        }else{
            throw new IllegalArgumentException("not 1,2: input erroooor");
        }
    }
}
