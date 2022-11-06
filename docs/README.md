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
    * 타입 : **void** 
    * 입력값에 문제가 없다면 예외가 발생하며, 아니라면 단순 처리 후, 종료니다.
  * **설명** <br/>
    게임 플레이어가 입력한 값이 잘못된 입력값이 아닌지 확인하는 메서드 입니다.<br/>
    Validations 내부 메서드인 `isSizeThree()` 와 `isNumber()`, 객체 대상 메서드인 `isEmpty()` 메서드를 조건식으로 사용했으며 <br/>
    하나의 조건이라도 만족하지 않을 경우, `IllegalArgumentException`을 발생시킵니다.

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
  * **설명** <br/>
    stream으로 변환하여 0-9사이의 숫자 문자열이 아닐 경우를 <br/>filter메서드와 `matches()` 메서드를 통해 걸러어 결과가 3이 맞는지 확인합니다.

<br/>

### <span style="color:brown">데이터 확인</span>

* `checkIsItNothing()`
    * **Parameter 1**
        * 이름 : `answer`
        * 타입 : **ArrayList\<String>**
        * 컴퓨터가 생성한 3개의 숫자로 이루어진 리스트입니다.
    * **Parameter 2**
        * 이름 : `userNumList`
        * 타입 : **ArrayList\<String>**
        * 사용자가 입력한 3개의 숫자로 이루어진 리스트입니다.
    * **Return**
        * 타입 : **Boolean**
        * Parameter 2(`userNumList`)의 값들 중<br/>
      Parameter 1(`computerNumList`)에 속한 값이 하나라도 없을 때 `true`,<br/> 하나라도 속해 있다면 `false`를 반환합니다.
      
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
    * 타입 : ArrayList\<String>
  * **Return** : void
  * **설명**<br/>한 판의 게임을 실행하는 메서드입니다.<br/>
  flag라는 초기값이 false인 boolean타입 변수를 사용하여 정답을 맞출 때까지 while문을 반복하며 <br/>"3스트라이크"가 발생할 경우 true값으로 전환되어 while문이 종료됩니다. 
  
<br/>

