package vip.qufenqian.cleaner;
import android.Manifest;
import android.app.Activity;
import android.app.Application;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;

import androidx.core.app.ActivityCompat;
import androidx.tool.kit.C0538ct;

import com.example.shandianbaodemo.LogUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;


/* JADX WARN: Classes with same name are omitted:
  classes5.dex
 */
/* loaded from: shandianbao.apk:vip/qufenqian/cleaner/CleanerApplication.classtemp */
public class CleanerApplication extends Application {


    @Override // vip.qqf.common_library.application.CommonApplication, ran2.iox6.vawknpv.QfqBaseApplication, android.app.Application
    public void onCreate() {
        super.onCreate();
        C0538ct.m72398t((Application) this, false);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                processInMain(this);
            }
        }else {
            processInMain(this);
        }
    }

    public static void processInMain(Application application) {
        String processName = getProcessName2();
        if (Objects.equals(processName, application.getPackageName()))
        {
            LogUtils.instance().init(application);
            LogUtils.instance().startTime();
        }
    }

     public static String getProcessName2() {
        BufferedReader mBufferedReader = null;
        try {
            File file = new File("/proc/self/cmdline");
            mBufferedReader = new BufferedReader(new FileReader(file));
            return mBufferedReader.readLine().trim();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (mBufferedReader != null) {
                try {
                    mBufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}