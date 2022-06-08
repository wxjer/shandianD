package p1010.p1011.p1012.p1014;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import p1166.p1167.p1168.p1169.AbstractBinderC20657;

/* renamed from: ᖑ.㠻.㠻.㠻.ᾇ */
/* loaded from: classes5.dex */
public class ServiceC20087 extends Service {

    /* renamed from: 㠻 */
    public AbstractBinderC20657 f65874;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        AbstractBinderC20657 abstractBinderC20657 = this.f65874;
        if (abstractBinderC20657 != null) {
            abstractBinderC20657.getClass();
            return abstractBinderC20657;
        }
        return null;
    }
}