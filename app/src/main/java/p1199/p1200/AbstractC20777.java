package p1199.p1200;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: 䃑.ứ.ứ */
/* loaded from: classes5.dex */
public interface AbstractC20777 extends IInterface {

    /* renamed from: 䃑.ứ.ứ$ứ */
    /* loaded from: classes5.dex */
    public static abstract class AbstractBinderC20778 extends Binder implements AbstractC20777 {

        /* renamed from: ዼ */
        public static final /* synthetic */ int f67453 = 0;

        /* renamed from: 䃑.ứ.ứ$ứ$ứ */
        /* loaded from: classes5.dex */
        public static class C20779 implements AbstractC20777 {

            /* renamed from: ዼ */
            public IBinder f67454;

            public C20779(IBinder iBinder) {
                this.f67454 = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f67454;
            }

            @Override // p1199.p1200.AbstractC20777
            /* renamed from: 䃏 */
            public void mo40(boolean z) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.content.ISyncAdapterUnsyncableAccountCallback");
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.f67454.transact(1, obtain, null, 1)) {
                        int i = AbstractBinderC20778.f67453;
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                } finally {
                    obtain.recycle();
                }
            }
        }
    }

    /* renamed from: 䃏 */
    void mo40(boolean z);
}