package baseball;

public class Application {
    static String comNum = "713";
    static String myNum = "213";
    public static void main(String[] args) {
        // TODO: 게임 시작
        // TODO: 랜덤 수 생성
        // TODO: 입력받기
        // TODO: 숫자 비교
        int strike = findStrike();
        // TODO: 결과 출력
        // TODO: 게임 종료, 재시작 or 종료
        testPrint(strike, 0);

    }
    private static void testPrint(int strikeCnt, int bollCnt){
        System.out.println("스트라이크: "+strikeCnt);
    }
    private static int findStrike() {
        int strikeCnt=0;
        for(int i=0; i<comNum.length(); i++){
            if(myNum.charAt(i)==comNum.charAt(i)){
                strikeCnt +=1;
            }
        }
        return strikeCnt;
    }
}
