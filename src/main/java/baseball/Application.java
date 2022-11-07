package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // 게임 진행 상태
        boolean usersAnswer = true;
        while (usersAnswer){
            // 컴퓨터가 3자리 숫자의 리스트 생성
            List<Integer> computerNumber = GenerateRandomNumber();
            // 야구 게임
            playBaseBall(computerNumber);
            // 재시작/종료 탐색
            usersAnswer = reGameOrEnd(usersNumber());
        }
    }
    private static void playBaseBall(List<Integer> computerNumber) {
        boolean endGame = true;
        while (endGame) {
            // 유저의 문자 입력 받기
            String usersNumber = usersNumber();
            // 입력 받은 문자열 검증 <- 부정 표현 추후 리팩토링
            if(!validationUsersNumber(usersNumber)){
                // 잘못된 입력 값 시 IllegalArgumentException 발생
                throw new IllegalArgumentException();
            }
            // 볼,스트라이크 체크
            List<Integer> result = checkStrikeOrBall(computerNumber, usersNumber);
            // 결과 출력
            announcedResult(result);
            // 3스트라이크 시 while문 종료
            endGame = isRight(result.get(1));
        }
    }
    private static boolean isRight(Integer strike) {
        if (strike == 3) {
            return false;
        }
        return true;
    }
    private static void announcedResult(List<Integer> result) {
        Integer ball = result.get(0);
        Integer strike = result.get(1);
        if(strike == 3){
            System.out.println(strike+"스트라이크");
        }
        else if (ball > 0 && strike > 0) {
            System.out.println(ball+"볼 "+strike+"스트라이크");
        } else if (ball > 0 && strike == 0) {
            System.out.println(ball+"볼");
        } else if (ball == 0 && strike > 0) {
            System.out.println(strike+"스트라이크");
        } else{
            System.out.println("낫싱");
        }
    }
    private static List<Integer> checkStrikeOrBall(List<Integer> computerNumber, String usersNumber) {
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < usersNumber.length(); i++) {
            int number = Character.getNumericValue(usersNumber.charAt(i));
            boolean isBall = isBall(computerNumber, number);
            boolean isStrike = false;
            if(isBall){
                isStrike = isStrike(computerNumber, number, i);
            }
            if(isStrike){
                strike++;
                continue;
            }
            if(isBall){
                ball++;
            }
        }
        return List.of(ball, strike);
    }
    private static boolean isBall(List<Integer> computerNumber, int number) {
        if (computerNumber.contains(number)){
            return true;
        }
        return false;
    }
    private static boolean isStrike(List<Integer> computerNumber, int number , int index) {
        if(!computerNumber.contains(number)){
            return false;
        }
        if(computerNumber.indexOf(number) == index){
            return true;
        }
        return false;
    }
    private static boolean validationUsersNumber(String usersNumber){
        // 입력한 문자열의 길이가 3자리가 아니라면 false
        if (usersNumber.length() != 3) {
            return false;
        }
        // 정규표현식 숫자로만 구성되어 있다면 true 반환
        if (Pattern.matches("[0-9]+$", usersNumber)) {
            return true;
        }
        return false;
    }
    private static boolean reGameOrEnd(String usersAnswer) {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
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
        List<Integer> list = new ArrayList<>();
        while (list.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            // 숫자 중복 검사
            if(isNotDuplicatedNumber(list , number)){
                list.add(number);
            }
        }
        return list;
    }
    private static boolean isNotDuplicatedNumber(List<Integer> list , int number) {
        if(list.contains(number)){
            return false;
        }else {
            return true;
        }
    }
}
