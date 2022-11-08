package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean gameRestartWhether = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (gameRestartWhether){
            startGame(new Game());
            gameRestartWhether = getGameRestartWhether();
        }
    }

    static void startGame(Game game){
        boolean gameWin = false;
        while (!gameWin){
            UserInputException userInputException = new UserInputException();
            System.out.print("숫자를 입력해주세요 : ");
            final String input = Console.readLine();
            if (userInputException.checkAllCondition(input)){
                List<Integer> result = new JudgePitchingResult().returnPitchingResult(input, game.getNumberList());
                gameWin = outputOfPitchingResult(result);
            }
            else {
                throw new IllegalArgumentException("");
            }
        }

    }

    static boolean getGameRestartWhether(){
        while (true){
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            final String input = Console.readLine();

            if (input.equals("1")){
                return true;
            }
            else if(input.equals("2")){
                return false;
            }
            else{
                System.out.println("입력값을 다시 확인해주세요.");
                continue;
            }
        }
    }

    static boolean outputOfPitchingResult(List<Integer> result){
        if (!(result.get(1) == 3)){
            if (result.get(0) == 0 && result.get(1) == 0 )
            System.out.println("낫싱");
            else if(result.get(0) == 0 && result.get(1) != 0){
                System.out.println(result.get(1) + "스트라이크");
            }
            else if(result.get(0) != 0 && result.get(1) == 0){
                System.out.println(result.get(0) + "볼");
            }
            else{
                System.out.println(result.get(0) + "볼 " + result.get(1) + "스트라이크");
            }
        }
        else{
            System.out.println(result.get(1) + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }
}
