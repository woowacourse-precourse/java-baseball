package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void throwLastIllegal(String number)
    {
        char lastNumber = number.charAt(0);
        if(number.length() != 1 || (lastNumber != '1' && lastNumber != '2'))
            throw new IllegalArgumentException("1 혹은 2를 입력해주세요.");
    }

    public static void throwPickedIllegal(String number)
    {
        int pickedNumber = 0;
        if(number.length() != 3) throw new IllegalArgumentException("숫자를 3개 입력해주세요.");
        for(int i=0; i<3; i++)
        {
            pickedNumber = Character.getNumericValue(number.charAt(i));
            if(!(pickedNumber > 0 && pickedNumber < 10) || !Character.isDigit(number.charAt(i)))
                throw new IllegalArgumentException("1~9 사이 숫자만 입력해주세요");
        }
    }

    public static List<Integer> generateRandomNumber() // 난수 생성
    {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    public static int checkRightNumber(String number, List<Integer> computer) {
        int strike = 0;
        int ball = 0;
        int pickedNumber = 0;

        for(int i=0; i<3; i++) {
            pickedNumber = Character.getNumericValue(number.charAt(i));

            if(pickedNumber == computer.get(i)) strike += 1;
            else if(computer.contains(pickedNumber)) ball += 1;
        }

        if(strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            return -1;
        }

        if(strike == 0 && ball == 0) {
            System.out.println("낫싱");

            return 0;
        }

        else {
            if(ball > 0) System.out.print(ball + "볼 ");
            if(strike > 0) System.out.print(strike + "스트라이크");

            System.out.println("");

            return 1;
        }

    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> computer = generateRandomNumber();
        int flag = 0;
        String pickedNumber = "";
        String lastNumber = "";

        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true)
        {
            System.out.print("숫자를 입력해주세요 : ");
            pickedNumber = Console.readLine();
            throwPickedIllegal(pickedNumber);

            flag = checkRightNumber(pickedNumber,computer);

            if(flag == -1)
            {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                lastNumber = Console.readLine();
                throwLastIllegal(lastNumber);
            }
            if(lastNumber.equals("1"))
            {
                computer = generateRandomNumber();
                lastNumber = "";
            }
            else if(lastNumber.equals("2")) break;
        }
    }
}
