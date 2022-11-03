package baseball.game.application;

import baseball.game.domain.repository.GameRepository;
import baseball.game.support.Parser;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameService {
    private static final GameService instance=new GameService();
    private final GameRepository gameRepository;
    private final MessageService messageService;
    private final Parser parser=new Parser();
    private GameService(){
        gameRepository=GameRepository.getInstance();
        messageService=MessageService.getInstance();
    }
    public static GameService getInstance(){
        return instance;
    }
    public void setGame(){
        gameRepository.setGame();
    }
    public void playGame(){
        messageService.gameStartMessage();
        while (gameRepository.getGame().getStrikeCount()!=3){
            play();
        }
    }
    private void play(){
        messageService.inputMessage();
        List<Integer> inputData=input();
    }
    private List<Integer> input(){
        String input= Console.readLine();
        return parser.parseClientInput(input,gameRepository.getSize());
    }
}
