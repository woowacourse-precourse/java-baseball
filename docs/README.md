# 💻 Start Program
1. Start Number Baseball Game 


2. When the game is over, ask player whether to restart the game or not
   - if 1, restart game
   - else if 2, terminate program
   - else throw IllegalArgumentException

---
# 🎮 Start Game

## Setup Game
1. Print game start phrase


2. Pick Answer Number List

   ❗ MUST clear the List not to be affected by previous execution result
   - pick 3 unique numbers in range 1 ~ 9

## Play Game
1. Input Player Number List

   ❗ MUST clear the List not to be affected by previous execution result
   - if wrong input, throw IllegalArgumentException
   - **Input condition**: length of the input string is 3 && only number && each number is unique
   - **Example of wrong input**: "5678", "1a3", "177"


2. Count ball and strike


3. Print hint, using the ball and strike value


4. if Answer Number List == Player Number List, strike is 3 and the game is over


5. Go back to 1.

## Game Over
1. Print game over phrase