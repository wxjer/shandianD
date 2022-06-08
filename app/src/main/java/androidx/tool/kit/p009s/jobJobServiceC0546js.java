package androidx.tool.kit.p009s;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import androidx.tool.kit.C0538ct;

/* renamed from: androidx.tool.kit.s.js  reason: invalid class name */
/* loaded from: classes.dex */
public class jobJobServiceC0546js extends JobService {
    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        JobScheduler jobScheduler;
        int i = Build.VERSION.SDK_INT;
        if (i >= 24 && (jobScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE)) != null) {
            JobInfo.Builder persisted = new JobInfo.Builder(70, new ComponentName(this, jobJobServiceC0546js.class)).setPersisted(true);
            if (i < 24) {
                persisted.setPeriodic(5000L);
            } else {
                persisted.setMinimumLatency(5000L);
            }
            try {
                jobScheduler.schedule(persisted.build());
            } catch (Exception e) {
                String str = "scheduleService error: " + e.getMessage();
            }
        }
        C0538ct.m72393(this);
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}