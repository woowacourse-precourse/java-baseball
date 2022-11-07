package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    static int computer;
    static int strike;
    static int ball;
    static int reGame;

    public static void process(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer = randomNumberBall();
        while(true){
            gamePlay();
            if(reGame==2){
                System.out.println("게임 종료");
                break;
            }
        }
    }

    public static void gamePlay(){
        System.out.println("computer : " + computer);
        System.out.print("숫자를 입력해주세요 : ");
        String user = Console.readLine();
        if(ErrorCheck.isValidLength(user) && ErrorCheck.isValidDiffer(user) && ErrorCheck.isValidNumber(user)){
            checkStrike(user);
            checkBall(user);
        }

        if(strike==3){
            System.out.println("3스트라이크");
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. : ");
            reGame = Integer.parseInt(Console.readLine());
            if(reGame==1){
                computer = randomNumberBall();
            }
        }else if(strike==0 && ball==0){
            System.out.println("낫싱");
        }else{
            if(ball==0){
                System.out.println(strike + "스트라이크");
            }else if(strike==0){
                System.out.println(ball + "볼");
            }else{
                System.out.println(ball + "볼 " + strike + "스트라이크");
            }
        }
    }

    public static void checkBall(String user){
        int ballCnt = 0;
        char[] userNumber = user.toCharArray();
        char[] computerNumber = Integer.toString(computer).toCharArray();

        if(userNumber[0]==computerNumber[1] || userNumber[0]==computerNumber[2]) ballCnt++;
        if(userNumber[1]==computerNumber[0] || userNumber[1]==computerNumber[2]) ballCnt++;
        if(userNumber[2]==computerNumber[0] || userNumber[2]==computerNumber[1]) ballCnt++;

        ball = ballCnt;
    }

    public static void checkStrike(String user){
        int strikeCnt = 0;
        char[] userNumber = user.toCharArray();
        char[] computerNumber = Integer.toString(computer).toCharArray();

        for(int i=0; i<userNumber.length; i++){
            if(userNumber[i] == computerNumber[i]){
                strikeCnt++;
            }
        }
        strike = strikeCnt;
    }

    public static int randomNumberBall(){
        List<Integer> computer = new ArrayList<>();

        while(computer.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer.get(0)*100 + computer.get(1)*10 + computer.get(2);
    }
}
