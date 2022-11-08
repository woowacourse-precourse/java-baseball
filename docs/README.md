# 🔨 Requirements

#### 1. Game start

- name: playTheGame
- function detail: the game starts with the message

#### 2. Print the game start message

- name: printTheGameStartMessage
- function detail: returns "숫자 야구 게임을 시작합니다."

#### 3. Get random number

- name: getRandomNumber
- function detail: return 3 different numbers
- library: camp.nextstep.edu.missionutils.Randoms

#### 4. Guess number

- name: guessNumber
- function detail: 플레이어가 터미널을 사용해 숫자를 입력할 수 있다
- library: camp.nextstep.edu.missionutils.Console

#### 5. IllegalArgumentException handler

- name: isInputNumberValid
- function detail:
  - throws IllegalArgumentException if the length of number is not 3
  - throws IllegalArgumentException if any of the character is not int
    

#### 6. Get score of the current turn

- name: getScoreOfTheCurrentTurn()
- function detail: return the score in ball, strike count

#### 7. Judge strike

- name: judgeStrike()
- function detail: if the same number is at the exact index, return 1 else 0

#### 8. Judge ball

- name: judgeBall()
- function detail: if the number is at the wrong index, return 1 else 0

#### 9. Get result of the current turn

- name: getResultOfTheCurrentTurn()
- function detail: return the result message according to the score

#### 10. Message of game continue or exit

- name: askContinueOrExitGame
- function detail: if 3 strike, return message to guide the player 
  - if press 1, game restart
  - if press 2, game end

#### 11. Choose to end game or continue

- name: chooseToEndGameOrContinue
- function detail: game end or continue depends on the player's choice
  - if press 1, game restart
  - if press 2, game end