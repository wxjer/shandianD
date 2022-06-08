package p1166.p1167.p1168;
import androidx.tool.kit.C0538ct;
import androidx.tool.kit.c.nn;
import java.io.File;

/* renamed from: 㻆.ứ.ứ.ứ */
/* loaded from: classes4.dex */
public class C20660 extends Thread {

    /* renamed from: ዼ */
    public final /* synthetic */ String f67308;

    /* renamed from: ぞ */
    public final /* synthetic */ String f67309;

    /* renamed from: 㒧 */
    public final /* synthetic */ String f67310;

    /* renamed from: 㺀 */
    public final /* synthetic */ String f67311;

    public C20660(String str, String str2, String str3, String str4) {
        this.f67308 = str;
        this.f67310 = str2;
        this.f67311 = str3;
        this.f67309 = str4;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        File dir = C0538ct.context.getDir("indicators", 0);
        nn.a(new File(dir, this.f67308).getAbsolutePath(), new File(dir, this.f67310).getAbsolutePath(), new File(dir, this.f67311).getAbsolutePath(), new File(dir, this.f67309).getAbsolutePath());
    }
}