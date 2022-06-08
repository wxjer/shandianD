package p1199.p1200;
import android.accounts.Account;
import android.content.SyncResult;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

import p1166.p1167.p1168.p1169.BinderC20658;
import p1166.p1167.p1168.p1169.C20659;
import p1199.p1200.AbstractC20774;
import p1199.p1200.AbstractC20777;

/* renamed from: 䃑.ứ.㒧 */
/* loaded from: classes5.dex */
public abstract class AbstractBinderC20780 extends Binder implements IInterface {
    public AbstractBinderC20780() {
        attachInterface(this, "android.content.ISyncAdapter");
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        AbstractC20777 abstractC20777 = null;
        if (i == 1) {
            parcel.enforceInterface("android.content.ISyncAdapter");
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder != null) {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("android.content.ISyncAdapterUnsyncableAccountCallback");
                abstractC20777 = (queryLocalInterface == null || !(queryLocalInterface instanceof AbstractC20777)) ? new AbstractC20777.AbstractBinderC20778.C20779(readStrongBinder) : (AbstractC20777) queryLocalInterface;
            }
            try {
                abstractC20777.mo40(true);
            } catch (Throwable unused) {
            }
            return true;
        } else if (i != 2) {
            if (i != 3) {
                if (i != 1598968902) {
                    try {
                        return super.onTransact(i, parcel, parcel2, i2);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                parcel2.writeString("android.content.ISyncAdapter");
                return true;
            }
            parcel.enforceInterface("android.content.ISyncAdapter");
            AbstractC20774.AbstractBinderC20775.m42(parcel.readStrongBinder());
            C20659.m400(((BinderC20658) this).f67304, null, false);
            return true;
        } else {
            parcel.enforceInterface("android.content.ISyncAdapter");
            AbstractC20774 m42 = AbstractC20774.AbstractBinderC20775.m42(parcel.readStrongBinder());
            parcel.readString();
            if (parcel.readInt() != 0) {
                Account account = (Account) Account.CREATOR.createFromParcel(parcel);
            }
            Bundle bundle = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
            BinderC20658 binderC20658 = (BinderC20658) this;
            try {
                SyncResult syncResult = new SyncResult();
                syncResult.stats.numIoExceptions = 1L;
                if (bundle == null || !bundle.getBoolean("force", false)) {
                    m42.mo41(syncResult);
                } else if (bundle.getBoolean("ignore_backoff", false)) {
                    m42.mo41(SyncResult.ALREADY_IN_PROGRESS);
                } else {
                    m42.mo41(syncResult);
                    C20659.m400(binderC20658.f67304, null, false);
                }
            } catch (Throwable unused2) {
            }
            return true;
        }
    }
}