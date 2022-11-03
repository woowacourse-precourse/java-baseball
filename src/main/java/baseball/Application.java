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
        int player_restart = -1;
        set_game_start(game, messageHolder);

        while (isInGame) {

            isInGame = in_game(game, messageHolder);

            if (!isInGame) {
                player_restart = game_end_get_player_input(messageHolder);
            }

            if (player_restart == 2) {
                isInGame = false;
                break;
            }

            if (player_restart == 1) {
                isInGame = true;
                player_restart = -1;
                set_game_start(game, messageHolder);
            }

        }
    }

    private static int game_end_get_player_input(MessageHolder messageHolder) {
        int player_restart;
        player_restart = messageHolder.print_ask_restart_and_get_input();
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
