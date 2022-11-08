## 기능 목록

---

### Validator

- 사용자의 입력이 올바른지 확인하는 기능

    `doNumberValidation`, `isDecimalNumber`, `isThreeDigits`, `isAllUnique`
 

- 게임 한 판을 종료한 후, 사용자의 입력이 1 또는 2인지 확인하는 기능

    `doStatusValidation`

### GameManager

- 사용자의 입력에 따라 숫자 야구 게임을 여러 판 반복하는 기능

    `launch`
 

- 숫자 야구 게임 한 판을 진행하는 기능

    `play`

### Opponent

- 맞춰야 할 정답을 초기화하는 기능
    
    `initAnswer`, `appendIfUnique`
 

- 사용자가 입력한 값과 정답을 비교해 힌트를 제공하는 기능

    `judge`, `countIfTrue`

### IOHandler

- 안내 문구를 출력하는 기능

    `writeLaunchMessage`, `writeInputMessage`, `writeCompletemessage`, `writeStatusMessage`
 

- 스트라이크, 볼 카운트를 인자로 받아 힌트 메시지를 출력하는 기능

    `writeHintMessage`
 

- 사용자로부터 입력을 받아 반환하는 기능
    
    `readInput`