package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 컴퓨터가 만든 3자리수
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println(computer);
        List<Integer> numberList = inputNum();
        Baseball baseball = compareNum(numberList, computer);
        System.out.println("스트라이크 : "+baseball.getStrike());
        System.out.println("볼 : "+baseball.getBall());
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

    public static Baseball compareNum(List<Integer> numberList, List<Integer> computer) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (numberList.get(i) == computer.get(i)) {
                strike += 1;
            } else if (computer.contains(numberList.get(i))) {
                ball += 1;
            }
        }

        Baseball baseball = new Baseball(strike, ball);
        return baseball;
    }

    public static class Baseball{
        private int strike;
        private int ball;

        public Baseball(int strike, int ball){
            this.strike = strike;
            this.ball = ball;
        }

        public int getStrike() {
            return strike;
        }

        public int getBall() {
            return ball;
        }
    }
}
