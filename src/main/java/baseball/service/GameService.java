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
    public Game game= new Game();

    public GameService(){
        game.initGame();

    }
    public void startGame(){
            answerList= RandomUtils.makeRandomList();
            getUserNumber();
    }
    public void getUserNumber(){
        SystemMessage.startGameMessage();
        String userString= Console.readLine();
        //추가적으로 맞는지 처리하기

        //문자열을 list로 바꾸기
        userList=makeList(userString);
    }

    public List<Integer> makeList(String str){
        List<Integer> returnList = new ArrayList<>();
        for(String s: str.split("")){
            int tmpInteger=Integer.parseInt(s);
            returnList.add(tmpInteger);
        }
        return returnList;
    }

}
