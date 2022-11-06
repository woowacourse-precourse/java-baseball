# 💻 Start Program
1. Power On Number Baseball Game
   - only when power is off, Print game start phrase and Set isPower variable to true


2. Start Number Baseball Game 
   - only possible when power is on. if not, should power on


3. When the game is over, ask player whether to restart the game or not
   - if 1, restart game
   - else if 2, terminate program
   - else throw IllegalArgumentException


4. Power Off Number Baseball Game
   - only when power is on, Init variables and Set isPower variable to false

---
# 🎮 Start Game

## Setup Game
1. Pick Answer Number List

   ❗ MUST clear the List not to be affected by previous execution result
   - pick 3 unique numbers in range 1 ~ 9

## Play Game
1. Input Player Number List

   ❗ MUST clear the List not to be affected by previous execution result
   - if wrong input, throw IllegalArgumentException
   - **Input condition**: length of the input string is 3 && only natural number && each number is unique
   - **Example of wrong input**: "5678", "1a3", "510", "177"


2. Count ball and strike
   - if Answer Number List or Player Number List is not valid, throw IllegalStateException


3. Print hint, using the ball and strike value
   - if ball or strike is not valid, throw IllegalStateException
   - **Condition**: 0 <= ball, strike, ball + strike <= 3


4. if Answer Number List == Player Number List, strike is 3 and the game is over


5. if not, Go back to 1.

## Game Over
1. Print game over phrase