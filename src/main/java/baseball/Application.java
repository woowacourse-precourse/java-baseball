package baseball;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 큰 틀 : 게임 클래스를 생성
        Game numberBaseball = new Game();
        // 게임 클래스 내에서 게임을 실행
        numberBaseball.init();
    }
}

class Game
{
    static int BALLS = 0; // 숫자 야구 게임 실행 후 볼 결과 탐색 위한 인덱스
    static int STRIKES = 1; // 숫자 야구 게임 실행 후 스트라이크 결과 탐색 위한 인덱스
    static int maxLen = 3; // 사용자 입력 및 컴퓨터 정답 배열이 가져야 할 항목 수
    List<Integer> computer; // 컴퓨터의 정답을 담게 될 리스트
    List<Integer> user; // 사용자의 입력값을 담게 될 리스트
    Game() { // 리스트 멤버변수의 생성자, 게임 작동을 위한 추가 기능 없음
        computer = new ArrayList<>();
        user = new ArrayList<>();
    }

    // 게임의 큰 틀, 혹은 흐름을 가지고 있는 함수
    void init()
    {

    }
}