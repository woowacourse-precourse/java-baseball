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

    public static int printBallCount(int[] answer, String inputValue) {
        // 스트라이크 및 볼 카운트 출력
        int ball = ballCount(answer, inputValue);
        int strike = strikeCount(answer, inputValue);

        if(ball == 0 && strike != 0) {
            System.out.println(strike + "스트라이크");
        }
        else if(ball != 0 && strike == 0) {
            System.out.println(ball + "볼");
        }
        else if(ball != 0 && strike != 0){
            System.out.println(ball+"볼 " + strike + "스트라이크");
        }
        else {
            System.out.println("낫싱");
        }

        return strike;
    }
}
