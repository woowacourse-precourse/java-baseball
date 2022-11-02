package baseball;

public class Application {

    public static void main(String[] args) {
        // TODO: 랜덤 수 생성
        String comNum = "713";
        // TODO: 사용자 수 입력
        String myNum = "213";
        // TODO: 게임 시작
        BaseBallGame baseBallGame = new BaseBallGame();
        int strike = baseBallGame.findStrike(comNum, myNum);
        // TODO: 결과 출력
        // TODO: 게임 종료, 재시작 or 종료
        testPrint(strike, 0);

    }
    private static void testPrint(int strikeCnt, int bollCnt){
        System.out.println("스트라이크: "+strikeCnt);
    }

}
