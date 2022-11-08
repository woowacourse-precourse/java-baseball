//package baseball.controller;
//
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.io.*;
//
//import static org.assertj.core.api.Assertions.*;
//
//public class GameControllerTest {
//
//    GameController gameController;
//
//    @BeforeEach
//    void initializeClass(){
//        gameController = new GameController();
//    }
//
//    @Test
//    void 게임_초기화시_gameStatus는_참(){
//        gameController.initializeGame();
//        assertThat(gameController.gameStatusService.getGameStatus()).isTrue();
//    }
//
//    @Test
//    void clearScore진행시_스트라이크와_볼은_0(){
//        gameController.initializeGame();
//        gameController.setGame();
//        gameController.clearScore();
//        assertThat(gameController.gameService.getBallCount()).isEqualTo(0);
//        assertThat(gameController.gameService.getStrikeCount()).isEqualTo(0);
//    }
//
//    @Test
//    void 플레이어입출력_요청시_요청문부터_출력까지_진행(){
//        gameController.initializeGame();
//        gameController.setGame();
//        gameController.clearScore();
//        String input = "123";
//        OutputStream out = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(out));
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//        assertThat(gameController.getPlayerNumbers()).isEqualTo(input);
//        assertThat(out.toString()).isEqualTo("숫자를 입력해주세요 : ");
//    }
//
////    @Test
////    void matchGame_실행시_서비스에서_점수_0부터_3사이(){
////        gameController.initializeGame();
////        gameController.setGame();
////        gameController.clearScore();
////        String input = "123";
////        InputStream in = new ByteArrayInputStream(input.getBytes());
////        System.setIn(in);
////        gameController.putPlayerInService(gameController.getPlayerNumbers());
////        gameController.matchGame();
////        assertThat(gameController.gameService.getBallCount()).isEqualTo(1);
////        assertThat(gameController.gameService.getStrikeCount()).isEqualTo(1);
////    }
//
////    @Test
////    void showPlayerScore_실행시_1볼_1스트라이크_출력(){
////        gameController.initializeGame();
////        gameController.setGame();
////        gameController.clearScore();
////        String input = "123";
////        InputStream in = new ByteArrayInputStream(input.getBytes());
////        System.setIn(in);
////        OutputStream out1 = new ByteArrayOutputStream();
////        System.setOut(new PrintStream(out1));
////        gameController.putPlayerInService(gameController.getPlayerNumbers());
////        gameController.matchGame();
////        OutputStream out2 = new ByteArrayOutputStream();
////        System.setOut(new PrintStream(out2));
////        String result = "1볼 1스트라이크\n";
////        gameController.showPlayersScore();
////        assertThat(out2.toString()).isEqualTo(result);
////    }
//
////    @Test
////    void 스트라이크_3개면_참을_반환(){
////        gameController.initializeGame();
////        gameController.setGame();
////        gameController.clearScore();
////        String input = "123";
////        InputStream in = new ByteArrayInputStream(input.getBytes());
////        System.setIn(in);
////        gameController.putPlayerInService(gameController.getPlayerNumbers());
////        gameController.matchGame();
////        assertThat(gameController.isThreeStrike()).isTrue();
////    }
//
//    @Test
//    void getPlayerOpinion_입력_올바를시_문자열반환(){
//        String input = "1";
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//        OutputStream out1 = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(out1));
//        assertThat(gameController.getPlayersOpinion()).isEqualTo("1");
//        assertThat(out1.toString()).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
//    }
//
//    @Test
//    void setGameStatus에_2입력시_gameStatus_거짓으로_초기화(){
//        gameController.setGameStatus("2");
//        assertThat(gameController.gameStatusService.getGameStatus()).isFalse();
//    }
//}
