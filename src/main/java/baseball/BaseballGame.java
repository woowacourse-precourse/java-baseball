package baseball;

public class BaseballGame {
    private CorrectAnswer answer;

    private boolean pitchIsNotCorrect(Pitch pitch){
        //answer과 비교하여 결과 출력 후 3스트라이크면 false 반환
        return false;
    }
    public void start() {
        //정답을 생성한다.
        answer = new CorrectAnswer();
        //반복(정답 시 탈출)
        Pitch pitch = new Pitch();
        //사용자에게 입력받고 Pitch 인스턴스를 생성한다.
        //입력을 받고 예외를 검사한다.

        //조건문 안에서 비교 후 같지 않다면 다시 pitch를 초기화한다.
        while (pitchIsNotCorrect(pitch)) {
            //입력을 다시 받는다.
        }

    }
}
