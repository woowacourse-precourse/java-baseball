package baseball;

public class Application {
    public static void main(String[] args) {

        // TODO: 프로그램 구현
        boolean isInGame = true;
        Game game = new Game();
        MessageHolder messageHolder = new MessageHolder();
        game.init();
        messageHolder.init();
        messageHolder.print_start_messege();
        while(isInGame)
        {
            int playerNum = messageHolder.print_get_game_input();
            game.compare_player_input_and_answer(playerNum);
            int currentBall = game.get_ball();
            int currentStrike = game.get_strike();
            messageHolder.print_ball_and_strke(currentBall, currentStrike);
            if(game.get_strike() == 3)
            {
                messageHolder.print_congrate();
                messageHolder.print_game_end();
                int player_restart = messageHolder.print_ask_restart();
                if(player_restart == 2)
                {
                    messageHolder.print_game_end();
                    isInGame = false;
                    break;
                }
                if(player_restart == 1)
                {
                    game.init();
                }
            }
        }
        
    }
}
