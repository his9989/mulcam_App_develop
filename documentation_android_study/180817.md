## 단축키
1. Ctrl+i : implements할 목록을 보여준다.
2. Alt+Insert : Generate 단축키 (코드 바로 생성해주는 단축키)

## 수업내용
1. APP의 기본요소
  * Activity
  * Broadcast Receiver
  * Content Provider
  * Service : 화면이 없는 BackGround Activity
  
2. ListView
  * ArrayList라는 Daata를 만들어서 거기에 데이터를 저장한다.
  * 데이터를 출력할 UI는 ListView라는 Layout을 사용한다.
  * 즉, ListView는 Layout과 Data가 별도로 존재한다.
  * ArrayAdapter라는 관리자와 같은 개념을 사용해서 ListView를 사용한다.
  * 즉, Data를 변경할떄마다 ArrayAdapter에게 변경 요청하면 ListView에 refresh하게 된다.
  
3. Call Back Service
  * listener를 등록해두면, 함수를 호출하지 않아도 자동으로 특정 상황이 발생하면 수행하게 되는 메소드.
    예를 들어, 리스너를 등록하고, 리스너 클릭에 따른 Call Back Service를 설정해두면 <br>
    Call Back Service는 따로 호출하지 않아도 클릭하면 자동으로 수행된다.
    
## 실습
1. CustomListActivity
  * activity_custom_list_view.xml파일로 ListView가 있는 화면 구성UI를 만들고, 
  * CustomListViewActivity.java에서 setContentView를 이용해서 xml의 화면구성을 가져온다.
  
<code>

        setContentView(R.layout.activity_custom_list_view);

</code>

  * listitem.xml에서 activity_custom_list_view.xml의 ListView 행에 들어갈 UI를 만든다.
  * product.java에서 값을 저장하기 위한 객체를 만든다.
  * Adapter에서 getView()을 이용해서 관리자 역할을 한다.
  

