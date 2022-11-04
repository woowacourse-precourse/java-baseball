# 기능 목록

✷ <span style="color:darkgrey">_2022년 우아한 테크 코스 프로코스 2주차 미션 [ <u>**java-baseball**</u> ] 에서 구현한 기능에 대한 문서입니다._</span>

<br/>

## <span style="color:orange">Validation</span> 
> **올바른 입력 값인지 확인**하는 메서드입니다.

<br/>

### <span style="color:brown">입출력 확인</span>

* `isCorrectInput()`
  * **Parameter**
    * 이름 : `inputNum` 
    * 타입 : **String**
  * **Return**
    * 타입 : **Boolean** 
    * 입력값에 문제가 없다면 `true`, 아니라면 예외를 발생시킵니다.
  * **설명** <br/>
    게임 플레이어가 입력한 값이 잘못된 입력값이 아닌지 확인하는 메서드 입니다.<br/>
    `IllegalArgumentException`을 발생시킵니다.

<br/>

* `isSizeThree()`
  * **Parameter**
    * 이름 : `inputNumList`
    * 타입 : **List\<String>**
  * **Return**
    * 타입 : **Boolean**
    * 길이가 3이 맞다면 `true`, 아니라면 `false`를 반환합니다.

<br/>

* `isNumber()`
  * **Parameter**
    * 이름 : `inputNumList`
    * 타입 : **List\<String>**
  * **Return**
      * 타입 : **Boolean**
      * 숫자로만 이루어져 있다면 `true`, 아니라면 `false`를 반환합니다.

<br/>

### <span style="color:brown">데이터 확인</span>

* `checkIsItNothing()`
    * **Parameter 1**
        * 이름 : `answer`
        * 타입 : **List\<String>**
        * 컴퓨터가 생성한 3개의 숫자로 이루어진 리스트입니다.
    * **Parameter 2**
        * 이름 : `userNumList`
        * 타입 : **List\<String>**
        * 사용자가 입력한 3개의 숫자로 이루어진 리스트입니다.
    * **Return**
        * 타입 : **Boolean**
        * Parameter 2(`userNumList`)의 값들 중<br/>
      Parameter 1(`computerNumList`)에 속한 값이 하나도 없을 때 `true`,<br/> 하나라도 속해 있다면 `false`를 반환합니다.
      
    * **설명**<br/>
  입력값에 대한 1차 필터링으로 사용되는 메서드입니다.
  </br> `true`일 경우 바로 `printNothing()`이 실행됩니다.
   

<br/>

* `isStrikeThree()`
    * **Parameter**
        * 이름 : `strikeCount`
        * 타입 : **int**
        * strike인 숫자의 갯수입니다.
    * **Return**
        * 타입 : **Boolean**
        * 3이면 `true`, 아니라면 `false`를 반환합니다.
    * **설명** <br/>
  상대방의 숫자를 모두 맞췄을 때를 판별하여 반복문의 종료 조건으로 사용되는 메서드입니다.

<br/>


---
## <span style="color:orange">Processing</span>
> **실질적인 처리 작업을 수행**하는 메서드입니다.

<br/>

### <span style="color:brown">반복 작업</span>
* `startGame()`
  * **Parameter** 
    * 이름 : `answer`
    * 타입 : List\<String>
  * **Return** : void
  * **설명**<br/>게임을 시작하는 메서드입니다.
  
<br/>

* `findContainedNumbers()`
    * **Parameter 1**
        * 이름 : `answer`
        * 타입 : **List\<String>**
        * 컴퓨터가 생성한 3개의 숫자로 이루어진 리스트입니다.
    * **Parameter 2**
        * 이름 : `userNumList`
        * 타입 : **List\<String>**
        * 사용자가 입력한 3개의 숫자로 이루어진 리스트입니다.
    * **Return**
        * 타입 : **List\<String>**
        * Parameter 2(`userNumList`)의 값들 중<br/>
          Parameter 1(`computerNumList`)에 속한 값들을 추출하여 반환합니다.

    * **설명**<br/>
      `calculateStrikeAndBall()`에 사용될 최소한 ball인 값들을 찾습니다.

