package baseball;

import baseball.baesball.Baseball;
import baseball.baesball.ComputerBaseballGenerator;
import baseball.baesball.PlayerBaseballGenerator;
import baseball.console.ConsoleInput;
import baseball.console.ConsoleOutput;
import baseball.game.GameOrganizer;
import baseball.game.GameStatus;
import baseball.hint.HintGenerator;
import baseball.player.ComputerPlayer;
import baseball.player.GamePlayer;
import baseball.referee.JudgeType;
import baseball.referee.Megaphone;
import baseball.referee.Referee;

import static baseball.game.GameStatus.GAME_RESTART;
import static baseball.referee.JudgeType.GAME_LOSE;
import static baseball.referee.JudgeType.GAME_WIN;

public class Application {
    public static void main(String[] args) {
        GameOrganizer gameOrganizer = new GameOrganizer(new ConsoleInput(), new ConsoleOutput());
        GameStatus gameStatus = GAME_RESTART;

        do {
            Referee referee = new Referee(new HintGenerator(), new Megaphone());
            ComputerPlayer computerPlayer = new ComputerPlayer();
            GamePlayer gamePlayer = new GamePlayer();
            referee.announceStartGame();
            Baseball computer = computerPlayer.playGame(new ComputerBaseballGenerator());

            JudgeType judgeType = GAME_LOSE;
            while (judgeType == GAME_LOSE) {
                referee.announcePlayerToStart();
                Baseball player = gamePlayer.playGame(new PlayerBaseballGenerator());
                judgeType = referee.judgeFrom(computer, player);
            }

            if (judgeType == GAME_WIN) {
                gameStatus = gameOrganizer.askAnotherGame();
            }
        } while (gameStatus == GAME_RESTART);
    }
}
