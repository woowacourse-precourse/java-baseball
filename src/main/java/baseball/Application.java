package baseball;

public class Application {
    public static void main(String[] args) {
        // 게임 객체안에 값을 넣어 인스턴스화
        NumberBaseballGame numberBaseballGame = new NumberBaseballGame();
        CheckingValidArgument checkingValidArgument = new CheckingValidArgument();

        // 게임 Start
        numberBaseballGame.StartGame();
        // 게임을 또 진행할 것인지를 확인하기.
        int ContinueGame = numberBaseballGame.getContinueGame();

        while (ContinueGame == 1) {
            // 숫자 입력
            String number = numberBaseballGame.inputNumber();

            // 예외 처리 1 : 입력된 값이 옳바른 숫자가 맞는가?
            checkingValidArgument.TrueNumber(number);
            // 예외 처리 2 : 입력값이 세자리인가?
            checkingValidArgument.MaxRangeNumber(number);
            // 예외 처리 3 : 입력값이 중복되지 않는가?
            // checkingValidArgument.DuplicNumber(number);

            // 입력한 숫자를 기반으로 User에게 힌트주기
            numberBaseballGame.CountResults();
            // 게임 결과(낫싱, 볼 스트라이크) 출력하기
            numberBaseballGame.PrintResult();
            // 게임 종료후 게임 지속할 것인지 물어보기
            ContinueGame = numberBaseballGame.getContinueGame();
        }
    }
}