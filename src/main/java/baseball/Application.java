package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> correctAnswer = Start.startGame(); // 컴퓨터 정답

        while (true) {
            UserInput userInput = new UserInput();
            String readLine = userInput.input(); // 유저 입력 값

            ExceptionCheck check = new ExceptionCheck(); // 아래 verification 메서드는 검증 메서드
            check.verificationLength(readLine); // 길이 검증
            check.verificationInputZero(readLine); // 0 입력 했는지
            check.verificationCharDetect(readLine); // 문자 입력 했는지
            check.verificationDuplicated(readLine); // 중복된 값이 들어왔는지

            List<Integer> slicedInput = userInput.sliceInput(readLine); // 비교를 위해 리스트로 잘라서 인덱스에 삽입

            NumberComparison comparison = new NumberComparison();
            int ballCount = comparison.checkBall(correctAnswer, slicedInput); // 정답과 유저 입력 값을 비교해서 ballCount 구함
            int strikeCount = comparison.checkStrike(correctAnswer, slicedInput); // 정답과 유저 입력 값을 비교해서 strikeCount 구함

            GameBranch gameBranch = new GameBranch();
            int gameStatus = gameBranch.status(ballCount, strikeCount); // 각 Count가 들어가서 검증
            // -1이 넘어오면 다시 반복문 처음으로

            if (gameStatus == -2) { // -2가 넘어오면 게임 다시 시작 (strikeCount가 3일 때만 반환될 수 있음.)
                correctAnswer = Start.reStart();
            } else if (gameStatus == -3) { // -3이 넘어오면 프로그램 종료 (strikeCount가 3일 때만 반환될 수 있음.)
                break;
            }
        }
    }
}
