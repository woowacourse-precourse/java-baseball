package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            List<Integer> computerNumber = makeRandomNumber();
            System.out.println(computerNumber);
            while (true) {
                String userNumber = inputUserNumber();

                //제한사항 체크
                try {
                    validateUserNumber(userNumber);
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException(e);
                }

                // 맞춘다면 반복문 빠져나오기
                if (computerNumber.equals(toList(userNumber))) break;
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String gameCoin = Console.readLine();
            try {
                validateGameCoin(gameCoin);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(e);
            }

            if (gameCoin.equals("2")) break;
        }
    }

    public static List<Integer> makeRandomNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) { //중복 방지
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public static String inputUserNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        String userNumber = Console.readLine();

        return userNumber;
    }

    public static List<Integer> toList(String userNumber){
        List<Integer> listUserNumber = new ArrayList<>();

        for(int userNumberIndex = 0; userNumberIndex<userNumber.length();userNumberIndex++){
            // validate를 통해 3글자 숫자임이 확정이므로 0의 아스키 코드 값이 48임을 이용해 문자를 숫자로 바꾸어준다.
            listUserNumber.add(userNumber.charAt(userNumberIndex) - 48);
        }

        return listUserNumber;
    }

    public static void validateUserNumber(String userNumber){
        if(userNumber.length() != 3){
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요!");
        }

        for(char number : userNumber.toCharArray()){
            // 중복된 숫자가 있으면 예외
            if( userNumber.chars().filter(c -> c == number).count() > 1 ){
                throw new IllegalArgumentException("중복된 숫자를 입력하셨습니다!");
            }

            // 숫자가 아니면 예외
            if(Character.isDigit(number)==false){
                throw new IllegalArgumentException("숫자 이외의 값을 입력하셨습니다!");
            }
        }
    }

    public static void validateGameCoin(String gameCoin) {
        // 1,2가 아니면 exception
        if(Pattern.matches("[1-2]",gameCoin) == false){
            throw new IllegalArgumentException("1,2 이외의 값을 입력하셨습니다!");
        }
    }

}