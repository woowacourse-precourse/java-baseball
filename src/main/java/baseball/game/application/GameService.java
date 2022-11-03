package baseball.game.application;

import baseball.game.domain.repository.GameRepository;
import baseball.user.application.UserService;
import baseball.user.domain.User;
import java.util.List;
import java.util.Objects;

public class GameService {
    private static final GameService instance=new GameService();
    private final GameRepository gameRepository;
    private final MessageService messageService;
    private final UserService userService;
    private GameService(){
        gameRepository=GameRepository.getInstance();
        messageService=MessageService.getInstance();
        userService=UserService.getInstance();
    }
    public static GameService getInstance(){
        return instance;
    }
    public void setGame(){
        gameRepository.setGame();
    }
    public void playGame(){
        User user=new User();
        messageService.gameStartMessage();
        while (gameRepository.getGame().getStrikeCount()!=3){
            play(user);
        }
    }
    private void play(User user){
        messageService.inputMessage();
        gameRepository.getGame().initCount();
        userService.inputData(user);
        containNumber(user.getInputNumber(),gameRepository.getGame().getGameNumber().getRandomNumber());

    }
    private void containNumber(List<Integer> inputData,List<Integer> randomNumber){
        for (Integer inputDatum : inputData) {
            if (randomNumber.contains(inputDatum))
                strikeAndBallCount(randomNumber, inputDatum);
        }
    }
    private void strikeAndBallCount(List<Integer> randomNumber,Integer containNumber){
        for(Integer randomNum:randomNumber){
            if(Objects.equals(randomNum, containNumber)){
                gameRepository.getGame().updateStrikeCount();
                return;
            }
        }
        gameRepository.getGame().updateBallCount();
    }
}
