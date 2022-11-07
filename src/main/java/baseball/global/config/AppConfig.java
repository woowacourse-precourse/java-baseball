package baseball.global.config;

import baseball.application.GameFacade;
import baseball.domain.ball.service.BallCreator;
import baseball.domain.ball.service.BallFactory;
import baseball.domain.ball.service.BallService;
import baseball.domain.ball.service.BallServiceImpl;
import baseball.domain.game.service.*;
import baseball.domain.hint.service.HintCreator;
import baseball.domain.hint.service.HintMessenger;
import baseball.domain.hint.service.HintService;
import baseball.domain.hint.service.HintServiceImpl;
import baseball.infrastructure.ball.BallCreatorImpl;
import baseball.infrastructure.ball.BallFactoryImpl;
import baseball.infrastructure.game.GameMessengerImpl;
import baseball.infrastructure.game.GameRefereeImpl;
import baseball.infrastructure.game.GameValidatorImpl;
import baseball.infrastructure.hint.*;
import baseball.presentation.BaseBallGameController;

import java.util.List;

public class AppConfig {

    public BaseBallGameController gameController() {
        return new BaseBallGameController(gameFacade());
    }

    public GameFacade gameFacade() {
        return new GameFacade(ballService(), gameService(), hintService());
    }

    public GameService gameService() {
        return new GameServiceImpl(gameMessenger(), gameValidator(), gameReferee());
    }

    public GameMessenger gameMessenger() {
        return new GameMessengerImpl();
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

    public HintService hintService() {
        return new HintServiceImpl(hintCreator(), hintMessengers());
    }

    public HintCreator hintCreator() {
        return new HintCreatorImpl();
    }

    public List<HintMessenger> hintMessengers() {
        final StrikeMessenger strikeMessenger = new StrikeMessenger();
        final BallMessenger ballMessenger = new BallMessenger();
        final NothingMessenger nothingMessenger = new NothingMessenger();
        final StrikeAndBallMessenger strikeAndBallMessenger = new StrikeAndBallMessenger();
        return List.of(strikeMessenger, ballMessenger, nothingMessenger, strikeAndBallMessenger);
    }
}
