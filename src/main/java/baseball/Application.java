package baseball;

import java.util.HashMap;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            System.out.print("숫자를 입력해주세요 : ");
            int userNumber = Integer.parseInt(Console.readLine());
            if (!checkException(userNumber)){
                throw new IllegalArgumentException();
            }
            //낫싱, 볼, 스트라이크
        }
//        while (3 스트라이크){
//            //게임 종료
//        }
    }
    public static boolean checkException(int num){
        String numString = Integer.toString(num);
        if (numString.length() != 3){
            return false;
        }
        if (numString.contains("0")){
            return false;
        }
        if (!containSameNumber(numString)){
            return false;
        }
        return true;
    }
    public static boolean containSameNumber(String numString){
        HashMap<Character, Integer> checkSameNumber = new HashMap<>();
        for (int i = 0; i < numString.length(); i++) {
            if (checkSameNumber.containsKey(numString.charAt(i))){
                return false;
            }
            checkSameNumber.put(numString.charAt(i), i);
        }
        return true;
    }
}
