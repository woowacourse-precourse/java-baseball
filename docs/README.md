# java-baseball REAME.md

# 기능 목록

---

## class Application
### [숫자 야구 게임 플레이 및 종료]

- main()

## interface Game
### [게임을 시작하고 종료하기까지의 플레이 과정 실행]
- play()
### [게임 종료 후 다시 시작할 것인지 유저에게 묻고 답을 반환]
- choiceRestartOrExit()
### [길이가 같은 두 문자에서, 한 문자의 글자가 다른 문자에 얼마나 포함되어 있는지 카운트]
- [기준 문자의 글자가 같은 위치의 비교 문자의 글자와 같은 횟수를 카운트] -> countSameLetterInSameIndexWithoutDuplicate()
- [기준 문자의 글자가 다른 위치의 비교 문자의 글자와 같은 횟수를 카운트] -> countSameLetterInDifferentIndexWithoutDuplicate()
### [유저에게 질문을 하고 그에 대한 답을 받아오는 기능]
- getUserAnswerInString
## class NumberBaseball
### [숫자 야구 게임 플레이 기능]
- play()
  - [숫자 야구의 답(세자리 중복 없는 랜덤 숫자)을 세팅하는 기능] -> setComputerNumberInString() 
  - [사용자 입력숫자의 유효성 테스트 기능] -> isValidBaseballNumber()
    - [숫자 외 값이 포함됐는지 확인하는 기능] -> isValidValue()
    - [숫자 야구 게임 규칙 길이에 맞는지 확인하는 기능] -> isValidLength()
    - [숫자가 중복이 없는지 확인하는 기능] -> isValidOfDuplication()
  - [답과 사용자 입력숫자를 비교하는 기능] -> compareComputerAndUser()
  - [사용자 입력숫자에 대한 결과를 출력하는 기능] -> printResult()
    - [사용자가 답을 맞췄을 때 출력 기능] -> printThreeStrike()
    - [볼과 스트라이크가 하나도 없을 때 출력 기능] -> printNothingMatch()
    - [그 외 출력 기능] -> printScore()
- [게임 종료 후 재시작 여부를 묻는 기능] -> choiceRestartOrExit()
  - [재시작 질문에 대한 답의 유효성을 확인하는 기능] -> isValidAnswer()