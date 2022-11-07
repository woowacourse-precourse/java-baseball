package baseball;
import camp.nextstep.edu.missionutils.Console;

import java.util.Map;

public class BaseBallView {
    private int numberLength = 3;

    private BaseBallController baseBallController = new BaseBallController(numberLength);

    public void startGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        baseBallController.startGame();
        boolean flag = true;
        while(flag){
            try{
                flag = playGame();

            }
            catch(IllegalArgumentException ex){
                System.out.println("비정상적인 입력입니다. 게임을 종료합니다.");
                throw ex;
//                return;
            }

        }

        System.out.println("게임을 종료합니다.");

    }

    public boolean playGame() throws IllegalArgumentException{
        System.out.print("숫자를 입력해주세요 : ");
        String inputNumbers = Console.readLine();
        boolean restartGame = true;
        String resultString = null;
        Map<String, Integer> result;

        try {
            result = baseBallController.playGame(inputNumbers);

        }
        catch(IllegalArgumentException ex){
            throw ex;
        }

        int strikeCount = result.get("strike");
        int ballCount = result.get("ball");

        if(ballCount > 0){
            resultString = String.format("%d볼", ballCount);
            if(strikeCount > 0){
                resultString += String.format(" %d스트라이크", strikeCount);
            }
        }
        else if(strikeCount > 0){
            resultString = String.format("%d스트라이크", strikeCount);
        }
        else{
            resultString = "낫싱";
        }
        System.out.println(resultString);


        if(strikeCount == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            int flag = Integer.parseInt(Console.readLine());

            restartGame = baseBallController.restartGame(flag);
        }



        return restartGame;
    }

}
