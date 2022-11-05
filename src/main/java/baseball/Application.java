package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = makeComputer(); // 컴퓨터 번호 만들기
        System.out.println(computer); // 컴퓨터 번호 출력
        List<Integer> numberList = inputNum(); // 사용자 3자리 입력

        HashMap<String, Integer> map = compareNum(numberList, computer); // 컴퓨터값과 사용자값 비교

        int strike = map.get("strike"); // 스트라이크 값
        int ball = map.get("ball"); // 볼 값
        String message = getMessage(strike, ball); // 스트라이크 볼에 따른 메세지 출력
        System.out.println(message);
    }
    // 컴퓨터 3자리 수 만들기
    public static List<Integer> makeComputer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber);
            }
        }
        return computer;
    }


    //입력 메서드
    public static List<Integer> inputNum() {
        System.out.print("숫자를 입력해주세요 : ");
        String number = Console.readLine();

        boolean isNumeric = number.chars().allMatch(Character::isDigit);

        List<Integer> numberList = new ArrayList<>();
        for(int i = 0; i<3; i++){
            char charNum = number.charAt(i);
            int num = Character.getNumericValue(charNum);
            if (!numberList.contains(num)) {
                numberList.add(num);
            }
        }
        if (number.length() == 3 && isNumeric == true && numberList.size() == 3) {
            return numberList;
        } else {
            throw new IllegalArgumentException("잘못된 값입니다.");
        }
    }

    // 입력값과 컴퓨터 값 비교
    public static HashMap<String, Integer> compareNum(List<Integer> numberList, List<Integer> computer) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (numberList.get(i) == computer.get(i)) {
                strike += 1;
            } else if (computer.contains(numberList.get(i))) {
                ball += 1;
            }
        }
        HashMap<String,Integer> map = new HashMap<>();

        map.put("strike", strike);
        map.put("ball", ball);

        return map;
    }

    // 스트라이크와 볼 값에 따른 메세지
    public static String getMessage(int strike, int ball){

        String message = null;

        if(strike == 0 && ball == 0){
            message = "낫띵";
        }
        else if(strike > 0 && ball == 0){
            message = strike+"스트라이크";
        }
        else if(strike == 0 && ball > 0){
            message = ball+"볼";
        }
        else if(strike > 0 && ball > 0){
            message = ball+"볼 "+strike+"스트라이크";
        }
        return message;
    }

}
