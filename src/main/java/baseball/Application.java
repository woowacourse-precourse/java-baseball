package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static final int len = 3; //항상 3자리 수로 고정이므로 len변수에 값 저장
    private static List<Integer> computerNum; //컴퓨터 숫자

    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");
        startGame();
    }

    //5. 컴퓨터 숫자 설정하고 게임 진행 method
    public static void startGame(){
        computerNum = getComputerNum();
        Game();
    }

    //5. 2번부터 4번까지 반복할 method
    public static void Game(){
        List<Integer> userNum = getUserNum();

        int strike = getStrike(computerNum, userNum);
        int ball = getBall(computerNum, userNum);
        printResult(strike, ball);

        if(strike == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            ContinueOrEnd();
        }
        else{
            userNum.clear();
            Game();
        }
        //isRightAnswerAndContinue(strike, userNum);
    }


    //1. 컴퓨터 3자리 랜덤 숫자 생성
    public static List<Integer> getComputerNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < len) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    //2번부터 4번까지 반복
    //2. 사용자가 3자리 숫자 입력
    public static List<Integer> getUserNum(){
        List<String> scope = new ArrayList<>(List.of("1","2","3","4","5","6","7","8","9"));

        System.out.print("숫자를 입력해주세요: ");
        String input = Console.readLine();
        System.out.println(input);

        String[] inputArray = input.split(""); //사용자가 입력한 숫자 쪼개기
        List<Integer> userNum = new ArrayList<>(); //사용자가 입력한 최종 숫자
        userException(scope, input, inputArray, userNum); //예외상황 판별

        return userNum;
    }

    //2-1. 사용자가 3자리 숫자 입력 예외상황
    public static void userException(List<String> scope, String userInput, String[] inputArray, List<Integer> userNum){
        //문자를 입력했을 때
        for(int i=0; i<inputArray.length; i++){
            if(!scope.contains(inputArray[i])){
                throw new IllegalArgumentException();
            }
            else{
                userNum.add(Integer.valueOf(inputArray[i]));
            }
        }

        //0 입력
        if(userInput.contains("0")){
            throw new IllegalArgumentException();
        }

        //3자리의 수가 아닐 때
        if (userInput.length()!=len){
            throw new IllegalArgumentException();
        }

        //숫자 중복되었을 때
        int cnt = 0;
        int left = 0;
        int right = 1;
        while(cnt < len){
            if(userNum.get(left).equals(userNum.get(right))){
                throw new IllegalArgumentException();
            }
            else if (right != len-1){
                right++;
            }
            else {
                left++;
            }
            cnt++;
        }

    }

    //3. 사용자가 입력한 수와 컴퓨터 수 비교
    //스트라이크 계산 method
    public static int getStrike(List<Integer> computerNum, List<Integer> userNum){
        int strike=0;
        for (int i=0; i<len; i++) {
            if(computerNum.get(i).equals(userNum.get(i))){
                strike++;
            }
        }
        return strike;
    }
    //볼 계산
    public static int getBall(List<Integer> computerNum, List<Integer> userNum){
        int ball=0;
        int left=0;
        int right=0;
        int cnt=0;

        while(cnt < 9){
            if(computerNum.get(left).equals(userNum.get(right)) && left!=right){
                ball++;
            }
            right++;
            cnt++;
            if(right == len){
                left++;
                right = 0;
            }
        }
        return ball;
    }

    //4. 결과 출력
    public static void printResult(int strike, int ball) {
        if(ball + strike == 0){
            System.out.println("낫싱");
        }
        else if(ball==0 && strike>0){
            System.out.println(strike+"스트라이크");
        }
        else if(ball>0 && strike==0){
            System.out.println(ball+"볼");
        }
        else {
            System.out.println(ball+"볼"+" "+strike+"스트라이크");
        }
    }


    //6. 정답인지 아닌지 판별한 다음 게임 재시작할지 종료할지 결정
    /*
    public static void isRightAnswerAndContinue(List<Integer> user){
        if(strike == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            ContinueOrEnd();
        }
        else{
            user.clear();
            Game();
        }
    }

     */

    public static void ContinueOrEnd(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String option = Console.readLine();
        if(option.equals("1")){
            System.out.println(1);
            startGame();
        }
        else if(option.equals("2")){
            System.out.println(2);
            endGame();
        }
        else{
            throw new IllegalArgumentException("잘못된 값이 입력되었습니다.");
        }
    }
    public static boolean endGame(){
        return true;
    }










}
