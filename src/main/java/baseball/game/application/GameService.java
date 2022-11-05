package baseball.game.application;

import baseball.game.domain.repository.GameRepository;
import baseball.user.application.UserService;
import baseball.user.domain.repository.UserRepository;

import java.util.List;
import java.util.Objects;
public class GameService {
    private static final GameService instance = new GameService();
    private final int CONTINUE=1;
    private final GameRepository gameRepository;
    private final UserRepository userRepository;
    private final MessageService messageService;
    private final UserService userService;
    private GameService() {
        gameRepository = GameRepository.getInstance();
        userRepository=UserRepository.getInstance();
        messageService = MessageService.getInstance();
        userService = UserService.getInstance();
    }
    public static GameService getInstance() {
        return instance;
    }
    public void run(){
        messageService.gameStartMessage();
    }
    public void play() {
        gameRepository.setGame();
        userService.createUser();
        while (!Objects.equals(gameRepository.getGame().getStrikeCount(), gameRepository.getSize())) {
            userService.inputData();
            countResult(userRepository.getUser().getInputNumber()
                    ,gameRepository.getGame().getGameNumber().getRandomNumber());
            messageService.resultMessage(gameRepository.getGame().getStrikeCount(), gameRepository.getGame().getBallCount());
        }
        messageService.gameEndMessage();
        checkContinue(userService.inputContinue());
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
}

