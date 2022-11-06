package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 게임 진행 상태
        boolean usersAnswer = true;

        while (usersAnswer){

            // 컴퓨터가 3자리 숫자의 리스트 생성
            List<Integer> computerNumber = GenerateRandomNumber();

            // 유저의 문자 입력 받기
            String usersNumber = usersNumber();

            // 입력 받은 문자열 검증 <- 부정 표현 추후 리팩토링
            if(!validationUsersNumber(usersNumber)){
                // 잘못된 입력 값 시 IllegalStateException 발생
                throw new IllegalStateException();
            }



            // 정답 시 재시작/종료 탐색 기능
            usersAnswer = reGameOrEnd(usersNumber());

        }





    }

    private static boolean validationUsersNumber(String usersNumber) {

        // 입력한 문자열의 길이가 3자리가 아니라면 false
        if (usersNumber.length() != 3) {
            System.out.println("세자리 아님" + usersNumber);
            return false;
        }

        // 정규 표현식 숫자가 아닐 때 ! <- 부정 표현 추후 리팩토링
        if (!Pattern.matches("^[0-9]+$", usersNumber)) {
            System.out.println("숫자가 아님! " + usersNumber);
            return false;
        }

        return true;
    }

    private static boolean reGameOrEnd(String usersAnswer) {
        if(usersAnswer.equals("1")){
            return true;
        }else{
            return false;
        }
    }

    private static String usersNumber() {
        return Console.readLine();
    }

    private static List<Integer> GenerateRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }
}
