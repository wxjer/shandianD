package p1199.p1200;
import android.content.SyncResult;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: 䃑.ứ.ዼ */
/* loaded from: classes5.dex */
public interface AbstractC20774 extends IInterface {

    /* renamed from: 䃑.ứ.ዼ$ứ */
    /* loaded from: classes5.dex */
    public static abstract class AbstractBinderC20775 extends Binder implements AbstractC20774 {

        /* renamed from: ዼ */
        public static final /* synthetic */ int f67451 = 0;

        /* renamed from: 䃑.ứ.ዼ$ứ$ứ */
        /* loaded from: classes5.dex */
        public static class C20776 implements AbstractC20774 {

            /* renamed from: ዼ */
            public IBinder f67452;

            public C20776(IBinder iBinder) {
                this.f67452 = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f67452;
            }

            @Override // p1199.p1200.AbstractC20774
            /* renamed from: 䃑 */
            public void mo41(SyncResult syncResult) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.content.ISyncContext");
                    if (syncResult != null) {
                        obtain.writeInt(1);
                        syncResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f67452.transact(2, obtain, obtain2, 0)) {
                        int i = AbstractBinderC20775.f67451;
                    }
                    obtain2.readException();
                } catch (RemoteException e) {
                    e.printStackTrace();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* renamed from: 㽔 */
        public static AbstractC20774 m42(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.content.ISyncContext");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof AbstractC20774)) ? new C20776(iBinder) : (AbstractC20774) queryLocalInterface;
        }
    }

    /* renamed from: 䃑 */
    void mo41(SyncResult syncResult);
}