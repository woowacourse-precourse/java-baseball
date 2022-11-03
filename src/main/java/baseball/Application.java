package baseball;

public class Application {
    public static void main(String[] args) {

        // TODO: 프로그램 구현
        Game game = new Game();
        MessageHolder messageHolder = new MessageHolder();
        game_start(game, messageHolder);
        
    }
    
    private static void game_start(Game game, MessageHolder messageHolder) {
        boolean isInGame = true;
        set_game_start(game, messageHolder);
        int player_restart = -1;

        while (isInGame) {

            isInGame = in_game(game, messageHolder);

            player_restart = game_end(messageHolder, isInGame, player_restart);

            if (player_restart == 2) {
                messageHolder.print_game_end();
                isInGame = false;
                break;
            }

            if (player_restart == 1) {
                isInGame = true;
                set_game_start(game, messageHolder);
            }

        }
    }

    private static int game_end(MessageHolder messageHolder, boolean isInGame, int player_restart) {
        
        if (!isInGame) {
            messageHolder.print_congrate();
            messageHolder.print_game_end();
            player_restart = messageHolder.print_ask_restart_and_get_input();
        }

        return player_restart;
    }

    private static boolean in_game(Game game, MessageHolder messageHolder) {
        int playerNum = messageHolder.print_get_game_input();
        game.compare_player_input_and_answer(playerNum);
        int currentBall = game.get_ball();
        int currentStrike = game.get_strike();
        messageHolder.print_ball_and_strke(currentBall, currentStrike);

        if(currentStrike == 3)
            return false;
        
        return true;
    }

    private static void set_game_start(Game game, MessageHolder messageHolder) {
        game.init();
        messageHolder.print_start_messege();
    }
}
