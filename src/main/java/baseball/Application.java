package baseball;

import camp.nextstep.edu.missionutils.*;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 컴퓨터,플레이어,게임 룰과 진행을 관리하는 게임 매니저
        Computer computer = new Computer();
        Player player = new Player();
        GameManager manager = new GameManager(computer,player);

        // 게임 매니저에 의한 게임 실행
        manager.doGame();
    }
}
/*게임 매니저
* - 플레이어를 위한 설정 정의
* - 
* */
class GameManager{
    // 컴퓨터, 플레이어 객체
    Computer computer = new Computer();
    Player player = new Player();

    // 생성자
    public GameManager(){}
    public GameManager(Computer c,Player p){
        this.computer = c;
        this.player = p;
    }

    public void doGame(){
        // 게임 시작
        System.out.println("숫자 야구 게임을 시작합니다.");
        // 컴퓨터 설정 초기화
        setComputerSetting(computer);

        // 정답 전까지 게임 진행
        do{
            // 유저 설정 초기화
            setUserSetting(player);
            // 정답인지 판별
            verifyUserAnswer(computer, player);
            // 판별에 대한 출력
            printUserAnswer(player);
        }while(player.strikeCount!=3);
        // 재시작 여부 질의
        askRestart();
    }
    // 컴퓨터 세팅 설정
    public void setComputerSetting(Computer computer){
        // 이전 컴퓨터의 난수 비우기
        computer.computerAnswer.clear();
        // 컴퓨터의 난수 생성
        computer.generateAnswer();
    }
    // 유저 세팅 설정
    public void setUserSetting(Player player){
        // 볼,스트라이크,낫싱 카운트
        player.ballCount = 0;
        player.strikeCount = 0;

        // 플레이어 초기화 & 입력
        player.playerAnswer.clear();
        player.getUserInput();
    }

    // 스트라이크, 볼 여부 확인
    public void verifyUserAnswer(Computer computer,Player player){
        // 볼,스트라이크,낫싱 판별
        for (int i = 0; i < player.playerAnswer.size(); i++) {
            hasSameNumber(computer,player,i);
        }
    }
    // 같은 수인지 확인
    public void hasSameNumber(Computer computer,Player player, int i){
        if (computer.computerAnswer.contains(player.playerAnswer.get(i))) {
            hasSameDigit(computer,player,i);
        }
    }
    // 같은 자리인지 확인
    public void hasSameDigit(Computer computer,Player player,int i){
        // same num& same digit => strike
        // only same num => ball
        if (computer.computerAnswer.get(i).equals(player.playerAnswer.get(i))) {
            player.strikeCount++;
        } else {
            player.ballCount++;
        }
    }
    // 사용자 입력 결과값 출력
    public void printUserAnswer(Player player){
        printNothing(player);
        printStrike(player);
        printBallOrStrike(player);
    }
    // 낫싱 케이스
    public void printNothing(Player player){
        if (player.ballCount == 0 && player.strikeCount == 0) {
            System.out.println("낫싱");
        }
    }
    
    // 스트라이크만 있는 케이스
    public void printStrike(Player player){
        if (player.ballCount == 0 && player.strikeCount > 0) {
            System.out.println(player.strikeCount + "스트라이크");
            if (player.strikeCount == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
        }
    }
    // 볼 혹은 스트라이크 케이스
    public void printBallOrStrike(Player player){
        if (player.ballCount != 0) {
            if (player.strikeCount == 0) { // 볼만 있는 경우
                System.out.println(player.ballCount + "볼");
            } else { // 볼과 스트라이크 모두 있는 경우
                System.out.println(player.ballCount + "볼 " + player.strikeCount + "스트라이크");
            }
        }
    }

    // 게임 재시작 여부 질의
    public void askRestart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restart = Console.readLine();
        if(restart.equals("1")) {
            doGame();
        }
    }
}

/*플레이어
답을 맞추기 위한 값 입력*/
class Player{
    List<Integer> playerAnswer = new ArrayList<>();

    int ballCount = 0;
    int strikeCount = 0;

    // get user's input
    public void getUserInput() throws IllegalArgumentException{
        String userGuessingNumber = Console.readLine();
        if(userGuessingNumber.length()!=3)
            throw new IllegalArgumentException();
        pushGuessingNumber(userGuessingNumber);
    }
    //  push user's input number to player obj
    public void pushGuessingNumber(String userGuessingNumber){
        for(int i=0;i<userGuessingNumber.length();i++){
            playerAnswer.add(userGuessingNumber.charAt(i)-'0');
        }
    }
}

// 컴퓨터
// 볼게임을 위한 정답 생성
class Computer{
    List<Integer> computerAnswer = new ArrayList<>();

    // generate answer using random num
    public void generateAnswer(){
        while(computerAnswer.size() < 3){
            int number = Randoms.pickNumberInRange(1, 9);
            if(!computerAnswer.contains(number)){
                computerAnswer.add(number);
            }
        }
    }
}