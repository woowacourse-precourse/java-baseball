package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;

public class Application {

    private static String chooseComputerNumber() {
        String computer = "";
        while(computer.length() != 3) {
            String randomNumber = Integer.toString(Randoms.pickNumberInRange(1, 9));
            if (computer.contains(randomNumber)) {
                continue;
            }
            computer += randomNumber;
        }
        return computer;
    }

    private static boolean isDistinctNumber(String number) {
        String[] res = Arrays.stream(number.split("")).distinct().toArray(String[]::new);
        if(number.length() == 3 && res.length == 3) {
            return true;
        } else {
            return false;
        }
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
        String computer = chooseComputerNumber();
        String user = inputUserNumber();
        return 2;
    }

    public static void main(String[] args) {
        int res;
        do {
            res = playGame();
        }while(res == 1);
        System.out.println("게임 종료");
    }
}