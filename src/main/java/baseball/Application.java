package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        init();
        while(true) {
            List<Integer> randomNum = MakeNumber();
            runGame(randomNum);
            if(choose()==2){
                break;
            }
        }
    }
    public  static  int choose(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int num = Integer.valueOf(Console.readLine());
        return num;
    }
    public static void runGame(List<Integer> randomNum) {  //게임을 진행하는 함수
        int strike = 0;
        int ball =  0;
        String userInput = "";
        while(strike !=3){
            userInput =  Input();
            List<Integer> newUserInput = ConvertNum(userInput);
            strike = StrikeCheck(randomNum,newUserInput);
            ball = BallCheck(randomNum,newUserInput) -strike;
            output(strike,ball);
        }
    }
    public static void output(int strike, int ball){
        if(strike ==3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        else if(ball == 0 && strike !=0){ //strike만 있을때
            System.out.println(strike+"스트라이크");
        }
        else if(ball != 0 && strike ==0){
            System.out.println(ball+"볼");
        }
        else if(ball != 0 && strike !=0){
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }
        else if(ball == 0 && strike ==0){
            System.out.println("낫싱");
        }
    }
  public static void init() {  //게임 시작 메시지를 알림

        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public static  List<Integer> MakeNumber() {  //난수 생성하는 함수
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    public static  int checkInput(String num){
        if(checklength(num)==0){
            return 0;
        }
        else if (checknum(num)==0){
            return 0;
        }
        else if(checkzero(num)==0){
            return 0;
        }
        else if(checkdupli(num)==0){
            return 0;
        }
        return 1;
    }
    public static int checkdupli(String num){
        List<String> tmp = new ArrayList<>();
        for (int idx = 0;idx<3;idx++){
            if(!tmp.contains(num.substring(idx,idx+1))){
                tmp.add(num.substring(idx,idx+1));
            }
            else if(tmp.contains(num.substring(idx,idx+1))){
                return 0;
            }
        }
        return 1;
    }
    public static int checklength(String num){
        if(num.length() !=3){
            return 0;
        }
        return 1;
    }
    public static  int checkzero(String num){ //각 숫자가 1에서 9사이 값인지 검사
        for (int idx =0 ;idx<3;idx++){
            if(Integer.valueOf(num.substring(idx,idx+1))<1){
                return 0;
            }
        }
        return 1;
    }
    public  static  int checknum(String num) {  //숫자인지 판단
        for (int idx =0;idx<num.length();idx++){
            if(Character.isDigit(num.charAt(idx))==false){
                return 0;
            }
        }
        return 1;
    }
    public static String Input() {  //사용자 입력 받는 함수
        System.out.print("숫자를 입력해주세요 : ");
        String  UserInput = Console.readLine();

        if(checkInput(UserInput)==0) {
            throw new IllegalArgumentException();
        }
        //예외처리
        //3자리수를 입력했는지 체크
        //만약에 사용자가 중복된 숫자를 입력하면 예외처리  (113) ~!!!
        //ㄱㅏㄱ 자리수가 0보다 큰지 체크
        return UserInput;
    }
    public static int check(List<Integer> ComNum,List<Integer>  UserNum) {
        BallCheck(ComNum, UserNum);
        return 0;
    }
    public static int BallCheck(List<Integer> ComNum,List<Integer> UserNum){   //Ball 개수를 체크하는 함수
        int ballCnt =0;
        for(int idx =0; idx <3;idx++){
            if(ComNum.contains(UserNum.get(idx))){
                ballCnt++;
            }
        }
        return ballCnt ;
    }
    public static  int StrikeCheck(List<Integer> ComNum,List<Integer> UserNum) {  //Strike 개수를 체크하는 함수
       int strikeCnt = 0;
       for (int idx =0;idx<3;idx++){
           if(ComNum.get(idx)==UserNum.get(idx)){
               strikeCnt++;
           }
       }
        return strikeCnt;
    }
    public static List<Integer>  ConvertNum(String UserNum) { //사용자가 입력한 숫자의 자료형을 바꾸는 함수
        List<Integer> NewUserNum = new ArrayList<>();
        Integer tmpUserNum = 0;  //자료형 Int 인지 Integer인지
        for (int idx = 0; idx<UserNum.length();idx++){
            tmpUserNum = Integer.valueOf(UserNum.substring(idx,idx+1));  //다시
            NewUserNum.add(tmpUserNum);
        }
        return  NewUserNum;
    }
}
