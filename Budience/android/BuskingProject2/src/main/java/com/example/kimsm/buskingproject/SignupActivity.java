package com.example.kimsm.buskingproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class SignupActivity extends AppCompatActivity {
EditText new_id;
EditText new_pass;
EditText pass_check;
EditText name;
EditText nickname;
EditText email;
EditText phone;
ArrayList<Spinner> genres;
ArrayList<Spinner> spots;
ArrayList<ArrayAdapter<String>> genadapt;
ArrayList<ArrayAdapter<String>> spotadapt;
ArrayList<String> genremember;
ArrayList<String> spotmember;
LinearLayout ge1,ge2;
LinearLayout sp1,sp2;
ArrayList<LinearLayout> ge;
ArrayList<LinearLayout> sp;
String getemp;
String sptemp;
ArrayList<String> genret = new ArrayList<String>();
ArrayList<String> spott = new ArrayList<String>();
int genrenum, spotnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        new_id = (EditText)findViewById(R.id.new_id);
        new_pass = (EditText)findViewById(R.id.new_pass);
        pass_check = (EditText)findViewById(R.id.pass_check);
        name = (EditText)findViewById(R.id.name);
        nickname = (EditText)findViewById(R.id.nickname);
        email = (EditText)findViewById(R.id.email);
        phone = (EditText)findViewById(R.id.phone);
        genres = new ArrayList<Spinner>();
        spots = new ArrayList<Spinner>();
        genres.add((Spinner)findViewById(R.id.genre));
        genres.add((Spinner)findViewById(R.id.genre1));
        genres.add((Spinner)findViewById(R.id.genre2));
        spots.add((Spinner) findViewById(R.id.spot));
        spots.add((Spinner) findViewById(R.id.spot1));
        spots.add((Spinner) findViewById(R.id.spot2));
        ge = new ArrayList<LinearLayout>();
        ge.add((LinearLayout)findViewById(R.id.ge1));
        ge.add((LinearLayout)findViewById(R.id.ge2));
        sp = new ArrayList<LinearLayout>();
        sp.add((LinearLayout)findViewById(R.id.sp1));
        sp.add((LinearLayout)findViewById(R.id.sp2));
        genadapt = new ArrayList<ArrayAdapter<String>>();
        spotadapt = new ArrayList<ArrayAdapter<String>>();
        genremember = new ArrayList<String>();
        spotmember = new ArrayList<String>();
        genremember.add("선택하세요");
        genremember.add("발라드");
        genremember.add("댄스");
        genremember.add("랩/힙합");
        genremember.add("인디음악");
        genremember.add("클래식");
        spotmember.add("선택하세요");
        spotmember.add("홍대");
        spotmember.add("신촌");
        spotmember.add("혜화");
        spotmember.add("뚝섬");
        spotmember.add("이태원");
        for(int i =0;i<3;i++)
        {
            genadapt.add(new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,genremember));
            spotadapt.add(new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,spotmember));
            genres.get(i).setAdapter(genadapt.get(i));
            spots.get(i).setAdapter(spotadapt.get(i));
            genres.get(i).setOnItemSelectedListener(new MyOnItemSelectedLIstener());
            spots.get(i).setOnItemSelectedListener(new MyOnItemSelectedLIstener2());
        }

        genrenum=1;
        spotnum=1;
    }
    public class MyOnItemSelectedLIstener implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            getemp = parent.getItemAtPosition(position).toString();

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }
    public class MyOnItemSelectedLIstener2 implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            sptemp = parent.getItemAtPosition(position).toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 100) {
            if(resultCode == 200){
                finish();
            }
        }
    }

    public void addm(View v) {
        if(v.getId()==R.id.genrep) {
            if (genrenum < 3) {
                ge.get(genrenum - 1).setVisibility(View.VISIBLE);
                genret.add(genrenum-1,getemp);
                genrenum++;
            }
        }

        if(v.getId()==R.id.genrem) {
            if (genrenum > 1) {
                ge.get(genrenum - 2).setVisibility(View.GONE);
                genret.remove(genrenum-1);
                genrenum--;
            }
        }
        if(v.getId()==R.id.spotp) {
            if (spotnum < 3) {
                sp.get(spotnum - 1).setVisibility(View.VISIBLE);
                spott.add(spotnum-1,sptemp);
                spotnum++;
            }
        }

        if(v.getId()==R.id.spotm) {
            if (spotnum > 1) {
                sp.get(spotnum - 2).setVisibility(View.GONE);
                spott.remove(spotnum-1);
                spotnum--;
            }
        }
    }
    public void approve(View v)
    {

        String id = new_id.getText().toString();
        String pass = new_pass.getText().toString();
        String check = pass_check.getText().toString();
        String namet = name.getText().toString();
        String nicknamet = nickname.getText().toString();
        String emailt = email.getText().toString();
        String phonet = phone.getText().toString();


        if(pass.equals(check)) {
            Intent i = new Intent(this,SendSignup.class);
            i.putExtra("id",id);
            i.putExtra("pass",pass);
            i.putExtra("name",namet);
            i.putExtra("nickname",nicknamet);
            i.putExtra("email",emailt);
            i.putExtra("phone",phonet);
            genret.add(genrenum-1,getemp);
            spott.add(spotnum-1,sptemp);
            i.putStringArrayListExtra("genres",genret);
            i.putStringArrayListExtra("spots",spott);
            i.putExtra("genrenum",genrenum);
            i.putExtra("spotnum",spotnum);

            startActivityForResult(i,100);
         }
        else
        {
            new_pass.setText("");
            pass_check.setText("");
            Toast.makeText(this, "비밀번호가 일치 하지 않습니다.", Toast.LENGTH_SHORT).show();
        }

    }
}
