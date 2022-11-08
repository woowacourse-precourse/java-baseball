## List of Features

- **Application**: playBall, playOn
- **Message**: GREETING, PROMPT_FOR_NUMBER, CONGRATULATIONS, PROMPT_PLAY_ON
- **Play**: getRandomNumber, getNumberFrom
- **Score**: of (get score _of user_ against _computer_), print

## Pseudocode

```
Print GREETING
Do while playOn:
    playBall:
        getRandomNumber
        Do while Score is not strikeOut:
            Print PROMPT_FOR_NUMBER
            getNumberFrom input
            Get Score of user against computer
            print Score
        Print CONGRATULATIONS
```