package androidx.tool.kit.c;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;

import androidx.tool.kit.C0538ct;
import androidx.tool.kit.p007c.itr;

@SuppressLint({"UnsafeDynamicallyLoadedCode"})
/* renamed from: androidx.tool.kit.c.nn */
/* loaded from: classes.dex */
public class nn {
    public static ComponentName sCN = new ComponentName(C0538ct.context, itr.class);

    static {
        System.loadLibrary("qfq_jni");
    }

    /* renamed from: a */
    public static native void a(String str, String str2, String str3, String str4);

    /* renamed from: b */
    public static void b() {
        Context context = C0538ct.context;
        if (context != null) {
            context.startInstrumentation(sCN, null, null);
        }else {
            Log.d("ServiceC20086", "context is null: ");
        }
    }
}