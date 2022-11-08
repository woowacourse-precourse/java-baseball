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

    public static void checkUserInput(String userString){
        if(userString.charAt(0)=='0'){
            throw new IllegalArgumentException();
        }
        if(userString.length()!=3){ //이런 건 메소드로 나누는게 좋은가?
            throw new IllegalArgumentException();
        }
        for(int i=0;i<userString.length();i++){
            char c = userString.charAt(i);
            if(c<'0' || c >'9'){
                throw new IllegalArgumentException();
            }
        }
    }

    public static List<Integer> StringToIntegerList(String string){
        List<Integer> integerList = new ArrayList<>();
        for(int i=0;i<string.length();i++){
            integerList.add(string.charAt(i)-'0');
        }
        return integerList;
    }
    private static int getRepeat(List<Integer> computerIntegerList) {
        while(true){
            System.out.print("숫자를 입력해주세요 : ");

            String userString = Console.readLine();
            List<Integer> userIntegerList = getUserIntegerList(userString);

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
    public static List<Integer> getUserIntegerList(String userString) {
        checkUserInput(userString);
        return StringToIntegerList(userString);
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