<br/>

* `countStrike()`
  * **Parameter 1**
    * 이름 : `answer`
    * 타입 : **List\<String>**
    * 컴퓨터가 생성한 3개의 숫자로 이루어진 리스트입니다.
  * **Parameter 2**
      * 이름 : `containedNumbers`
      * 타입 : **List\<String>**
      * 사용자가 입력한 3개의 숫자로 이루어진 리스트입니다.
  * **Return**
      * 타입 : **int**
      * 
  * **설명**<br/>
    Strike에 해당하는 숫자의 갯수를 반환하는 메서드로<br/>
    Parameter 2(`userNumList`)의 각 값들 중<br/>
    Parameter 1(`computerNumList`)에 같은 값이 같은 자리에 있는 경우의 횟수를 구합니다.<br/>

<br/>
  

* `countBall()`
  * **Parameter 1**
    * 이름 : `containedNumbersCount`
    * 타입 : **int**
  * **Parameter 2**
    * 이름 : `strikeCount`
    * 타입 : **int**
  * Return
    * 타입 : **int** 
  * 상대방의 숫자들과 비교하여 Strike가 아닌 숫자 값들. 즉, Ball의 갯수를 계산하기 위한 메서드입니다.
  <br/> `containedNumbersCount - strikeCount` 의 계산식을 수행합니다.

<br/>

### <span style="color:brown">데이터 생성 작업</span>

* `makeRandomAnswer()`
    * **Return**
        * 타입 : **List\<String>**
        * `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용하여 
    * **설명** <br/>
  상대방 역할에서 사용할 1에서 9까지 서로 다른 임의의 수 3개를 반환하는 메서드 입니다.

<br/>

### <span style="color:brown">데이터 편집 작업</span>
* `calculateStrikeAndBall()`
    * **Parameter**
      * 이름 : `containedNumList`
      * 타입 : **List\<String>**
    * **Return** 
      * 이름 : `resultMap`
      * 타입 : **Map<String,?>** 
          * _strikeCount (**int**)_
          * _ballCount (**int**)_
          * _isStrikeThree (**Boolean**)_
    * **설명**<br/>
  최소한 포함되어 있는 값들 중 Strike인 값과 Ball인 값을 분류하고 3 Strike 여부도 Map형태로 반환하는 메서드

<br/>

### <span style="color:brown">입출력 작업</span>
* `printStartMessage()`
  * **Return**
    * 타입 : void
    * `숫자 야구 게임을 시작합니다.` 를 출력하는 함수

<br/>

* `askInputNumber()`
    * **Return**
      * 타입 : `List\<String>`
    * **설명**<br/>
  게임 플레이어의 입력값을 받기 위한 `readLine()` 메서드를 통해 입력값을 받은 후, <br/>
  유효성 검사(`isCorrectInput()`)를 거쳐 split 되어 String 타입의 숫자들이 담긴 List가 반환된다.

<br/>

* `printNothing()`
  * **Return**
    * 타입 : void
    * `낫싱`을 출력하는 함수

<br/>

* `printBall()`
  * **Parameter** 
    * 이름 : `ballCount`
    * 타입 : **int** 
  * **Return**
    * 타입 : void
    * `${ballCount}볼\\u00A0`을 출력하는 함수
      * **0** 이면 `""`출력

<br/>

* `printStrike()`
  * **Parameter**
    * 이름 : `strikeCount`
    * 타입 : **int** 
  * **Return**
    * 타입 : void
    * `${strikeCount}스트라이크\\u00A0`을 출력하는 함수
      * **0** 이면 `""` 출력

<br/>

* `askContinue()`
  * **Return** : 
    * 타입 : **String**
    * 1 혹은 2 String
  * **설명** <br/> do while 문에서 while 조건문으로 사용하는 메서드로<br/>String 타입의 `"1"` 혹은 `"2"` 를 반환한다.

<br/>
