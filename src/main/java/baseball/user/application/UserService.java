package baseball.user.application;

import baseball.game.application.MessageService;
import baseball.game.domain.repository.GameRepository;
import baseball.user.domain.User;
import baseball.user.domain.repository.UserRepository;
import baseball.user.support.Parser;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class UserService {
    private static final UserService instance=new UserService();
    private final int CONTINUE_INPUT_SIZE=1;
    private final Parser parser=new Parser();
    private final GameRepository gameRepository;
    private final UserRepository userRepository;
    private final MessageService messageService;
    private UserService(){
        gameRepository=GameRepository.getInstance();
        messageService=MessageService.getInstance();
        userRepository=UserRepository.getInstance();
    }
    public static UserService getInstance(){
        return instance;
    }

    public void createUser(){
        userRepository.createUser(new User());
    }
    public void inputData(){
        messageService.inputMessage();
        gameRepository.getGame().initCount();
        userRepository.getUser().updateInputNumber(parser.parseClientInput(Console.readLine()
                ,gameRepository.getSize()));
    }
    public List<Integer> inputContinue(){
        messageService.continueMessage();
        return parser.parseClientInput(Console.readLine(),CONTINUE_INPUT_SIZE);
    }
}
