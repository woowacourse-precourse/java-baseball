package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

public class GameSystem {

    public static void startGame() {

        Computer computer = new Computer();
        User user = new User();
        Game game = new Game(computer, user);

        boolean win = false;

        try {
            //1. 게임 시작 문구 출력
            game.startGame();

            //2. 컴퓨터에 저장할 숫자를 제작
            computer.setRandomNumber();
            game.validateComputerNumber(computer.getNumber());

            while(true) {

                win = false;

                //3. 유저가 사용할 숫자를 입력받음
                java.lang.System.out.print("숫자를 입력해주세요: ");
                user.setNumber(Console.readLine());
                game.validateComputerNumber(user.getNumber());

                //4. 게임 결과를 받아온 뒤 출력
                String gameScoreMent = game.getScoreMent(computer.getNumber(), user.getNumber());
                java.lang.System.out.println(gameScoreMent);

                //5 게임 결과 확인
                if(!game.checkWinGame(gameScoreMent)) {
                    continue; // 6. 게임을 이긴 게 아니라면 다시 숫자 입력창으로 돌아감
                } else {
                    win = true;
                }

                if (win && game.restartGame(Console.readLine())) { // 7. 재시작 여부 확인
                    computer.setRandomNumber(); // 8. 재시작 시 컴퓨터 숫자를 초기화
                    game.validateComputerNumber(computer.getNumber());

                    continue;
                } else { // 9. 재시작을 안하면 프로그램 종료
                    return;
                }

            }

        } catch (IllegalArgumentException e) {
            throw e;
        }

    }
}
