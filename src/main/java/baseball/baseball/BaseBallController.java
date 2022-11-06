package baseball.baseball;

import baseball.ScreenString;
import baseball.dto.BaseBallGameInput;
import baseball.dto.BaseBallGameOutput;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseBallController {

    private BaseBallService baseBallService;
    private int doNextGame = 1;

    public BaseBallController() {
        this.baseBallService = new BaseBallService();
    }

    public void gameFlow(){
        startGame();

        while(doNextGame == 1){
            String randomNumber = makeRandomNumber();
            String guessNumber = makeGuessNumber();

            BaseBallGameInput baseBallGameInput = new BaseBallGameInput(randomNumber, guessNumber);
            BaseBallGameOutput baseBallGameOutput = baseBallService.playBall(baseBallGameInput);

            int ballCount = baseBallGameOutput.getBallCount();
            int strikeCount = baseBallGameOutput.getStrikeCount();

            doNextGame = endGame();
        }
    }

    private String makeGuessNumber() throws IllegalArgumentException{
        String userInput = Console.readLine();

        if(!is3Number(userInput)){
            throw new IllegalArgumentException();
        }else {
            return userInput;
        }
    }

    protected boolean is3Number(String userInput) {
        boolean is3Number = true;
        if(userInput.length() != 3)
            is3Number = false;
        for(int i=0;i<3;i++){
            char temp = userInput.charAt(i);
            if(temp < '0' || temp > '9'){
                is3Number = false;
            }
        }
        return is3Number;
    }

    protected String makeRandomNumber() {
        List<String> computerInput = new ArrayList<>();
        while (computerInput.size() < 3) {
            String randomNumber = Integer.toString(Randoms.pickNumberInRange(1, 9));
            if (!computerInput.contains(randomNumber)) {
                computerInput.add(randomNumber);
            }
        }
        return String.join("", computerInput);
    }

    private int endGame() {

        return Integer.parseInt(Console.readLine());
    }

    private void startGame() {
        System.out.println(ScreenString.GAME_START.getCommonMessage());
    }
}
