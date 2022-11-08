package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        repeatBaseBallGame();
        // TODO: 프로그램 구현
    }

    public static List<Integer> reComputerNumber(){
        List<Integer> computer = new ArrayList<>();
        while(computer.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static boolean checkTwoNumbersAreSame(int num1,int num2){
        if(num1 ==num2){
            return true;
        }
        return false;
    }

    private static int getRepeat(List<Integer> computerIntegerList) {
        while(true){
            System.out.print("숫자를 입력해주세요 : ");

            User user = new User();
            user.inputIntegerList();
            List<Integer> userIntegerList = user.integerList;

            Result result = new Result();
            result.countStrikeAndBall(userIntegerList, computerIntegerList);

            if(result.ball==0 && result.strike ==0){
                System.out.println("낫싱");
            }
            if(result.ball!=0){
                System.out.print(result.ball+"볼 ");
            }
            if(result.strike!=0){
                System.out.println(result.strike+"스트라이크");
            }
            if(result.strike==3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하면 2를 입력하세요.");
                return Integer.parseInt(Console.readLine())-1;
            }
        }
    }


    public static void repeatBaseBallGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        int repeat =0;
        while (repeat==0){
            List<Integer> computerIntegerList = reComputerNumber();
            repeat = getRepeat(computerIntegerList);
        }
    }
}
