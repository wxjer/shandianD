package p1166.p1167.p1168.p1169;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;

/* renamed from: 㻆.ứ.ứ.ዼ.㒧 */
/* loaded from: classes5.dex */
public class C20659 {

    /* renamed from: ዼ */
    public static String accountType = "";

    /* renamed from: ứ */
    public static String accountName = "";

    /* renamed from: 㒧 */
    public static String accountAuthority = "";

    /* JADX WARN: Type inference failed for: r0v0, types: [android.accounts.AccountManager, junk0.uwspli9.dqgum41.Cxlmct22Activity] */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.os.Bundle, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1, types: [void] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String, int] */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.accounts.Account, android.app.Activity] */
    /* renamed from: ዼ */
    public static void m402(Context context) {
        if (context != null) {
            AccountManager accountManager = AccountManager.get(context);
            if (accountManager != null) {
                if (TextUtils.isEmpty(accountName)) {
                    accountName = m401(context, "sync_account_name");
                }
                if (TextUtils.isEmpty(accountType)) {
                    accountType = m401(context, "sync_account_type");
                }
                if (TextUtils.isEmpty(accountAuthority)) {
                    accountAuthority = m401(context, "sync_account_authority");
                }
                Account account = new Account(accountName,accountType);
                try {
                    Account[] arrayOfAccount = accountManager.getAccountsByType(accountType);
                    if (arrayOfAccount.length <= 0) {
                        accountManager.addAccountExplicitly(account, null, Bundle.EMPTY);
                        ContentResolver.setIsSyncable(account, accountAuthority, 1);
                        ContentResolver.setSyncAutomatically(account, accountAuthority, true);
                        ContentResolver.setMasterSyncAutomatically(true);
                    }
                    Bundle bundle = Bundle.EMPTY;
                    ContentResolver.removePeriodicSync(account, accountAuthority, bundle);
                    ContentResolver.addPeriodicSync(account, accountName, bundle, Build.VERSION.SDK_INT >= 24 ? 900L :3600L);
                    m400(context, account, false);
                } catch (Exception unused) {
                }
            }
        }

    }

    /* renamed from: ứ */
    public static String m401(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return context.getString(context.getResources().getIdentifier(str, "string", context.getPackageName()));
    }

    /* renamed from: 㒧 */
    public static void m400(Context context, Account account, boolean z) {
        if (context != null && TextUtils.isEmpty(accountAuthority)) {
            accountAuthority = m401(context, "sync_account_authority");
        }
        String str = accountAuthority;
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("force", true);
            bundle.putBoolean("expedited", true);
            if (z) {
                bundle.putBoolean("require_charging", false);
            }
            ContentResolver.requestSync(account, str, bundle);
        } catch (Exception unused) {
        }
    }
}