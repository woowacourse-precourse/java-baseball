package baseball;

public class Game {
    /*
     - 요구 사항:
     1~9까지 서로 다른 수로 이뤄진 3자리 수를 맞추는 게임

     - 규칙 :
     < 같은 수 >
     1) 같은 수가 같은 자리에 있으면 스트라이크
     2) 같은 수가 다른 자리에 있으면 볼
     3) 같은 수가 전혀 없으면 낫싱이란 힌트 얻음

     - 과정 :
     1) 컴퓨터는 1~9까지 서로 다른 임의의 수 3개를 선택
     2) 플레이어는 컴퓨터가 생각하는 서로 다른 3개의 숫자 입력
     3) 컴퓨터는 입력에 대한 결과 출력
     4) 이 과정을 반복해 3개의 숫자를 모두 맞히면 게임 종료
     5) 게임 종료 후엔 다시 시작하거나 완전히 종료 가능 ( 1:재시작 2:종료 )

     * 사용자가 잘못된 값을 입력하면 IllegalArgumentException 예외 발생

    */

    String comp;
    int strikeCnt;
    int ballCnt;

    public Game(String comp) {
        this.comp = comp;
        this.strikeCnt = 0;
        this.ballCnt = 0;
    }

    public String 카운트확인(String input) {

        // 카운트 개수 파악
        strikeCnt = 스트라이크_확인(input);
        ballCnt = 볼_확인(input);

        // 판정
        if(strikeCnt == 3) return "3스트라이크";
        if(ballCnt == 3) return "3볼";
        else if((ballCnt == 0) && (strikeCnt == 0)) return "낫싱";
        else return (ballCnt + "볼 " + strikeCnt + "스트라이크");
    }

    public int 스트라이크_확인(String input) {
        int cnt = 0;
        if(input.equals(comp)) return 3;
        for (int i = 0; i < input.length(); i++) {
            if (comp.length() != input.length()) break;
            if (comp.charAt(i) == input.charAt(i)) cnt++;
        }
        return cnt;
    }

    public int 볼_확인(String input) {
        int cnt = 0;
        if(input.equals(comp)) return 3;
        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < comp.length(); j++) {
                if (comp.length() != input.length()) break;
                if (comp.charAt(i) != input.charAt(i)){
                    if (comp.charAt(i) == input.charAt(j)) cnt++;
                }
            }
            if(input.equals(comp)) cnt++;
        }
        return cnt;
    }

    public void clear() {
        this.strikeCnt = 0;
        this.ballCnt = 0;
    }
}
