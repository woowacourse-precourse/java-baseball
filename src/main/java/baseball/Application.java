package baseball;

import java.util.List;
import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class Application {

    static boolean Exception_Status = true;
    static boolean status = true;
    public static List<Integer> InputNumber () {
        List<Integer> user = new ArrayList<>();
        String[] userNumber;

        System.out.println("숫자를 입력해주세요 : ");

        userNumber = Console.readLine().split("");
        for(int i=0; i<userNumber.length; i++){
            if(userNumber[i].equalsIgnoreCase(" "));
            else if(Integer.parseInt(userNumber[i]) >= 1 && Integer.parseInt(userNumber[i]) <= 9) {
                user.add(Integer.parseInt(userNumber[i]));
            }
            else IllegalArgumentException();
        }
        if(user.size()!=3 && Exception_Status==true){
            IllegalArgumentException();
        }
        return user;
    }

    public static boolean Compare(List<Integer> computer, List<Integer> Input) {
        int strike = 0;
        int ball = 0;
        for(int i=0; i<computer.size(); i++){
            ball += Counting(i, computer, Input).get(0);
            strike += Counting(i, computer, Input).get(1);
        }

        if (strike+ball==0) System.out.println("낫싱");
        else System.out.println(ball+"볼 "+strike+"스트라이크");

        if (strike<3)        return true;
        else {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            return false;
        }
    }
    public static List<Integer> Counting(int index, List<Integer> computer, List<Integer> Input){
        List<Integer> count = new ArrayList<>();
        int ball = 0;
        int strike = 0;
        for(int i=0; i<3; i++){
            if(i==index){
                strike += CompareInteger(computer.get(i), Input.get(index));
            }
            else {
                ball += CompareInteger(computer.get(i), Input.get(index));
            }
        }
        count.add(ball);
        count.add(strike);
        return count;
    }

    public static int CompareInteger(int a, int b){
        if(a==b) return 1;
        else return 0;
    }

    public static void GameStart(){
        List<Integer> computer = ComputerNumber();
        List<Integer> Input = new ArrayList<>();
        while(status && Exception_Status){
            Input = InputNumber();
            if(!Exception_Status) break;
            status = Compare(computer, Input);
        };
        status = true;
        while(status && Exception_Status){
            status = NewGameStart();
        };
    }

    public static boolean NewGameStart(){
        int Number;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Number = Integer.parseInt(Console.readLine());

        if(Number == 1){
            GameStart();
            return  true;
        }
        else {
            if (Number != 2) {
                IllegalArgumentException();
            }
            return false;
        }
    }

    public static List<Integer> ComputerNumber(){
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        System.out.println("숫자 야구게임을 시작합니다.");
        return computer;

    }

    public static void IllegalArgumentException(){
        System.out.println("입력값 오류, 시스템을 종료합니다.");
        Exception_Status = false;
    }

    public static void main(String[] args) {
        GameStart();
    }
}
