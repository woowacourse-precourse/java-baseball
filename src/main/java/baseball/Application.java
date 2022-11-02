package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    static BaseBallGame baseBallGame;
    static InputHandler inputHandler;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        // TODO: 랜덤 수 생성
        String comNum = "713";
        // TODO: 사용자 수 입력 - 도메인테스트
        inputHandler = new InputHandler();
        String myNum =  inputHandler.getInput_returnMyNum();

        // TODO: 게임 시작
        baseBallGame = new BaseBallGame();
        int strike = baseBallGame.findStrike(comNum, myNum);
        int boll = baseBallGame.findBoll(comNum, myNum);
        // TODO: 결과 출력
        // TODO: 게임 종료, 재시작 or 종료
        testPrint(strike, boll);

    }
    private static void testPrint(int strikeCnt, int bollCnt){

        System.out.println("스트라이크: "+strikeCnt);
        System.out.println("볼 : "+bollCnt);
    }

}
