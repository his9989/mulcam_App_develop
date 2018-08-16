package com.example.student.intentproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText UserID, UserPW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // DeitText타입으로 되어있는 xml에서의 UserID를 여기에 선언한 UserID에 저장
        UserID = (EditText) findViewById(R.id.UserID);
        UserPW = (EditText) findViewById(R.id.UserPW);
    }

    //사용자가 입력한 ID, PW를 받아온 후에 intent에 담아서
    //LoginCheckActivity로 보냄

    public void login(View v){
        //UserID라는 이름의 UI에서 text를 가져오고, 이를 String타입으로 바꿔준다.
        //EditText에 입력한 문자값을 가져옴
        String ID = UserID.getText().toString();
        String PW = UserPW.getText().toString();
        //intent 생성
        UserID.setText("");
        UserPW.setText("");
        Intent i = new Intent(this, LoginCheckActivity.class);
        //intent의 UserID, UserPW에 xml에 있는 EditText UI에 입력된 text를 넣는다.
        //"UserID, UserPW"는 데이터 이름, ID, PW가 데이터 값
        i.putExtra("UserID", ID);
        i.putExtra("UserPW", PW);
        //intent와 requestcode. LoginCheckActivity로 보내는 메시지
        startActivityForResult(i, 200);
    }

    //LoginCheckActivity를 다녀온 후 결과 처리하는 Activity. Callback method라고 부른다.
    //Callback method란, 사용자가 직접 호출하는게 아닌, 특정 조건이 되면 자동으로 호출된다.
    //즉, LoginChechActivity에서 finish로 되돌아왔을때 자동으로 호출되는 이름이 정해져있는 method
    // 여기서 requestCode가 200이면 로그인 관련 method가 되는거고, 다른 경우는 requestCode를 바꿔주면 된다.
    // ex) 계정 삭제 기능은 300이라 치면 밑에서 else if(requestCode==300)으로 예외처리한다.
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode==200){
            if(resultCode==1){          // 로그인 성공
                Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
            } else {                    // 로그인 실패
                Toast.makeText(this, "Login Fail", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
