package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Pattern;

public class Application {

    private static HashMap<String, Integer> chooseComputerNumber() {
        HashMap<String, Integer> computer = new HashMap<>();
        while(computer.size() != 3) {
            String randomNumber = Integer.toString(Randoms.pickNumberInRange(1, 9));
            if (computer.containsKey(randomNumber)) {
                continue;
            }
            computer.put(randomNumber, computer.size());
        }
        return computer;
    }

    private static boolean isDistinctNumber(String number) {
        String[] res = Arrays.stream(number.split("")).distinct().toArray(String[]::new);
        if(number.length() == 3 && res.length == 3) {
            return true;
        }
        return false;
    }

    private static boolean isNumber(String number) {
        for(int i=0; i<number.length(); i++) {
            if(!Pattern.matches("[1-9]", Character.toString(number.charAt(i)))){
                return false;
            }
        }
        return true;
    }
    private static boolean isValidNumber(String number) {
        return isDistinctNumber(number) && isNumber(number);
    }
    private static String inputUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String num = Console.readLine();
        if(!isValidNumber(num)) {
            throw new IllegalArgumentException("반드시 서로 다른 정수3개를 적으셔야 합니다!");
        }
        return num;
    }

    private static void printResult(int[] res) {
        if(res[0] > 0 && res[1] > 0) {
            System.out.println(res[1] + "볼 " + res[0] + "스트라이크");
        } else if(res[0] > 0) {
            System.out.println(res[0] + "스트라이크");
        } else if(res[1] > 0) {
            System.out.println(res[1] + "볼");
        } else {
            System.out.println("낫싱");
        }
    }

    private static boolean oneOrTwo(String continueornot) {
        return Pattern.matches("[1, 2]", continueornot);
    }

    private static Integer selectContinueOrNot() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String continueornot = Console.readLine();
        if(!oneOrTwo(continueornot)) {
            throw new IllegalArgumentException("1 또는 2를 입력해야 합니다.");
        }
        return Integer.parseInt(continueornot);
    }

    private static boolean inputAndMatchNumber(HashMap computer) {
        String user = inputUserNumber();
        int[] result = matchNumber(computer, user);
        printResult(result);
        if (result[0] == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }
    private static Integer playGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        HashMap computer = chooseComputerNumber();
        boolean res;
        do{
            res = inputAndMatchNumber(computer);
        }while(!res);

        return selectContinueOrNot();
    }

    private static int[] countStrikeBall(HashMap com, String num, Integer idx, int[] res) {
        if(com.containsKey(num)) {
            if(com.get(num) == idx) {
                res[0] += 1;
            } else {
                res[1] += 1;
            }
        }
        return res;
    }

    private static int[] matchNumber(HashMap com, String user) {
        int[] res = {0, 0};
        for(int i=0; i<3; i++) {
            res = countStrikeBall(com, Character.toString(user.charAt(i)), i, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int res;
        do {
            res = playGame();
        }while(res == 1);
        System.out.println("게임 종료");
    }
}