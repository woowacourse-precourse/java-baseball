package baseball.game.application;

import baseball.game.domain.repository.GameRepository;
import baseball.user.application.UserService;

public class GameService {
    private static final GameService instance = new GameService();
    private final GameRepository gameRepository;
    private final MessageService messageService;
    private final UserService userService;
    private GameService() {
        gameRepository = GameRepository.getInstance();
        messageService = MessageService.getInstance();
        userService = UserService.getInstance();
    }
    public static GameService getInstance() {
        return instance;
    }
    public void setGame() {
        gameRepository.setGame();
    }
    public void playGame() {
        messageService.gameStartMessage();
        while (gameRepository.getGame().getStrikeCount() != 3) {
            userService.play();
            messageService.resultMessage(gameRepository.getGame().getStrikeCount(), gameRepository.getGame().getBallCount());
        }
        messageService.gameEndMessage();
        messageService.continueMessage();
    }
}

