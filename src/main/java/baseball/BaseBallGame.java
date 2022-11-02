package baseball;

public class BaseBallGame {
    // TODO: 랜덤 수 생성
    // TODO: 입력받기
    // TODO: 숫자 비교
    public static int findStrike(String comNum, String myNum) {
        int strikeCnt=0;
        for(int i=0; i<comNum.length(); i++){
            if(myNum.charAt(i)==comNum.charAt(i)){
                strikeCnt +=1;
            }
        }
        return strikeCnt;
    }
}
