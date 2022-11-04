package baseball;

public class BallCount {


    public static int strikeCount(int[] answer,String input) {
        int strikeCnt = 0;

        int firInt = input.charAt(0) - '0';
        int sndInt = input.charAt(1) - '0';
        int trdInt = input.charAt(2) - '0';

        if(answer[0] == firInt) strikeCnt++;
        if(answer[1] == sndInt) strikeCnt++;
        if(answer[2] == trdInt) strikeCnt++;

        return strikeCnt;
    }

    public static int ballCount(int[] answer, String input) {
        int ballCnt = 0;

        int firInt = input.charAt(0) - '0';
        int sndInt = input.charAt(1) - '0';
        int trdInt = input.charAt(2) - '0';

        if(answer[0] == sndInt || answer[0] == trdInt) ballCnt++;
        if(answer[1] == firInt || answer[1] == trdInt) ballCnt++;
        if(answer[2] == firInt || answer[2] == sndInt) ballCnt++;

        return ballCnt;
    }
}
