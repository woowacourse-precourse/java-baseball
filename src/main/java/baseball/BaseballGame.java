package baseball;

public class BaseballGame {
    private CorrectAnswer answer;

    /**
     * 생성된 랜덤 문자열과 사용자가 입력한 pitch 인스턴스를 비교하여
     * 결과를 출력하고 3스트라이크가 아니라면 true를 반환합니다.
     * @param pitch 사용자가 입력한 값
     * @return true 스트라이크가 3개 미만일 때 false 스트라이크가 3개일 때
     * */
    private boolean pitchIsNotCorrect(Pitch pitch){
        //answer과 비교하여 결과 출력 후 3스트라이크면 false 반환
        return false;
    }

    /**
     * 게임 시작.
     * 새로운 랜덤 숫자를 생성하고
     * 사용자에게 입력받아 저장하는 Pitch 인스턴스를 추가합니다.
     * 이후 while문에서 pitchIsNotCorrect(Pitch pitch) 함수를 통해 3스트라이크가 아닐 시
     * pitch 인스턴스를 재 생성합니다.
     * */
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
