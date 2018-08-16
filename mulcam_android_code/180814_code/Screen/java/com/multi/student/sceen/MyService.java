package com.multi.student.sceen;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this,"onCreate() ", Toast.LENGTH_SHORT).show();
        Log.e("MyService","onCreate()");
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,"onStartCommand() ", Toast.LENGTH_SHORT).show();
        Log.e("MyService","onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("MyService","onDestroy()");
        Toast.makeText(this,"onDestroy() ", Toast.LENGTH_SHORT).show();
    }

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
