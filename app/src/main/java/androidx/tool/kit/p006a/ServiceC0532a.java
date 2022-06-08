package androidx.tool.kit.p006a;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

/* renamed from: androidx.tool.kit.a.a */
/* loaded from: classes.dex */
public class ServiceC0532a extends Service {

    /* renamed from: 㠻 */
    public C0533 f42;

    /* renamed from: androidx.tool.kit.a.a$㠻 */
    /* loaded from: classes.dex */
    public static class C0533 extends AbstractAccountAuthenticator {
        public C0533(Context context) {
            super(context);
        }

        @Override // android.accounts.AbstractAccountAuthenticator
        public Bundle addAccount(AccountAuthenticatorResponse accountAuthenticatorResponse, String str, String str2, String[] strArr, Bundle bundle) {
            return null;
        }

        @Override // android.accounts.AbstractAccountAuthenticator
        public Bundle confirmCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, Bundle bundle) {
            return null;
        }

        @Override // android.accounts.AbstractAccountAuthenticator
        public Bundle editProperties(AccountAuthenticatorResponse accountAuthenticatorResponse, String str) {
            return null;
        }

        @Override // android.accounts.AbstractAccountAuthenticator
        public Bundle getAuthToken(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
            return null;
        }

        @Override // android.accounts.AbstractAccountAuthenticator
        public String getAuthTokenLabel(String str) {
            return null;
        }

        @Override // android.accounts.AbstractAccountAuthenticator
        public Bundle hasFeatures(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String[] strArr) {
            return null;
        }

        @Override // android.accounts.AbstractAccountAuthenticator
        public Bundle updateCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
            return null;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f42.getIBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f42 = new C0533(this);
    }
}