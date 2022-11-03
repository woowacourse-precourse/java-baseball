package baseball.user.application;

import baseball.game.domain.repository.GameRepository;
import baseball.user.support.Parser;
import baseball.user.domain.User;
import camp.nextstep.edu.missionutils.Console;

public class UserService {
    private static final UserService instance=new UserService();
    private final Parser parser=new Parser();
    private final GameRepository gameRepository;
    private UserService(){
        gameRepository=GameRepository.getInstance();
    }
    public static UserService getInstance(){
        return instance;
    }
    public void inputData(User user){
        user.updateInputNumber(parser.parseClientInput(Console.readLine()
                ,gameRepository.getSize()));
    }
}
