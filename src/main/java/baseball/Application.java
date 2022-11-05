package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

    }

    public static void playGame(){
        List<Integer> computerAnswer = generateNumber();

        do{
            List<Integer> playerAnswer = getPlayerAnswer();
            checkAnswer(playerAnswer);

        }while(getPlayerAnswer().equals(computerAnswer));

    }
    public static List<Integer> checkAnswer(List<Integer>){
        return ;
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

}
