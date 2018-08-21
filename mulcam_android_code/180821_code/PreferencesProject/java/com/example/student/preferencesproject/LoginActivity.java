package com.example.student.preferencesproject;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Map;
import java.util.Set;

public class LoginActivity extends AppCompatActivity {

    CheckBox save;
    EditText UserID;
    EditText UserPW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        save=(CheckBox)findViewById(R.id.SaveID);
        UserID = (EditText)findViewById(R.id.UserID);
        UserPW = (EditText)findViewById(R.id.UserPW);
        //혹시 저장되있던게 있으면 불러오기
        SharedPreferences account =
                getSharedPreferences("account", 0);
        String check_ID = account.getString("ID", "");
        String check_PW = account.getString("PW", "");

        if(check_ID!=null && check_PW!=null){
            UserID.setText(check_ID);
            UserPW.setText(check_PW);
            Toast.makeText(this, "저장된 데이터를 불러왔습니다.", Toast.LENGTH_SHORT).show();
        }
    }

    public void login(View v){
        // 체크박스 상태에 따라서 preference 여부 결정
        boolean flag = save.isChecked();

        if(flag){
            // id, pw 저장
            SharedPreferences account =
                    getSharedPreferences("account", 0);
            Toast.makeText(this, "저장되었습니다.", Toast.LENGTH_SHORT).show();

            SharedPreferences.Editor editor = account.edit();
            editor.putString("ID", UserID.getText().toString());
            editor.putString("PW", UserPW.getText().toString());
            editor.apply(); // commit 역할

            UserID.setText("");
            UserPW.setText("");
            Toast.makeText(this, "체크 하여 로그인 되었습니다.", Toast.LENGTH_SHORT).show();
        } else {
            SharedPreferences account =
                    getSharedPreferences("account", 0);

            SharedPreferences.Editor editor = account.edit();
            editor.remove("ID");
            editor.remove("PW");

            Toast.makeText(this, "저장내역을 삭제하였습니다.", Toast.LENGTH_SHORT).show();

            UserID.setText("");
            UserPW.setText("");
            Toast.makeText(this, "체크 없이 로그인 되었습니다.", Toast.LENGTH_SHORT).show();
            editor.apply(); // commit 역할
            //SharedPreferences에 지난 번 저장된 것 삭제하고 id, pw도 지우고 toast
        }
    }
}
