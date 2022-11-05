package baseball.user.application;

import baseball.game.application.MessageService;
import baseball.game.domain.repository.GameRepository;
import baseball.user.domain.repository.UserRepository;
import baseball.user.support.Parser;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Objects;

public class UserService {
    private static final UserService instance=new UserService();
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
    public void play(){
        messageService.inputMessage();
        gameRepository.getGame().initCount();
        inputData();
        containNumber(userRepository.getUser().getInputNumber(),gameRepository.getGame().getGameNumber().getRandomNumber());
    }
    private void containNumber(List<Integer> inputData, List<Integer> randomNumber){
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
    public void inputData(){
        userRepository.getUser().updateInputNumber(parser.parseClientInput(Console.readLine()
                ,gameRepository.getSize()));
    }
}
