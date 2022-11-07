package baseball.global.config;

import baseball.application.GameFacade;
import baseball.domain.ball.service.BallCreator;
import baseball.domain.ball.service.BallFactory;
import baseball.domain.ball.service.BallService;
import baseball.domain.ball.service.BallServiceImpl;
import baseball.domain.game.service.*;
import baseball.domain.hint.HintMessenger;
import baseball.infrastructure.ball.BallCreatorImpl;
import baseball.infrastructure.ball.BallFactoryImpl;
import baseball.infrastructure.game.GameMessengerImpl;
import baseball.infrastructure.game.GameRefereeImpl;
import baseball.infrastructure.game.GameValidatorImpl;
import baseball.infrastructure.hint.BallMessenger;
import baseball.infrastructure.hint.NothingMessenger;
import baseball.infrastructure.hint.StrikeAndBallMessenger;
import baseball.infrastructure.hint.StrikeMessenger;
import baseball.presentation.BaseBallGameController;

import java.util.List;

public class AppConfig {

    public BaseBallGameController gameController() {
        return new BaseBallGameController(gameFacade());
    }

    public GameFacade gameFacade() {
        return new GameFacade(ballService(), gameService());
    }

    public GameService gameService() {
        return new GameServiceImpl(gameMessenger(), gameValidator(), gameReferee());
    }

    public GameMessenger gameMessenger() {
        return new GameMessengerImpl(hintMessengers());
    }

    public GameValidator gameValidator() {
        return new GameValidatorImpl();
    }

    public GameReferee gameReferee() {
        return new GameRefereeImpl();
    }

    public BallService ballService() {
        return new BallServiceImpl(ballFactory(), ballCreator());
    }

    public BallFactory ballFactory() {
        return new BallFactoryImpl();
    }

    public BallCreator ballCreator() {
        return new BallCreatorImpl();
    }

    public List<HintMessenger> hintMessengers() {
        final StrikeMessenger strikeMessenger = new StrikeMessenger();
        final BallMessenger ballMessenger = new BallMessenger();
        final NothingMessenger nothingMessenger = new NothingMessenger();
        final StrikeAndBallMessenger strikeAndBallMessenger = new StrikeAndBallMessenger();
        return List.of(strikeMessenger, ballMessenger, nothingMessenger, strikeAndBallMessenger);
    }
}
