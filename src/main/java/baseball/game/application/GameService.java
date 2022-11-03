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
        System.out.println(gameRepository.getGame().getGameNumber().getRandomNumber());
        User user=new User();
        messageService.gameStartMessage();
        while (gameRepository.getGame().getStrikeCount()!=3){
            play(user);
        }
        messageService.gameEndMessage();
        messageService.continueMessage();
    }
    private void play(User user){
        messageService.inputMessage();
        gameRepository.getGame().initCount();
        userService.inputData(user);
        containNumber(user.getInputNumber(),gameRepository.getGame().getGameNumber().getRandomNumber());
    }
    private void containNumber(List<Integer> inputData,List<Integer> randomNumber){
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
}
