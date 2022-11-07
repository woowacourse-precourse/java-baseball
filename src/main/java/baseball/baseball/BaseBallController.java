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

            while(userGuessing(randomNumber) == false){}

            doNextGame = endGame();
        }
    }

    private boolean userGuessing(String randomNumber) {

        String guessNumber = makeGuessNumber();

        BaseBallGameInput baseBallGameInput = new BaseBallGameInput(randomNumber, guessNumber);
        BaseBallGameOutput baseBallGameOutput = baseBallService.playBall(baseBallGameInput);

        int ballCount = baseBallGameOutput.getBallCount();
        int strikeCount = baseBallGameOutput.getStrikeCount();

        System.out.println(ScreenString.ballAndStrikeMessage(ballCount, strikeCount));

        if(strikeCount == 3) {
            return true;
        }else{
            return false;
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
        if(userInput.length() != 3)
            return false;
        for(int i=0;i<3;i++){
            char temp = userInput.charAt(i);
            if(!checkNumber(temp)){
                return false;
            }
        }
        return true;
    }

    private boolean checkNumber(char temp) {
        if(temp < '0' || temp > '9'){
            return false;
        }else {
            return true;
        }
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
        System.out.println(ScreenString.GAME_END.getCommonMessage());
        return Integer.parseInt(Console.readLine());
    }

    private void startGame() {
        System.out.println(ScreenString.GAME_START.getCommonMessage());
    }
}
