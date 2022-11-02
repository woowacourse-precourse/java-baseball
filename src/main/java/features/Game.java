package features;

public class Game {

    private static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final int STRIKE = 3;

    // 입력 기능을 실행한다.
    input();

    // 게임 진행 기능
    while(STRIKE==false){
        hint();
        print();
        runGame();
    }

    // 게임 종료 기능
    if(STRIKE==true){
        victory();
        return  "게임을 재시작하려면 1, 종료하려면 2를 입력해주세요.";
    }
}