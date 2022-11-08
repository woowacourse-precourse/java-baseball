## 기능목록
### Game class
| 기능               | 메서드명                    | 설명                            |
|------------------|-------------------------|-------------------------------|
| 새로운 게임 시작        | start()                 | 새로운 숫자야구 게임을 시작한다.            |
| 새로운 게임 시작 메시지 출력 | printGameStartMessage() | 새로운 게임 시작 메시지를 출력한다.          |
| 게임 재시작 여부 확인     | askRestart()            | 사용자에게 게임 재시작 여부를 확인한다.        |
| 사용자 입력 받기        | getPlayerInput()        | Console API를 사용해 사용자 입력을 받는다. |

### Round class
| 기능                | 메서드명                          | 설명                                              |
|-------------------|-------------------------------|-------------------------------------------------|
| 새로운 라운드 시작        | start()                       | 새로운 숫자야구 라운드를 시작한다.                             |
| 새로운 랜덤 숫자 리스트를 생성 | generateNewHiddenNumberList() | 상수 NUMBER_OF_HIDDEN_NUMBER 크기의 랜덤 숫자 리스트를 생성한다. |
| 리스트에 새로운 랜덤 숫자 추가 | addNewHiddenNumberToList()    | 주어진 리스트에 존재하지 않는 랜덤 숫자를 하나 추가한다.                |

### Turn class
| 기능                 | 메서드명                          | 설명                                                   |
|--------------------|-------------------------------|------------------------------------------------------|
| 새로운 사용자 턴 시작       | start()                       | 새로운 사용자 턴을 시작한다.                                     |
| 사용자 입력 받기          | getPlayerInput()              | Console API를 사용해 사용자 입력을 받는다.                        |
| 사용자 입력을 정수 리스트로 변환 | transformPlayerInputToList()  | 사용자 입력으로 받은 문자열을 정수 리스트로 변환한다.                       |
| 문자를 정수로 변환         | transformCharacterToInteger() | 문자를 정수로 변환한다.                                        |
| 사용자 입력 리스트 값 확인    | validatePlayerNumberList()    | 사용자가 잘못된 값을 입력할 경우  IllegalArgumentException을 발생시킨다. |
| 볼 개수 계산            | countNumberOfBalls()          | 볼 개수를 계산한다.                                          |
| 스트라이크 개수 계산        | countNumberOfStrikes()        | 스트라이크 개수를 계산한다.                                      |
| 결과 문자열 출력          | printResult()                 | 결과 문자열을 출력한다.                                        |
| 볼 결과 문자열 생성        | getBallResultString()         | 볼 개수에 따른 출력 문자열을 생성한다.                               |
| 스트라이크 결과 문자열 생성    | getStrikeResultString()       | 스트라이크 개수에 따른 출력 문자열을 생성한다.                           |
| 숫자를 다 맞췄는지 확인      | isStrikeOut()                 | 사용자가 숫자를 다 맞춰 스트라이크 개수가 3인지 확인한다.                    |
| 게임 종료 메시지 출력       | printGameOverMessage()        | 게임 종료 메시지를 출력한다.                                     |


## TODO
-볼 개수 0인경우 테스트