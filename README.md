# 미션 - [숫자 야구](https://marked-duck-24a.notion.site/f9b3106eeffe488786e3331d12aa2d15?v=61e814e6ba1a48288251dc0e2ac72ce6) 기능별 명세

## 1. public static List<Integer\> getPlaceValuesFromNum(int num) {}

### input
- **int num**
    숫자 야구 과정에서 컴퓨터 혹은 사용자가 선택한 세 자릿수.

### output
- **List<Integer\>** 인덱스마다 num의 각 자리 숫자가 하나씩 저장되어 있는 리스트. 

### 기능 상세
숫자 야구를 진행하기 위해서는 수의 각 자릿수별로 비교하는 과정이 필요하기 때문에, 이를 위해 컴퓨터 또는 사용자가 선택한 수를 자릿수별로 분리하는 기능을 합니다.</br>
각 자릿수는 낮은 자리부터 높은 자리 순으로 저장됩니다.</br>
만약 자릿수 중 0이 존재하거나, num이 세 자릿수가 아닌 경우에는 잘못된 입력으로 게임이 진행될 수 없기 때문에 IllegalArgumentException을 발생시킵니다.