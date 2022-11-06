package baseball.service;

import baseball.domain.Game;
import baseball.utils.RandomUtils;
import baseball.view.SystemMessage;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private List<Integer> answerList;
    private List<Integer> userList;
    public Game game = new Game();

    public GameService() {
        game.initGame();
    }
    public void retryGame(){
        game.initGame();
        startGame();
    }
    public void startGame() {
        SystemMessage.startGameMessage();
        answerList = RandomUtils.makeRandomList();
        while (game.getStrikeCount()<3) {
            game.initGame();
            getUserNumber();
            compareNumber();
        }
        SystemMessage.printEndMessage();
        askRetry();
    }

    public void getUserNumber() {
        SystemMessage.requestNumberMessage();
        String userString = Console.readLine();
        userList = makeList(userString);
        System.out.println("유저: " + userList + ", 랜덤 숫자:" + answerList);
    }

    public List<Integer> makeList(String str) {
        List<Integer> returnList = new ArrayList<>();
        for (String s : str.split("")) {
            int tmpInteger = Integer.parseInt(s);
            returnList.add(tmpInteger);
        }
        return returnList;
    }

    public void compareNumber() {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).equals(answerList.get(i)))
                game.addStrikeCount();
            else if (answerList.contains(userList.get(i)))
                game.addBallCount();
        }
        SystemMessage.printResultMessage(game.getStrikeCount(), game.getBallCount());
    }

    public void askRetry(){
       SystemMessage.requestGameMessage();

       String responseStr=Console.readLine();
       int responseNumber=Integer.parseInt(responseStr);

       if(responseNumber==1)
           retryGame();
       else if(responseNumber==2)
           return;

    }
}
