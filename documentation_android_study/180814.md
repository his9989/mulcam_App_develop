## URI
  * URI: 통합 자원 식별자 (더 큰 개념)
      - 인터넷에 있는 자원의 주소. resource 주소까지 포함되있다.
  * URL: 파일 식별자
      - 네트워크 상에서 자원이 어디있는지 알려주는 기능.
      
  * Android에서의 URI : 프로젝트의 코드 자원의 주소를 표시. 대표적으로 서로 다른 프로젝트 간의 연결에 사용된다.
    
## Activity Life Cycle status

<code>

    start -> Active/Running                                     // state
                = onCreate()->onStart()->onResume()             // 명령어
    Active/Running->Paused
                = onPause()
    Paused->Stopped
                = onStop()
    Paused->Active/Running
                = onResume()
    Stopped->Active/Running
                = onRestart()->onStart()->onResume()
    Stopped->Shut down
                = onDestory()
                
                
    start->active/Running->Paused->
                       

</code>

## GUI
* 모든 UI는 View라는 최상위 클래스를 갖고있다.
* View는 event를 넣을 수 있다.
* ImageView, Button, TextView 등을 Widget이라 하며, 이것들은 View을 상속한다. 즉, 모든 UI의 최상위 클래스라는 의미
* ViewGroup <br>
  (1) ViewGroup는 View를 상속받고, addView(View) 메소드를 추가한다. <br>
  (2) LinearLayout, FrameLayout, TableLayout 등 Layout 계열이 ViewGroup를 상속받는다. 즉, Layout 계열 또한, View를 상속받는다할 수 있다. <br>
      - FrameLayout는 여러 개를 포개서, 하나만 보여줄 때 사용된다. <br>
  (3) Layout 내부에 또 다른 Layout을 넣을 수 있다. <br>
  
<code>
 
     View {
       ViewGroup {
         ViewGroup{
           Layout계열{
             같거나 다른 Layout계열{
               ...
             }
           }
         }
         View{
           ...
         }
       }
       View {
         ...
       }
     }

  </code>
  
  

  * 코드, 문법
    (1) @+id : 리소스에 아이디를 추가해서 사용하겠다.라는 의미이다. Button 등의 View 객체의 이름을 지정할 때 사용한다.
    (2) Event Listener을 입력할 때. new OnClickListener에 대한 메소드를 만들고 싶으면 -> **new.OnC까지만 입력하고 Enter누르면 Event Handler method 내용까지 모든 코드가 자동완성 된다.**

  * 용어 <br>
    (1) 모든 UI는 기본적으로 width, height를 갖는다. 이는 상대크기로 해야 화면 <br>
    (2) UI와 UI간의 간격 = margine. (버튼과 버튼간의 간격) <br>
    (3) UI의 Border와 UI의 Content간의 간격 =  padding. (버튼의 틀과 버튼의 내용물간의 간격) <br>
    (4) UI는 기본적으로 lefttop(좌상단 코너 꼭지점)이 시작점이고, righttop(우하단 코너 꼭지점)이 끝점이다. <br>
    (5) 텍스트 크기 단위 : sp, 텍스트 이외의 단위 : dp

  ## event
  * Event의 3요소
   1. EventAction :   행하는 Event의 종류.         (ex. Click, Slider 등 다양한 액션이 있다.)
   2. EventSource :   Event를 받는 매개체.         (ex. Button 등 모든 View를 상속받는 UI는 EventSource가 될 수 있다.)
   3. EventListener : Event에 의해 실행되는 추상 메소드를 갖고 있다. 즉, EventListener는 Interface.
                                                  (ex. View.OnClickListener에 의해 호출되는 onClick() 메소드)
   즉, Button을 Click했을 때, Listener에서 어떤 메소드를 실행할지 오버로딩해야한다. <br>
   UI와 UI 동작 방법과 동작에 의한 실행부 3가지가 구분되어 있는 것 <br>

  * event 처리 방식 종류

* 1번째 : UITest class가 View.onClickListener 인터페이스를 받도록 하는 경우.

