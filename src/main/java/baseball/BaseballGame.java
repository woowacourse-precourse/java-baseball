package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    static int computer;
    static int strike;
    static int ball;

    public static void process(){
        System.out.println("게임을 시작합니다.");
        computer = randomNumberBall();
        System.out.println(computer);
        while(true){
            gamePlay();
            break;
        }
    }

    public static void gamePlay(){
        System.out.print("숫자를 입력하세요 : ");
        String user = Console.readLine();
        if(ErrorCheck.isValidLength(user) && ErrorCheck.isValidDiffer(user) && ErrorCheck.isValidNumber(user)){
            System.out.println(Integer.parseInt(user));
            System.out.println("올바른 값이 입력되었습니다.");

            checkStrike(user);
            System.out.println("strike : " + strike);
            checkBall(user);
            System.out.println("ball : " + ball);
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
