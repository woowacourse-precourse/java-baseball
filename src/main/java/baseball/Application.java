package baseball;

import java.util.List;
import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.lang.IllegalArgumentException;

public class Application {

    static boolean Exception_Status = true;
    static boolean status = true;
    public static List<Integer> InputNumber () {
        String[] userNumber;
        List<Integer> user;

        System.out.println("숫자를 입력해주세요 : ");

        userNumber = Console.readLine().split("");
        user = StringtoInteger_Input(userNumber);
        SizeCompare(user);
        DuplicationTest(user);

        return user;
    }

    public static boolean InputErrorCheck(String input){
        char key = input.charAt(0);
        if((int)(key)<49 || (int)(key)>57 ) {
            if(key == ' ' || key == ',') {
                return true;
            }
            else{
                IllegalArgumentException();
                return false;
            }
        }
        else {
            return true;
        }
    }

    public static List<Integer> StringtoInteger_Input(String [] userNumber){

        List<Integer> user = new ArrayList<>();

        for(int i=0; i<userNumber.length; i++){
            Exception_Status = InputErrorCheck(userNumber[i]);
            if(!Exception_Status) break;
            if(userNumber[i].equalsIgnoreCase(" ") || userNumber[i].equalsIgnoreCase(","));
            else user.add(Integer.parseInt(userNumber[i]));
        }
        return user;
    }

    public static void SizeCompare(List<Integer> user){
        if(user.size()!=3){
            if(Exception_Status == true) IllegalArgumentException();
        }
    }

    public static void DuplicationTest(List<Integer> user){
        int cnt = 0;
        int pointer = 0;

        for(int i=1; i<3; i++){
            cnt += CompareInteger(user.get(i), user.get(pointer++)) ;
            if(i==2){
                cnt += CompareInteger(user.get(i), user.get(0));
            }
        }
        if(cnt>0) IllegalArgumentException();
    }

    public static boolean Compare(List<Integer> computer, List<Integer> Input) {
        int ball = 0;
        int strike = 0;
        for(int i=0; i<computer.size(); i++){
            ball = Sum(ball, BallCount(i, computer, Input).get(0));
            strike = Sum(strike, BallCount(i, computer, Input).get(1));
        }

        Output_of_BallCount(ball, strike);
        return CompareResult(strike);
    }

    public static int Sum(int a, int b){
        return a+b;
    }

    public static void Output_of_BallCount(int ball, int strike){
        if (ball+strike==0) System.out.println("낫싱");
        else System.out.println(ball+"볼 "+strike+"스트라이크");
    }

    public static boolean CompareResult(int strike){
        if (strike<3) return true;
        else {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        }
    }

    public static List<Integer> BallCount(int index, List<Integer> computer, List<Integer> Input){
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
        if(Exception_Status) GameOver();
    }

    public static void GameOver(){
        status = true;
        NewGameStart();
    }

    public static boolean NewGameStart(){
        String temp;
        int Number;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        temp = Console.readLine();
        if(!InputErrorCheck(temp)) return false;

        Number = Integer.parseInt(temp);
        return NewGameFlag(Number);
    }

    public static boolean NewGameFlag(int Number){
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
        System.out.println(computer);
        System.out.println("숫자 야구게임을 시작합니다.");
        return computer;
    }

    public static void IllegalArgumentException(){
        Exception_Status = false;
        throw new IllegalArgumentException("입력값 오류, 시스템을 종료합니다.");
    }

    public static void main(String[] args) {
        GameStart();
    }
}
