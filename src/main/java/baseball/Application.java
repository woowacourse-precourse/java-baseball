package baseball;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    static List<Integer> computer = new ArrayList<>();
    static List<List<Integer>> Ball_Strike = new ArrayList<>();
    public static void main(String[] args) {
        getRandomNum();
        gameStart();
    }
    public static void getRandomNum()
    {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
    public static void gameStart()
    {
        String number = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자 야구 게임을 시작합니다.");
        for(int i=0; i<3; i++) //게임을 3번 진행
        {
            do
            {
                System.out.println("숫자를 입력해주세요 : ");
                number = scanner.next();
                numberCheck(number);
            }while (!returnBallStrike(number,i));

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            number=scanner.next();
            if(number =="2")
            {
                System.out.println("게임 종료");
                break;
            }
        }


    }

    public static void numberCheck(String number)
    {
        numberLength3Check(number);
        number0To9(number);
    }

    public static void numberLength3Check(String number) {
        if (number.length() != 3) {
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    public static void number0To9(String number)
    {
        for(int i=0; i<3; i++)
        {
            if(number.charAt(i)>='0' && number.charAt(i)<='9')
            {
                try {
                    throw new IllegalArgumentException();
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException(e);
                }
            }
        }
    }

    public static boolean returnBallStrike(String number, int idxGame)
    {
        for(int i=0; i<3; i++)
        {
            char value = number.charAt(i);

        }
    }
}
