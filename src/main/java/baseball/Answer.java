package baseball;

import java.util.List;

public class Answer {

    public static boolean compareAnswer(List<Integer> computer, List<Integer> user){
        int strikeCount =0;
        int ballCount = 0;

        for(int i =0;i<3;i++){
            eachCompare(computer, user.get(i), i, strikeCount, ballCount);
        }

        System.out.print(strikeCount +" "+ ballCount);

        return false;
    }

    public static void eachCompare(List<Integer> computer, int userNumber, int userIndex, int strikeCount, int ballCount){
        for(int j = 0;j<3;j++){
            if(checkStrike(computer.get(j), userNumber, userIndex, j) ){
                strikeCount ++;
                continue;
            }

            if(checkBall(computer.get(j), userNumber) ) ballCount ++;

        }
    }

    public static boolean checkStrike(int computerNumber, int userNumber, int computerIndex, int userIndex){
        if(computerNumber == userNumber && computerIndex == userIndex) return true;
        return false;
    }

    public static boolean checkBall(int computerNumber, int userNumber){
        if(computerNumber == userNumber) return true;
        return false;
    }
}