* `makeRandomAnswer()`
    * **Return**
        * 타입 : **ArrayList\<String>**
        * `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용하여 
    * **설명** <br/>
  상대방 역할에서 사용할 1에서 9까지 서로 다른 임의의 수 3개를 반환하는 메서드 입니다.<br/>
  random 숫자를 추출한 후 List에 저장하고, stream으로 변환하여 `map()` 메서드를 통해 문자열 전환을 하여 Return합니다.<br/> 또한 `Collectors.toList()` 메서드는 List타입으로 반환하기 때문에 `(ArrayList<String>)`을 통한 casting을 수행합니다.

<br/>


* `findContainedNumbers()`
    * **Parameter 1**
        * 이름 : `answer`
        * 타입 : **ArrayList\<String>**
        * 컴퓨터가 생성한 3개의 숫자로 이루어진 리스트입니다.
    * **Parameter 2**
        * 이름 : `userNumList`
        * 타입 : **ArrayList\<String>**
        * 사용자가 입력한 3개의 숫자로 이루어진 리스트입니다.
    * **Return**
        * 타입 : **ArrayList\<String>**
        * Parameter 2(`userNumList`)의 값들 중<br/>
          Parameter 1(`computerNumList`)에 속하지 않은 값들을 null로 하여 반환합니다.

    * **설명**<br/>
      `calculateStrikeAndBall()`에 사용될 최소한 ball인 값들을 찾습니다.<br/>
      만약 속하지도 않은 값을 단순히 빼버리게 되면 향후 strike계산에 있어 자리 비교가 불가능하기 때문에<br/>
      반복문을 통해 속하지 않은 값을 발견한 경우, `"-1"`로 대체하였다.<br/>
      

<br/>

### <span style="color:brown">입력 요청 및 입력 값 추출 작업</span>


* `askInputNumber()`
    * **Return**
      * 타입 : `ArrayList\<String>`
    * **설명**<br/>
  게임 플레이어의 입력값을 받기 위한 `readLine()` 메서드를 통해 입력값을 받은 후, <br/>
  유효성 검사(`isCorrectInput()`)를 거쳐 split 되어 String 타입의 숫자들이 담긴 ArrayList객체가 반환된다.

<br/>

* `askContinue()`
  * **Return** : 
    * 타입 : **boolean**
  * **설명** <br/> do while 문에서 while 조건문으로 사용하는 메서드로<br/>입력값을 확인하여 true 혹은 false를 반환합니다.
  <br/> 해당 메서드 또한 입력을 받는 메서드이기 때문에 잘못된 입력값을 받을 경우 IllegalArgumentException 예외를 발생시킵니다.

<br/>


### <span style="color:brown">필터링 및 데이터 추출 작업</span>

* `countContained()`
   * **Parameter**
    * 이름 : `containedNumbers`
    * 타입 : **ArrayList\<String>**
    * `findContainedNumbers()`의 반환값 리스트입니다.
  * **Return**
      * 타입 : **int**
  * **설명** <br/>`findContainedNumbers()`메서드의 결과값에 대해 대체값인 "-1"을 제외한 최소한 Ball 이상인 값들의 갯수를 구하는 메서드입니다.
  <br/> stream으로 변환하여 `filter()`메서드와 `matches()` 메서드를 활용했습니다.

<br/>


* `countStrike()`
  * **Parameter 1**
    * 이름 : `answer`
    * 타입 : **ArrayList\<String>**
    * 컴퓨터가 생성한 3개의 숫자로 이루어진 리스트입니다.
  * **Parameter 2**
      * 이름 : `containedNumbers`
      * 타입 : **ArrayList\<String>**
      * 사용자가 입력한 3개의 숫자로 이루어진 리스트입니다.
  * **Return**
      * 타입 : **int**
  * **설명**<br/>
    Strike에 해당하는 숫자의 갯수를 반환하는 메서드로<br/>
    Parameter 2(`userNumList`)의 각 값들 중<br/>
    Parameter 1(`computerNumList`)에 같은 값이 같은 자리에 있는 경우의 횟수를 구합니다.<br/>
    stream으로 변환하여 `filter()`메서드와 `equals()`, `indexOf()` 메서드를 활용했습니다.

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
  * **설명** <br/>상대방의 숫자들과 비교하여 Strike가 아닌 숫자 값들. 즉, Ball의 갯수를 계산하기 위한 메서드입니다.
  <br/> `containedNumbersCount - strikeCount` 의 계산식을 수행합니다.

<br/>


* `calculateStrikeAndBall()`
  * **Parameter 1**
    * 이름 : `answer`
    * 타입 : **ArrayList\<String>**
    * 컴퓨터가 생성한 3개의 숫자로 이루어진 리스트입니다.
  * **Parameter 2**
    * 이름 : `containedNumList`
    * 타입 : **ArrayList\<String>**
  * **Return** 
    * 이름 : `resultMap`
    * 타입 : **Map<String,Object>** 
        * _strikeCount (**int**)_
        * _ballCount (**int**)_
        * _isStrikeThree (**Boolean**)_
    * **설명**<br/>
  최소한 포함되어 있는 값들 중 Strike인 값의 갯수와 Ball인 값의 갯수와 3 Strike 여부를 Map객체에 담아 반환하는 메서드

<br/>


### <span style="color:brown">데이터 출력 작업</span>
* `printStartMessage()`
  * **Return**
    * 타입 : void
    * `숫자 야구 게임을 시작합니다.` 를 출력하는 함수
  * `println()` 사용

<br/>


* `printNothing()`
  * **Return**
    * 타입 : void
    * `낫싱`을 출력하는 함수
  * `println()` 사용

<br/>

* `printBall()`
  * **Parameter** 
    * 이름 : `ballCount`
    * 타입 : **int** 
  * **Return**
    * 타입 : void
    * `printf("%d볼 ", ballCount)`을 출력하는 함수
  * **설명**<br/>
  printStrike 메서드와 printBall 메서드가 실행된다는 것은 둘 중 하나의 값은 무조건 있다는 의미이며<br/>
  볼이 없다면 Strike가 무조건 출력되는 것이기 때문에 ballCount가 0일 경우 아무것도 출력하지 않습니다.<br/>
  또한 개행을하게되면 Strike가 아랫줄로 넘어가기 때문에 개행을 하지 않는 `printf()` 메서드를 사용했습니다.

<br/>

* `printStrike()`
  * **Parameter**
    * 이름 : `strikeCount`
    * 타입 : **int** 
  * **Return**
    * 타입 : void
    * `printf("%d스트라이크\n", strikeCount)`을 출력하는 함수
      * **0** 이면 단순 개행 처리를 위해 `println()` 실행
  * **설명**<br/>
  Strike값은 무조건 `printBall()` 처리 이후에 실행되며 마지막 출력항목이기 때문에<br/>
  strikeCount 값이 0일 경우는 이미 앞선 순서에서 Ball 갯수가 모두 출려된 것이므로 `println()`을 실행시켜 개행시킵니다.<br/>
  strikeCount 값이 0 이상일 경우는 `printf("%d스트라이크\n", strikeCount)`을 출력합니다.


<br/>


