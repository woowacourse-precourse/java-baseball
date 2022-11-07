package baseball;

public class BaseballGame {
    private CorrectAnswer answer;


    /**
     * 생성된 랜덤 문자열과 사용자가 입력한 pitch 인스턴스를 비교하여 결과를 출력하고 3스트라이크가 아니라면 true를 반환합니다.
     *
     * @param pitch 사용자가 입력한 값
     * @return true 스트라이크가 3개 미만일 때 false 스트라이크가 3개일 때
     */
    private boolean pitchIsNotCorrect(Pitch pitch) {
        int strike = 0, ball = 0;
        for (int i = 0; i < 3; i++) {
            PitchResult result = answer.batPitchedBall(pitch.getNumber(i), i);
            if (result == PitchResult.BALL) {
                ball++;
            }
            if (result == PitchResult.STRIKE) {
                strike++;
            }
        }
        printResult(ball, strike);
        return strike != 3;
    }

    /**
     * 결과를 출력합니다.
     *
     * @param ball   볼 수
     * @param strike 스트라이크 수
     */
    private void printResult(int ball, int strike) {
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크");
        }
        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        }
    }

    /**
     * 게임 시작. 새로운 랜덤 숫자를 생성하고 사용자에게 입력받아 저장하는 Pitch 인스턴스를 추가합니다. 이후 while문에서 pitchIsNotCorrect(Pitch pitch) 함수를 통해
     * 3스트라이크가 아닐 시 pitch 인스턴스를 재 생성합니다.
     */
    public void start() {
        answer = new CorrectAnswer();
        Pitch pitch = new Pitch();

        while (pitchIsNotCorrect(pitch)) {
            pitch = new Pitch();
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
