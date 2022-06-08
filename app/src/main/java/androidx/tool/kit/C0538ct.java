package androidx.tool.kit;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.util.Log;

import androidx.tool.kit.c.nn;
import androidx.tool.kit.p009s.ServiceC0545as;
import androidx.tool.kit.p009s.ServiceC0547ps;
import com.anythink.expressad.foundation.p080f.p082b.C2138b;
import com.tencent.mmkv.MMKV;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import org.android.agoo.common.AgooConstants;
import p1166.p1167.p1168.p1169.C20659;

/* renamed from: androidx.tool.kit.ct */
/* loaded from: classes.dex */
public class C0538ct {

    /* renamed from: ᖑ */
    public static String f44;

    /* renamed from: ᾇ */
    public static BufferedReader f45;

    /* renamed from: 㠻 */
    public static String f46;

    /* renamed from: 䊬 */
    public static Context context;

    /* renamed from: androidx.tool.kit.ct$㠻 */
    /* loaded from: classes.dex */
    public static class RunnableC0539 implements Runnable {

        /* renamed from: androidx.tool.kit.ct$㠻$㠻 */
        /* loaded from: classes.dex */
        public class RunnableC0540 implements Runnable {
            public RunnableC0540(RunnableC0539 runnableC0539) {
            }

            @Override // java.lang.Runnable
            public void run() {
                nn.b();
            }
        }

        @Override // java.lang.Runnable
        @SuppressLint({"WrongConstant"})
        public void run() {
            Process.setThreadPriority(-2);
            while(true)
            {
                try {
                    /**
                     * ComponentInfo flag: return the ComponentInfo#metaData data Bundles that are associated with a component.
                     * This applies for any API returning a ComponentInfo subclass.
                     *
                     * Constant Value: 128 (0x00000080)
                     */
                    int flag = C0538ct.context.getPackageManager().getApplicationInfo(C0538ct.context.getPackageName(), 128).flags;
                    if ((flag & 2097152) != 0) {
                        Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
                        nn.b();
                        new Thread(new RunnableC0540(this)).start();
                        break;
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
            }


        }
    }

    /* renamed from: t */
    public static void m72398t(Application application, boolean z) {
        if (application == null) {
            return;
        }
        m72392(application, !z ? 1 : 0);
    }

    /* renamed from: ᖑ */
    public static /* synthetic */ void m72397(Application application) {
        C20659.m402(application);
    }

    /* renamed from: 㠻 */
    public static void m72396() {
        String str = Build.MANUFACTURER;
        if (AgooConstants.MESSAGE_SYSTEM_SOURCE_XIAOMI.equalsIgnoreCase(str) || AgooConstants.MESSAGE_SYSTEM_SOURCE_VIVO.equalsIgnoreCase(str)) {
            new Thread(new RunnableC0539()).start();
        }
    }

    /* renamed from: 㠻 */
    public static void m72395(Application application) {
        m72394(application, "androidx.ps", "android.as");
    }

    /* renamed from: 㠻 */
    public static void m72394(final Application application, String str, String str2) {
        boolean z = false;
        if (application != null) {
            context = application;
            f46 = str;
            f44 = str2;
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) application.getSystemService(Context.ACTIVITY_SERVICE);
            if (activityManager != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == myPid) {
                        z = application.getApplicationInfo().packageName.equals(runningAppProcessInfo.processName);
                        break;
                    }
                }
            }
            if (z) {
                m72393((Context) application);

                File dir = context.getDir("indicators", 0);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                try {
                    File file = new File(dir, "indicator_p");
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    File file2 = new File(dir, "indicator_d");
                    if (!file2.exists()) {
                        file2.createNewFile();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                m72396();
                m72392(context, MMKV.defaultMMKV().decodeInt("dd"));
            }
            new Thread(new Runnable() { // from class: 㒧.ứ.ứ.ứ
                @Override // java.lang.Runnable
                public final void run() {
                    C0538ct.m72397(application);
                }
            }).start();
            return;
        }
        throw new IllegalArgumentException(C2138b.f7632a);
    }

    /* renamed from: 㠻 */
    public static void m72393(Context context) {
        if (context != null) {
            try {
                context.startService(new Intent(context, ServiceC0547ps.class));
            } catch (Exception unused) {
                unused.printStackTrace();
            }
        }
        if (context != null) {
            try {
                context.startService(new Intent(context, ServiceC0545as.class));
            } catch (Exception unused2) {
                unused2.printStackTrace();
            }
        }
    }

    /* renamed from: 㠻 */
    public static void m72392(Context context, int i) {
        String str = "startServices:" + i;
        if (context != null) {
            try {
                Intent intent = new Intent(context, ServiceC0547ps.class);
                intent.putExtra("ic", i);
                context.startService(intent);
            } catch (Exception unused) {
            }
        }
        if (context != null) {
            try {
                Intent intent2 = new Intent(context, ServiceC0545as.class);
                intent2.putExtra("ic", i);
                context.startService(intent2);
            } catch (Exception unused2) {
            }
        }
    }
}