package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

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
        // 매 게임마다의 시작 여부 결정 변수
        int playMode = 1; // 맨 처음에는 자동으로 게임 시작

        while(playMode == 1) {
            // 컴퓨터 정답 생성
            computer = setComputerAnswer(computer);

            // 게임 시작 - 입력받는 루프 돌 예정
            playBaseballGame();
        }
    }

    List<Integer> setComputerAnswer(List<Integer> computer) {
        // 컴퓨터 리스트의 내용물 비운다.
        computer.clear();

        // 랜덤 값 받을 정수 선언
        int randomNumber;

        // 크기가 3이 될 때까지
        while(computer.size() < 3) {
            randomNumber = pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    void playBaseballGame() {
        System.out.print("숫자 야구 게임을 시작합니다\n");

        // 입력받을 변수
        String input;

        // 정답을 다 맞출 때까지 무한 루프를 돈다.
        while(true) {
            // 세 자리 숫자로 된 문자열을 입력받기
            input = readLine();

            // 입력값 규정 준수 여부 처리
            user = checkGameUserInput(input, user);
            List<Integer> result = checkBallsAndStrikes();

            break;
        }
        // 만약 3개의 숫자를 다 맞췄다면 : while 루프를 break
        System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
    }

    List<Integer> checkGameUserInput(String input, List<Integer> user) {
        // implement
        throwExceptionIfNeeded(input.length() == maxLen, "입력값의 길이가 조건에 일치하지 않습니다.");

        char c;
        user.clear();
        for(int i = 0; i < 3; ++i) {
            c = input.charAt(i);
            // c의 범위는 1 ~ 9여야 한다.
            throwExceptionIfNeeded(c >= 49 && c <= 57, "입력값의 범위가 조건에 일치하지 않습니다.");
            // 서로 다른 세 수여야만 한다.
            throwExceptionIfNeeded(!user.contains(c-48), "입력값들 중 중복된 값이 있습니다.");
            user.add(c - 48); // char c to int
        }
        return user;
    }

    // Exception Throwing function
    void throwExceptionIfNeeded(boolean status, String message) {
        if(status == false) {
            throw new IllegalArgumentException(message);
        }
    }

    List<Integer> checkBallsAndStrikes() {
        List<Integer> result = new ArrayList<>();

        int balls = 0;
        int strikes = 0;

        // implement

        return result;
    }
}