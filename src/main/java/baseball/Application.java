package baseball;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

            GameController game = new GameController();
            GameController.startGame(game);
        // TODO: 프로그램 구현
    }
}

class ArraySearch
{
    boolean contains(int nowNumber, List<Integer>number)
    {
        return number.contains(nowNumber);
    }

    int correctNumber(int nowNumber,List<Integer>number)
    {
        for(int i : number)
        {
            if(nowNumber == i)
                return number.indexOf(i);
        }
        return -1;
    }
}

class GameController
{
    List<Integer> number = new ArrayList<>();

    GameController() {
        while (number.size() < 3) {
            int randomNumber = getRandomNumber();
            if (!number.contains(randomNumber)) {
                number.add(randomNumber);
            }
        }
    }

    GameController(String userNum) {
        for (int i = 0; i < userNum.length(); i++)
        {
            number.add(Character.getNumericValue(userNum.charAt(i)));
        }
    }

    private int getRandomNumber()
    {
        return Randoms.pickNumberInRange(1,9);
    }

    public static void startGame(GameController computer)
    {
        Scanner scan = new Scanner(System.in);
        String userNum;
        do
        {
            System.out.print("숫자를 입력해주세요: ");
            userNum = scan.next();
        }while(computer.error(userNum));

        GameController user = new GameController(userNum);
        Calculate calculate = new Calculate();
        calculate.compare(computer,user);

        if(calculate.getStrike() != 3)
        {
            startGame(computer);
            return;
        }
        System.out.println("게임 종료");
        System.out.println("게임을 새로 시작하려면 1, "+
                "종료하려면 2를 입력하세요.");
        int restart = scan.nextInt();
        if(restart == 1)
        {
            computer = new GameController();
            computer.startGame(computer);
        }
    }

    private boolean error(String userNum)
    {
        if(userNum.length()!=3)
        {
            return false;
        }
        else
        {
            char now = userNum.charAt(0);
            for(int i = 1;i<userNum.length();i++)
            {
                char next = userNum.charAt(i);
                if(now == next)
                {
                    return false;
                }
                else if((now <1 || now >9) && (next <1 || next>9))
                {
                    return false;
                }
                now = next;
            }
        }
        return true;
    }
}

class Calculate
{
    int ball = 0;
    int strike = 0;

    private void addBall()
    {
        this.ball++;
    }

    private void addStrike()
    {
        this.strike++;
    }

    public int getStrike()
    {
        return strike;
    }
    public void compare(GameController computer, GameController user)
    {
        ArraySearch array = new ArraySearch();
        for(int i = 0; i<3; i++)
        {
            int nowNumber = computer.number.get(i);

            if(!array.contains(nowNumber,user.number))
            {
                continue;
            }
            else if(i==array.correctNumber(nowNumber,user.number))
            {
                addStrike();
                continue;
            }
            addBall();
        }
        resultString();
    }

    public void resultString() {
        if(strike == 3)
        {
            System.out.println(strike + " 스트라이크");
            System.out.print("3개의 숫자를 모두 맞히셨습니다. ");
        }
        else if (ball != 0 || strike != 0) {
            if (ball == 0) {
                System.out.println(strike + " 스트라이크");

            } else if (strike == 0) {
                System.out.println(ball + " 볼");
            } else
            {
                System.out.println( ball + " 볼 " + strike + " 스트라이크");
            }

        } else {
            System.out.println("낫싱");
        }
    }
}