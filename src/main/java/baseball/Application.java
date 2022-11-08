package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Application {

    static List<Integer> target;
    static List<Integer> num;
    private static String regex = "^[1-9]{3}$";
    private static String regexCode = "^[1-2]$";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        int gameCode = 1;

        while (gameCode != 2) {
            setTarget();

            while (true) {
                System.out.println("숫자를 입력해주세요 : ");
                checkInput();
                String compareResultStr = compareNumber();
                System.out.println(compareResultStr);
                if (compareResultStr.equals("3스트라이크")) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }

            while (true) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String codeStr = Console.readLine();
                if (checkGameCode(codeStr)) {
                    gameCode = Integer.parseInt(codeStr);
                    break;
                }
                System.out.println("1과 2 중에 다시 입력해주세요.");
            }
        }

    }

    static void setTarget() {
        Set<Integer> randNumSet = new LinkedHashSet<>();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (randNumSet.size() < 3) {
            int pickNum = Randoms.pickNumberInRange(1, 9);
            if (!randNumSet.contains(pickNum)) {
                randNumSet.add(pickNum);
            }
        }
        ArrayList<Integer> target = new ArrayList<>(randNumSet);
    }

    static void checkInput() {
        String inputNum = Console.readLine();
        //1. 3자리 아님
        if (inputNum.length() != 3) {
            throw new IllegalArgumentException("숫자의 어느 자리에도 0이 포함되지 않는 3자리의 숫자를 입력하십시오.");
        }
        //2. 1-9 이외 값이 포함(1: 49, 9: 57)
        if (!inputNum.matches(regex)) {
            throw new IllegalArgumentException("1-9사이 값을 입력하시오.");
        }
//        for(int i=0;i<inputNum.length();i++){
//            char ch=inputNum.charAt(i);
//            //3. 3자리 수 중 중복이 있을 때
//            if(appear.get(String.valueOf(ch))==1){
//                throw new IllegalArgumentException("3자리의 숫자 중 중복되는 값이 존재해서는 안됩니다.");
//            }else {
//                appear.put(String.valueOf(ch),1);
//            }
//        }
        num = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            num.add(inputNum.charAt(i) - '0');
        }
    }

    private static String compareNumber() {
        String resStr = "";
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            int computerNum = target.get(i);
            int userNum = num.get(i);

            if (computerNum == userNum) {
                strike++;
            } else if (target.contains(userNum)) {
                ball++;
            }
        }

        if (ball == 0 && strike == 0) {
            resStr = "낫싱";
        }
        if (ball != 0) {
            resStr = ball + "볼 ";
        }
        if (strike != 0) {
            resStr += strike + "스트라이크";
        }

        return resStr;
    }

    private static boolean checkGameCode(String gameCodeStr) {
        if (gameCodeStr.matches(regexCode)) {
            return true;
        }
        return false;
    }
}
