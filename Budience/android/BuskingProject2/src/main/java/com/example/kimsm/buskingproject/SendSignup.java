package com.example.kimsm.buskingproject;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SendSignup extends AppCompatActivity {
    String id;
    String pass;
    String name;
    String nickname;
    String email;
    String phone;
    ArrayList<String> genres;
    ArrayList<String> spots;
    int genrenum,spotnum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_signup);
        Intent i = getIntent();
        id = i.getStringExtra("id");
        pass = i.getStringExtra("pass");
        name = i.getStringExtra("name");
        nickname = i.getStringExtra("nickname");
        email = i.getStringExtra("email");
        phone = i.getStringExtra("phone");
        genres = i.getStringArrayListExtra("genres");
        spots = i.getStringArrayListExtra("spots");
        genrenum= i.getIntExtra("genrenum",0);
        spotnum = i.getIntExtra("spotnum",0);

        IDPWAsync idpw = new IDPWAsync();
        idpw.execute();
        INFOAsync info = new INFOAsync();
        info.execute();
        Intent i1 = new Intent();
        setResult(200,i1);
        finish();

    }
    class INFOAsync extends AsyncTask<Void, String, Void> {
        @Override
        protected Void doInBackground(Void... voids) {//user thread

            onProgressUpdate(makePostRequest());
            return null;
        }
        @Override
        protected void onProgressUpdate(String... values) {//main thread
            super.onProgressUpdate(values);

        }
    }
    private String makePostRequest() {
        String msg = "";
        try {
            HttpClient httpClient = new DefaultHttpClient();
            // replace with your url
            HttpPost httpPost =
                    new HttpPost("http://1.233.141.140:7070/loginproject/JSP/userinfo.jsp");


            //Post Data
            List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(2);
            nameValuePair.add(new BasicNameValuePair("USER_ID", id));
            nameValuePair.add(new BasicNameValuePair("NAME", name));
            nameValuePair.add(new BasicNameValuePair("NICKNAME", nickname));
            nameValuePair.add(new BasicNameValuePair("EMAIL", email));
            nameValuePair.add(new BasicNameValuePair("PHONE", phone));
            for(int i=0;i<genrenum;i++)
            {
                nameValuePair.add(new BasicNameValuePair("GENRE"+i, genres.get(i)));
            }
            for(int i=0;i<spotnum;i++)
            {
                nameValuePair.add(new BasicNameValuePair("SPOT"+i, spots.get(i)));
            }

            //Encoding POST data
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(nameValuePair,"utf-8");
            httpPost.setEntity(entity);


            //making POST request.

            HttpResponse response = httpClient.execute(httpPost);
            //Log.d("Http Post Response:", response.toString());
            return response.toString();
            //EntityUtils.getContentCharSet(entity);
            // write response to log
            /*HttpEntity et = response.getEntity();
            InputStream in  = et.getContent();
                    //response.toString();*/

        } catch (Exception e) {
            // Log exception
            e.printStackTrace();
        }
        return msg;
    }

    class IDPWAsync extends AsyncTask<Void, String, Void> {

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            Toast.makeText(SendSignup.this, values[0], Toast.LENGTH_SHORT).show();
        }

        @Override
        protected Void doInBackground(Void... voids) {//user thread
            String url = "http://1.233.141.140:7070/loginproject/JSP/signUp.jsp";
            String param = "?id=" + id + "&pw=" + pass;
            Document xml = null;
            String u = url + param;
            try {
                xml = Jsoup.connect(u).get();//url에 접속해서 xml파일을 받아옴
            } catch (IOException e) {
                e.printStackTrace();
            }
            Elements result = xml.select("data");
            for(Element e:result)
                publishProgress(e.select("result").text());

            return null;
        }
    }
}
