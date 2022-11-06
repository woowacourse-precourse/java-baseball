package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.HashMap;

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
        try{
            Integer.parseInt(number);
            return true;
        } catch (Exception e) {
            return false;
        }
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
    private static Integer playGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        HashMap computer = chooseComputerNumber();
        System.out.println(computer);
        String user = inputUserNumber();
        int[] result = matchNumber(computer, user);
        System.out.println(Arrays.toString(result));

        return 2;
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