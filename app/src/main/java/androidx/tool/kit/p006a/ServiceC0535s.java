package androidx.tool.kit.p006a;
import androidx.tool.kit.C0538ct;
import com.tencent.mmkv.MMKV;
import p1010.p1011.p1012.p1014.ServiceC20087;
import p1166.p1167.p1168.p1169.BinderC20658;

/* renamed from: androidx.tool.kit.a.s */
/* loaded from: classes.dex */
public class ServiceC0535s extends ServiceC20087 {
    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f65874 = new BinderC20658(getApplicationContext());
        C0538ct.m72392(this, MMKV.defaultMMKV().decodeInt("dd"));
    }
}