package baseball.game.application;

import baseball.game.domain.Game;
import baseball.game.domain.repository.GameRepository;
import baseball.game.support.Parser;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Objects;
public class GameService {
    private static final GameService instance = new GameService();
    private final int CONTINUE=1;
    private final int CONTINUE_INPUT_SIZE=1;
    private final GameRepository gameRepository;
    private final MessageService messageService;
    private final Parser parser;
    private GameService() {
        gameRepository = GameRepository.getInstance();
        messageService = MessageService.getInstance();
        parser=new Parser();
    }
    public static GameService getInstance() {
        return instance;
    }
    public void run(){
        messageService.gameStartMessage();
    }
    public void play() {
        Game game=startGameSet();
        while (!Objects.equals(game.getStrikeCount(), gameRepository.getSize())) {
            List<Integer> clientInputData=inputData();
            countResult(clientInputData,game.getGameNumber());
            messageService.resultMessage(game.getStrikeCount(),game.getBallCount());
        }
        endGame();
    }
    private Game startGameSet(){
        gameRepository.setGame();
        return gameRepository.getGame();
    }
    private void endGame(){
        messageService.gameEndMessage();
        checkContinue(inputContinue());
    }
    private void countResult(List<Integer> inputData, List<Integer> randomNumber){
        for (int i=0;i<inputData.size();i++) {
            if (randomNumber.contains(inputData.get(i)))
                strikeAndBallCount(randomNumber.get(i), inputData.get(i));
        }
    }
    private void strikeAndBallCount(Integer randomNumber,Integer containNumber){
        if(Objects.equals(randomNumber, containNumber)){
            gameRepository.getGame().updateStrikeCount();
            return;
        }
        gameRepository.getGame().updateBallCount();
    }
    private void checkContinue(List<Integer> continueInput){
        if(continueInput.contains(CONTINUE)){
            play();
        }
    }
    public List<Integer> inputData(){
        messageService.inputMessage();
        gameRepository.initCount();
        return parser.parseClientInput(Console.readLine(),gameRepository.getSize());
    }
    public List<Integer> inputContinue(){
        messageService.continueMessage();
        return parser.parseClientInput(Console.readLine(),CONTINUE_INPUT_SIZE);
    }
}

