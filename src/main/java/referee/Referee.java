package referee;

import java.util.*;

public class Referee {
    private int[] score; // 볼, 스트라이크 정보를 저장(0: 볼의 수, 1: 스트라이크의 수)

    public Referee() {
        this.score = new int[2];
    }

    /*
    * 정답(answer)과 사용자 입력(expected)을 비교하여 판정함
    * score[0]: 볼의 수, score[1]: 스트라이크의 수
    */
    public boolean decision(String expected, String answer) {
        List<Character> expectedDigits = new ArrayList<>(3); // 사용자가 입력한 수의 각 자릿수 저장
        List<Character> answerDigits = new ArrayList<>(3);   // 정답의 각 자릿수 저장

        for(int i=0 ; i<3 ; i++) {
            expectedDigits.add(expected.charAt(i));
            answerDigits.add(answer.charAt(i));
        }

        cleanScore(); // score를 업데이트 하기 전 완전히 초기화 함
        for(int i=0 ; i<3 ; i++) {
            if(expectedDigits.get(i) == answerDigits.get(i)) {
                score[1]++;
            } else if(answerDigits.contains(expectedDigits.get(i))) {
                score[0]++;
            }
        }

        return (score[1] == 3);
    }

    /*
    * 판정 내용을 문자열로 구성하여 반환
    */
    public String buildDecisionString() {
        StringBuilder sb = new StringBuilder();

        if(score[0] == 0 && score[1] == 0) {
            sb.append("낫싱");
        } else if(score[1] == 3) {
            sb.append("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else {
            if(score[0] > 0) {
                sb.append(score[0]).append("볼 ");
            }
            if(score[1] > 0) {
                sb.append(score[1]).append("스트라이크");
            }
        }
        cleanScore(); // 재사용을 위해 값을 비움
        return sb.toString();
    }

    /*
    * 판정 정보를 저장하는 score 배열을 초기화 (모두 0으로)
    */
    private void cleanScore() {
        Arrays.fill(this.score, 0);
    }
}
