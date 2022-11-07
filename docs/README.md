## List of Features

- **Application**: playBall
- **User**: greet, promptForNumber, congratulate, wantsToPlayOn
- **Play**: getRandomNumber, getNumberFrom
- **Score**: getScore, printScore

## Pseudocode
```
userWantsToPlay is true
greet User

While userWantsToPlay:
    playBall:
        getRandomNumber
        strikeOut is false
        While strikeOut is false:
            promptForNumber
            getNumberFrom input
            getScore from number
            printScore
            If score is all strikes, then strikeOut is true
        congratulate User
        If User wantsToPlayOn, then userWantsToPlay is true;
        else, userWantsToPlay is false
```