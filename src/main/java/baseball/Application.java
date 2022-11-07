package baseball;

/*
기능
- 서로 다른 임의의 수 3개 선택 : Random()라이브러리 사용
- 같은 수가 같은 자리: 스트라이크, 같은 수가 다른 자리: 볼, 다 틀림: 낫싱
- 잘못된 값 입력 시 IllegalArgumentException
조건
- 서로 다른 3자리 수
- 게임이 끝난 경우 1:재시작, 2:종료
 */

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while (true) {
            Baseball baseball = new Baseball();
            while (!baseball.run()) ;
        }
    }
}
