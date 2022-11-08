package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;

class Valid{
    public static int validation(List<Integer> userInput){
        if (userInput.size()==3){
            return 1;
        }
        else{
            throw new IllegalArgumentException();
        }
    }
}
class ConvertStringtoList{
    public static List ConverStringtoList(String input){
        List <Integer> userInput = new ArrayList();
        for (int i = 0; i < input.length(); i++) {
            System.out.println(Character.getNumericValue(input.charAt(i)));
            userInput.add(Character.getNumericValue(input.charAt(i)));
        }
        return userInput;
    }
}
// userInput의 볼, 스트라이크를 검사
class CheckNumber {
    // 스트라이크, 볼 변수 선언
    int strike = 0;
    int ball = 0;

    // ball, strike 상관없이 포함 검사 (total)
    public static int CountBallPlusStrike(List<Integer> computer, List<Integer> userInput) {
        int total = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (userInput.contains(computer.get(i))) {
                total++;
            }
        }
        return total;
    }

    // strike 만 검사
    public static int CountStrike(List<Integer> computer, List<Integer> userInput) {
        int strike = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i) == userInput.get(i)) {
                strike++;
            }
        }
        return strike;

        // ball은 total-strike 로 구할 수 있다.
    }
}
class Judge{
    static CheckNumber checkNumber = new CheckNumber();
    public static String judgement(List<Integer> computer, List<Integer> userInput) {
        int total = checkNumber.CountBallPlusStrike(computer, userInput);
        int strike = checkNumber.CountStrike(computer, userInput);
        int ball = total - strike;

        if (total==0){
            return "낫싱";
        }
        else if (strike==0){
            return ball+"볼";
        }
        else if (ball==0){
            return strike+"스트라이크";
        }
        else{
            return ball+"볼 "+strike+"스트라이크";
        }
    }
}
class Random{
    public List<Integer> radomThreeNum(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}

class Convert {
    public static List<Integer> convertStringToList(String input) {
        List<Integer> userInput = new ArrayList();
        for (int i = 0; i < input.length(); i++) {
            //System.out.println(Character.getNumericValue(input.charAt(i)));
            userInput.add(Character.getNumericValue(input.charAt(i)));
        }
        return userInput;
    }
}
public class Application {

    public static void main(String[] args) {
        //String input = null;
        List<Integer> userInput = new ArrayList();
        List<Integer> computer = new ArrayList<>();
        String result = "";
        Judge judge = new Judge();
        Convert convert = new Convert();
        Random random= new Random();
        String status = "1";
        Valid valid= new Valid();

        while (status.equals("1")) {
            result = "";
            // 1. 시작 멘트
            System.out.println("숫자 야구 게임을 시작합니다.");

            // 2. 숫자 3개 랜덤 추출
            computer= random.radomThreeNum();

            while (!result.equals("3스트라이크")) {
                userInput.clear();
                // 3. 사용자 입력 받기
                String input = Console.readLine();

                // 3.1 사용자 입력을 list로 변환
                userInput= convert.convertStringToList(input);

                // 3.2 사용자 입력 검증
                if (valid.validation(userInput)!=1) {
                    return;
                }

                // 4. 숫자검사
                result = judge.judgement(computer, userInput);
                System.out.println(result);
                //System.out.println(computer);
            }
            // 5. 새로 시작 or 종료
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            status=Console.readLine();
        }

        System.out.println("게임 종료");
    }
}
