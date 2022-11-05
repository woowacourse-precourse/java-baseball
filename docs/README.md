# 기능 목록

### Validation

- input type이 맞는지 확인한다.
- input length가 적절한지 확인한다.
- input의 각 자리수가 원하는 값으로 이뤄져있는지 확인한다.
- input의 각 자리수들이 중복되지 않았는지 확인한다.
- 위의 사항을 어기는 input이면 IllegalArgumentException을 반환한다.

### Output

- 원하는 메시지를 출력 할 수 있다.

### Input

- 사용자로부터 입력 받을 수 있다.

### Random

- 랜덤값을 반환해준다.

### User

- Input 으로부터 input을 받을 수 있다.
- 각각의 input은 Validation을 통과하거나, 실행이 종료된다.
- 길이 3의 숫자를 입력받고 반환해줄 수 있다.
- 길이 1의 숫자를 입력받고 반환해줄 수 있다.
- 각각의 상황에 맞게 Validation이 호출 된다.

### Computer

- Random을 호출하며 길이 3의 겹치지 않는 랜덤 정수값을 생성한다.
- 결과값을 반환한다.

### GameController

- 게임을 시작할 수 있다.
- 게임 시작을 알리는 출력을 요청한다.
- Computer에게 이번 게임의 컴퓨터 random값 3개를 생성하고 반환하도록 호출한다.
- GameLogic에게 반환 받은 random값 3개를 넘겨주며 게임을 진행한다.
- GameLogic이 끝나고 나면 User에게 새로운 게임을 시작할지 응답을 요청한다.
- 응답에 따라 게임을 다시 시작하거나 게임을 종료한다.

### GameLogic

- 필요한 동작을 요구하는 출력하도록 Output을 호출한다.
- 사용자에게 숫자야구에 필요한 Value를 반환해달라는 요청을한다.
- 반환 받은 값을 기준으로 ResultHandler에게 결과를 반환해주도록 요청한다.
- ResultHandler가 반환해준 값 기준으로 ResultPrinter에게 결과 출력을 요청한다.
- ResultHandler가 반환해준 값 기준으로 게임을 계속 진행해야 하는지 FinishChecker를 호출하여 판단한다.

### ResultHandler

- 받은 값 기준으로 게임 결과를 반환해준다.

### ResultPrinter

- 받은 값 기준으로 게임 결과를 출력한다.

### FinishChecker

- 받은 값 기준으로 이번 게임이 끝났는지 확인하고 반환해준다.

