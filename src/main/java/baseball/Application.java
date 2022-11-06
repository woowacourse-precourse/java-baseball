package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;

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

            // 정답 시 재시작/종료 탐색 기능
            usersAnswer = reGameOrEnd(usersNumber());

        }





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
