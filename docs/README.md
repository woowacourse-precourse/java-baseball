## 기능목록
### Round class
| 기능                | 메서드명                       | 설명                               |
|-------------------|----------------------------|----------------------------------|
| 새로운 랜덤 숫자 리스트를 생성 |generateNewHiddenNumberList()| 상수 NUMBER_OF_HIDDEN_NUMBER 크기의 랜덤 숫자 리스트를 생성한다. |
| 리스트에 새로운 랜덤 숫자 추가 | addNewHiddenNumberToList() | 주어진 리스트에 존재하지 않는 랜덤 숫자를 하나 추가한다. |

### Turn class
| 기능                 | 메서드명                         | 설명                                                   |
|--------------------|------------------------------|------------------------------------------------------|
| 사용자 입력 받기          | getPlayerInput()             | Console API를 사용해 사용자 입력을 받는다.                        |
| 사용자 입력을 정수 리스트로 변환 | transformPlayerInputToList() | 사용자 입력으로 받은 문자열을 정수 리스트로 변환한다.                       |
| 사용자 입력 리스트 값 확인    | validatePlayerNumberList()   | 사용자가 잘못된 값을 입력할 경우  IllegalArgumentException을 발생시킨다. |
| 스트라이크 갯수 계산        | countNumberOfStrikes()       | 스트라이크 갯수를 계산한다.                                      |

## TODO
-메시지 "숫자만 입력해 주세요."에 1-9사이 조건 추가