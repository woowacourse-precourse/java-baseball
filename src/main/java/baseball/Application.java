package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static boolean match;

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        do{
            List<Integer> computerNumber = initializeGame();

            while(!match){
                String userNumber = getUserNumber();
                System.out.println(compareComputerAndUserNumber(computerNumber, userNumber));
            }

        }while(finishOrRestart());
    }

    private static List<Integer> initializeGame(){
        match = false;
        System.out.println("숫자 야구 게임을 시작합니다.");
        return computerRandomNumber();
    }

    private static boolean finishOrRestart(){
        System.out.println("개임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String check = Console.readLine();
        if(check.equals("1")){
            return true;
        }
        return false;
    }

    private static List<Integer> computerRandomNumber(){
        List<Integer> computerNumber = new ArrayList<>();
        while(computerNumber.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computerNumber.contains(randomNumber)){
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

    private static String getUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String userNumber = Console.readLine();

        isValidUserNumber(userNumber);

        return userNumber;
    }

    private static void isValidUserNumber(String userNumber){
        if(userNumber.length() != 3 || isContainZero(userNumber)
                || !isAllNumber(userNumber) || isDuplicate(userNumber)){
            throw new IllegalArgumentException("0을 제외한 서로 다른 세 자리의 숫자를 입력 해주세요.");
        }
    }

    private static boolean isAllNumber(String userNumber){
        if(userNumber.chars().allMatch(Character :: isDigit)){
            return true;
        }
        return false;
    }

    private static boolean isDuplicate(String userNumber){
        for(char n : userNumber.toCharArray()){
            if(userNumber.chars().filter(c -> c == n).count() != 1){
                return true;
            }
        }
        return false;
    }

    private static boolean isContainZero(String userNumber){
        if(userNumber.contains("0")){
            return true;
        }
        return false;
    }

    private static String compareComputerAndUserNumber(List<Integer> computerNumber, String userNumber){
        int strike = 0, ball = 0;

        for(int i=0; i<3; i++){
            if(!computerNumber.contains(Character.getNumericValue(userNumber.charAt(i)))){
                continue;
            }
            if(existStrike(computerNumber.get(i), userNumber.charAt(i))){
                strike++;
            }else if(existBall(computerNumber.get(i), userNumber.charAt(i))){
                ball++;
            }
        }

        return checkResult(strike, ball).toString();
    }

    private static boolean existStrike(Integer computerNumber, Character userNumber){
        if(computerNumber == Character.getNumericValue(userNumber)){
            return true;
        }
        return false;
    }

    private static boolean existBall(Integer computerNumber, Character userNumber){
        if(computerNumber != Character.getNumericValue(userNumber)){
            return true;
        }
        return false;
    }

    private static StringBuilder checkResult(int strike, int ball){
        StringBuilder result = new StringBuilder();
        if(strike == 3){
            result.append("3스트라이크\n\"3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            match = true;
        }else if(strike == 0){
            if(ball == 0){
                result.append("낫싱");
            }else{
                result.append(ball + "볼");
            }
        }else if(ball == 0){
            result.append(strike + "스트라이크");
        }else{
            result.append(ball + "볼 " + strike + "스트라이크");
        }

        return result;
    }
}
