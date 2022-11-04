package domain;

public class Game {
    int strike_count;
    int ball_count;
    int[] game_numbers;

    public Game(int[] game_numbers) {
        this.game_numbers = game_numbers;
    }

    public void initialize(){
        strike_count = 0;
        ball_count = 0;
    }

    public int getStrike_count() {
        return strike_count;
    }

    public int getBall_count() {
        return ball_count;
    }

    public void increase_strike(){
        strike_count += 1;
    }

    public void increase_ball(){
        ball_count += 1;
    }

    public int[] getGame_numbers() {
        return game_numbers;
    }
}
