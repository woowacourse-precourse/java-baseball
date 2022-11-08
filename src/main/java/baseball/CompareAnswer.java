package baseball;

import java.util.List;

import static baseball.Application.*;
import static baseball.Play.*;

public class CompareAnswer {

    public static boolean compareAnswer(List<Integer> computer, List<Integer> user){
        int[] strikeAndBallCount = new int[2];

        for(int i =0;i<3;i++)   eachCompare(computer, user.get(i), i, strikeAndBallCount);

        printAnswer(strikeAndBallCount);

        if(strikeAndBallCount[0] == 3) {
            setRestart();
            return true;
            }

        return false;
    }

    public static int[] eachCompare(List<Integer> computer, int userNumber, int userIndex, int[] strikeAndBallcount){
        for(int j = 0;j<3;j++){
            if(checkStrike(computer.get(j), userNumber, userIndex, j) ){
                strikeAndBallcount[0] ++;
                continue;
            }
            if(checkBall(computer.get(j), userNumber) ) strikeAndBallcount[1] ++;
        }

        return strikeAndBallcount;
    }

    public static boolean checkStrike(int computerNumber, int userNumber, int computerIndex, int userIndex){
        if(computerNumber == userNumber && computerIndex == userIndex) return true;
        return false;
    }

    public static boolean checkBall(int computerNumber, int userNumber){
        if(computerNumber == userNumber) return true;
        return false;
    }

    public static void printAnswer(int[] strikeAndBallCount){
        if(strikeAndBallCount.length == 0) return;

        if(strikeAndBallCount[0] == 0 && strikeAndBallCount[1] ==0){
            System.out.println("낫싱");
            return ;
        }

        if(strikeAndBallCount[0] != 0 && strikeAndBallCount[1] != 0){
            System.out.println(strikeAndBallCount[1]+"볼 "+strikeAndBallCount[0]+"스트라이크");
            return ;
        }

        if(strikeAndBallCount[0] == 3 && strikeAndBallCount[1] == 0){
            System.out.println(strikeAndBallCount[0]+"스트라이크 \n"+"3개의 숫자를 모두 맞히셨습니다! 게임종료 \n");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return ;
        }
        if(strikeAndBallCount[0] != 0 && strikeAndBallCount[0] < 3 && strikeAndBallCount[1] == 0){
            System.out.println(strikeAndBallCount[0]+"스트라이크 \n");

            return ;
        }

        if(strikeAndBallCount[0] == 0 && strikeAndBallCount[1] != 0){
            System.out.println(strikeAndBallCount[1]+"볼");
            return ;
        }

        //System.out.println(strikeAndBallCount[0] +" "+ strikeAndBallCount[1]);
    }
}