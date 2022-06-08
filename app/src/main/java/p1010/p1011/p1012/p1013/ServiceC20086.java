package p1010.p1011.p1012.p1013;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;

import androidx.tool.kit.C0538ct;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import p1166.p1167.p1168.C20660;

/* renamed from: ᖑ.㠻.㠻.ᾇ.㠻 */
/* loaded from: classes4.dex */
public class ServiceC20086 extends Service {

    /* renamed from: 㠻 */
    public boolean f65873 = false;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        Log.d("ServiceC20086", "onStartCommand: 0.0");

        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        String str;
        Log.d("ServiceC20086", "onStartCommand: 0");

        if (intent != null && intent.getIntExtra("ic", 0) > 0 && !this.f65873) {
            getApplication();
            Log.d("ServiceC20086", "onStartCommand: ");
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/proc/self/cmdline")));
                C0538ct.f45 = bufferedReader;
                str = bufferedReader.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                Log.d("ServiceC20086", "onStartCommand: 1");

                BufferedReader bufferedReader2 = C0538ct.f45;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    C0538ct.f45 = null;
                }
                this.f65873 = true;
            } else {
                Log.d("ServiceC20086", "onStartCommand: 2");
                if (str.startsWith(C0538ct.f46)) {
                    Log.d("ServiceC20086", "onStartCommand: 2.1");

                    new C20660("indicator_p", "indicator_d", "observer_p", "observer_d").start();
                    C0538ct.m72396();
                } else if (str.startsWith(C0538ct.f44)) {
                    Log.d("ServiceC20086", "onStartCommand: 2.2");

                    new C20660("indicator_d", "indicator_p", "observer_d", "observer_p").start();
                }
                BufferedReader bufferedReader3 = C0538ct.f45;
                if (bufferedReader3 != null) {
                    try {
                        bufferedReader3.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    C0538ct.f45 = null;
                }
                this.f65873 = true;
            }
        }
        return Service.START_STICKY;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
    }
}