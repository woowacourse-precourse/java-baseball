package baseball;

public class BaseBallGame {
    // TODO: 랜덤 수 생성
    // TODO: 입력받기
    // TODO: 숫자 비교
    static int strikeCnt = 0;
    static int ballCnt = 0 ;
    public static int findStrike(String comNum, String myNum) {
        for(int i=0; i<comNum.length(); i++){
            if(myNum.charAt(i)==comNum.charAt(i)){
                strikeCnt +=1;
            }
        }
        return strikeCnt;
    }

    public int findBoll(String comNum, String myNum) {
        for(int i=0; i<comNum.length(); i++){
            if(myNum.contains(comNum.substring(i, i+1))){
                ballCnt +=1;
            }
        }
        if(strikeCnt ==0) return ballCnt;
        else return ballCnt - strikeCnt;
    }
}