<code>
 
    public class UITest extends AppCompatActivity implements View.OnClickListener{
      private TextView tv;
      private EditText et;
      private Button bt;

      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_uitest);
          et = findViewById(R.id.first_edit);
          tv = findViewById(R.id.first_tv);
          bt = findViewById(R.id.first_button);
          //MyClick click = new MyClick();
          bt.setOnClickListener(this);    // this : UITest인데, OnClickListner으로 UpCasting 된다.
      }

      @Override
      protected void onRestart() {
          super.onRestart();
          String s = et.getText().toString();
          // testview를 edit에 입력된 string으로 바꾼다.
          tv.setText(s);

          // testview를 아래의 String으로 고친다.
          // tv.setText("Hello java and Android");
      }

      @Override
      public void onClick(View v) {
          String s = et.getText().toString();
          tv.setText(s);
          et.setText("");
      }
  }


</code>

* 2번째 방법 : UITest 안에 기능을 구현하는 method을 만드는 경우

<code>

    public class UITest extends AppCompatActivity /*implements View.OnClickListener*/{
      private TextView tv;
      private EditText et;
      private Button bt;

      private class MyClick implements View.OnClickListener{

          @Override
          public void onClick(View v) {
              String s = et.getText().toString();
              tv.setText(s);
              et.setText("");        }
      }

      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_uitest);
          et = findViewById(R.id.first_edit);
          tv = findViewById(R.id.first_tv);
          bt = findViewById(R.id.first_button);
          MyClick click = new MyClick();
          bt.setOnClickListener(click);    // this : UITest인데, OnClickListner으로 UpCasting 된다.
      }

      @Override
      protected void onRestart() {
          super.onRestart();
          String s = et.getText().toString();
          // testview를 edit에 입력된 string으로 바꾼다.
          tv.setText(s);

          // testview를 아래의 String으로 고친다.
          // tv.setText("Hello java and Android");
      }
  }
  
</code>

* 3번 째 방법. 가장 많이 사용하는 방식. click라는 ClickListener 변수를 선언할 때 바로 구현 내용을 작성하는 

<code>

    public class UITest extends AppCompatActivity /*implements View.OnClickListener*/{
      private TextView tv;
      private EditText et;
      private Button bt;

      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_uitest);
          et = findViewById(R.id.first_edit);
          tv = findViewById(R.id.first_tv);
          bt = findViewById(R.id.first_button);
          // MyClick click = new MyClick();
          View.OnClickListener click = new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  String s = et.getText().toString();
                  tv.setText(s);
                  et.setText("");
              }
          };
          
          /* 이렇게도 사용한다.
          View.OnClickListener click;
          bt.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  String s = et.getText().toString();
                  tv.setText(s);
                  et.setText("");
              }
          });    // this : UITest인데, OnClickListner으로 UpCasting 된다.
          */
      }

      @Override
      protected void onRestart() {
          super.onRestart();
          String s = et.getText().toString();
          // testview를 edit에 입력된 string으로 바꾼다.
          tv.setText(s);

          // testview를 아래의 String으로 고친다.
          // tv.setText("Hello java and Android");
      }
  }

</code>

* 4번째 방법

<code>
 
         findViewById(R.id.first_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = et.getText().toString();
                tv.setText(s);
                et.setText("");
            }
        });
        
</code>

## 금일 실습
1. 메세지 받으면 메시지 내용을 출력하는 기능. (Screen - MyReceiver.java)

<code>

    Bundle bundle = intent.getExtras();
    if(bundle == null) return;
    Object[] messages = (Object[])bundle.get("pdus");
    SmsMessage[] smsMessage = new SmsMessage[messages.length];
    int n = 0;
    for(Object msg: messages){
    smsMessage[n++] = SmsMessage.createFromPdu((byte[]) msg);
    }
    Toast.makeText(context,"MyReceiver : " + smsMessage[0].getMessageBody(),Toast.LENGTH_LONG).show();

</code>

2. 별도의 project에서 상호 연결하는 기능. URI를 동일하게 연결하면 된다. (Screen-MyContentProvider.java와 MyResolver-MainActivity.java 연결)
  * A에서 B로 연결하려고 하면, B의 기능을 구현할 때 설정한 URI를 A에서 아래의 코드처럼 동일하게 만들어서, A에서 활용한다.

<code>

    final String authory = "com.edu.multi";
    Uri myUri = Uri.parse("content://"+authory);

</code>

3. Button, TextView, EditText 등 UI 기본적인 사용법과 state(reStart 등) 변환에 따른 text 변경 (UITest)

4. TouchEvent, ClickEvent, KeyEvent 사용 방법
