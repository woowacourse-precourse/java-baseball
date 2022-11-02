package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void startAnnounce() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static List<Integer> getRandomNumber() {
        List<Integer> randomNumber = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            randomNumber.add(Randoms.pickNumberInRange(1, 9));
        }
        return randomNumber;
    }

    public static boolean isEnterNumberExcept(String userEnterNumber) {
        boolean isExcepted = false;
        List<Integer> OneToNine = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        if(userEnterNumber.length() != 3) {
            isExcepted = true;
        } else if(userEnterNumber.charAt(0) == userEnterNumber.charAt(1) || userEnterNumber.charAt(1) == userEnterNumber.charAt(2)
            || userEnterNumber.charAt(0) == userEnterNumber.charAt(2)) {
            isExcepted = true;
        }
        for(int i = 0; i < 3; i++) {
            if(!OneToNine.contains(Character.getNumericValue(userEnterNumber.charAt(i)))) {
                isExcepted = true;
            }
        }
        return isExcepted;
    }

    public static List<Integer> getEnterNumber(String userEnterNumber) {
        List<Integer> enterNumber = new ArrayList<>();
        if(!isEnterNumberExcept(userEnterNumber)) {
            for(int i = 0; i < 3; i++) {
                enterNumber.add(Character.getNumericValue(userEnterNumber.charAt(i)));
            }
        } else {
            throw new IllegalArgumentException("정확한 세 자리 숫자를 입력해주세요");
        }
        return enterNumber;
    }

    public static void main(String[] args) {
        startAnnounce();
        String userEnterNumber = Console.readLine();
    }
}
