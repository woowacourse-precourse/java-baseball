package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        do {
            playGame();
        } while (playGameAgain());
    }
    public static void playGame() {
        List<Integer> computerNumber = makeRandom();
        System.out.println("숫자 야구 게임을 시작합니다.");
        HashMap<String, Integer> score;
        do {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> userNumber = splitNumber(Integer.parseInt(Console.readLine()));
            if (!checkException(userNumber)) {
                throw new IllegalArgumentException();
            }
            score = countBallAndStrike(userNumber, computerNumber);
            printResult(score);
        } while (!score.get("strike").equals(3));
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    public static List<Integer> makeRandom() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }
    public static List<Integer> splitNumber(int number) {
        List<Integer> userNumber = new ArrayList<>();
        while (number > 0) {
            userNumber.add(number%10);
            number /= 10;
        }
        Collections.reverse(userNumber);
        return userNumber;
    }

    public static boolean checkException(List<Integer> num) {
        String numString = num.toString().replace("[","").replace("]","").replaceAll(",","").replaceAll(" ","");
        if (numString.length() != 3) {
            return false;
        }
        if (numString.contains("0")) {
            return false;
        }
        if (!containSameNumber(numString)) {
            return false;
        }
        return true;
    }
    public static boolean containSameNumber(String numString) {
        HashMap<Character, Integer> checkSameNumber = new HashMap<>();
        for (int i = 0; i < numString.length(); i++) {
            if (checkSameNumber.containsKey(numString.charAt(i))) {
                return false;
            }
            checkSameNumber.put(numString.charAt(i), i);
        }
        return true;
    }
    public static HashMap<String, Integer> countBallAndStrike(List<Integer> userNumber, List<Integer> computerNumber) {
        HashMap<String, Integer> score = new HashMap<>();
        score.put("ball", 0);
        score.put("strike", 0);
        for (int i = 0; i < userNumber.size(); i++) {
            if (computerNumber.contains(userNumber.get(i))) {
                score.put("ball", score.get("ball") + 1);
            }
            if (userNumber.get(i).equals(computerNumber.get(i))) {
                score.put("strike", score.get("strike") + 1);
                score.put("ball", score.get("ball") - 1);
            }
        }
        return score;
    }

    public static void printResult(HashMap<String, Integer> score){
        if (score.get("strike").equals(3)){
            System.out.printf("%d%s%n",score.get("strike"),"스트라이크");
        }
        if (score.get("strike") > 0 && score.get("strike") < 3 && score.get("ball").equals(0)){
            System.out.printf("%d%s%n",score.get("strike"),"스트라이크");
        }
        if (score.get("ball") > 0 && score.get("strike").equals(0)){
            System.out.printf("%d%s%n",score.get("ball"),"볼");
        }
        if (score.get("strike") > 0 && score.get("ball") > 0){
            System.out.printf("%d%s %d%s%n",score.get("ball"),"볼",score.get("strike"),"스트라이크");
        }
        if (score.get("strike").equals(0) && score.get("ball").equals(0)) {
            System.out.println("낫싱");
        }
    }
    public static boolean playGameAgain() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int playGameAgainNumber = Integer.parseInt(Console.readLine());
        if (playGameAgainNumber == 1) {
            return true;
        }
        return false;
    }
}
