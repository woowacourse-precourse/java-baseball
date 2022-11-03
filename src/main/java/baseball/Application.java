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

        List<Integer> numberList = inputNum();
        System.out.println(numberList);

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
        if (number.length() == 3 && isNumeric == true && numberList.size() == 3) { //서로 다른 수 추가
            return numberList;
        } else {
            throw new IllegalArgumentException("잘못된 값입니다.");
        }
    }

}