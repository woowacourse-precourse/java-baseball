package baseball;

import java.util.List;

public class Answer {

    public static boolean compareAnswer(List<Integer> computer, List<Integer> user){
        int[] strikeAndBallCount = new int[2];

        for(int i =0;i<3;i++){
            eachCompare(computer, user.get(i), i, strikeAndBallCount);
        }

        System.out.print(strikeAndBallCount[0] +" "+ strikeAndBallCount[1]);

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
}
