package baseball;

public class Application {
    public static void main(String... args) {
        // TODO: 프로그램 구현


        System.out.println("숫자 야구 게임을 시작합니다.");

        // 컴퓨터는 1부터 9까지 중복되지 않는 임의의 숫자를 3개를 받는다.
        Computer computer = new Computer();
        computer.createComputerRandomNumber();

        boolean playBaseBall = true;
        boolean restart = false;


        // 야구 게임 시작
        while (playBaseBall) {

            if (restart) {
                computer = new Computer();
                computer.createComputerRandomNumber();
            }

            restart = false;

            int userChoice = 0;
            int strikeCount = 0;
            int ballCount = 0;

            System.out.print("숫자를 입력해주세요 : ");

            // 사용자의 번호를 받고 규칙을 위반하는지 확인
            UserRead userNumber = new UserRead();
            userNumber.UserReadCheck();
            int userRead = userNumber.userNumber();

            UserNumbers user = new UserNumbers();
            user.userNumbers(userRead);

            // 숫자 야구 게임의 룰을 선언
            Rule baseBallRule = new Rule();

            // 스트라이크, 볼, 헛스윙 룰 적용
            baseBallRule.strikeRule(computer.computerNumbers, user.userNumbers);
            baseBallRule.ballRule(computer.computerNumbers, user.userNumbers);

            // 스트라이크, 볼, 헛스윙 카운트 선언
            strikeCount = baseBallRule.strike;
            ballCount = baseBallRule.ball;

            // 카운트된 메시지 출력
            CountMessage countMessage = new CountMessage();
            countMessage.message(strikeCount, ballCount);

            // 게임 승리시 메시지 출력
            if (strikeCount == 3) {
                WinMessage win = new WinMessage();
                win.win();
            }

            // 게임 진행 여부 확인
            if (strikeCount == 3) {
                ChoiceGame userChoiceGame = new ChoiceGame();
                userChoiceGame.userChoiceCheck();
                userChoice = userChoiceGame.chocieGame();
            }

            if (userChoice == 1) {
                restart = true;
            }

            if (userChoice == 2) {
                playBaseBall = false;
            }

        }

    }

}
