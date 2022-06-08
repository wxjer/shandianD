package com.example.shandianbaodemo;

import android.content.Context;
import android.os.Environment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.Subject;

public class LogUtils {
    private SimpleDateFormat simpleDateFormat;
    private String logFilePath = "",state = "存活";
    private Context context;
    private long startTime;
    private File fileStr;

    private static class holder {
        private static final LogUtils instance = new LogUtils();
    }

    public static LogUtils instance() {
        return holder.instance;
    }
    public void init(Context context){
        this.context = context;
        startTime = System.currentTimeMillis();
        makeFile();
    }
    public void setState(String state){
        this.state = state;
    }
    public void startTime() {
        //long 值是从小到大，倒计时需要将值倒置
        int count = 100;
        Observable.interval(0, 30, TimeUnit.SECONDS)//设置0延迟，每隔一秒发送一条数据
                .take((int) (count + 1)) //设置总共发送的次数
                .map(aLong -> count - aLong)
                .subscribeOn(Schedulers.computation())
                // doOnSubscribe 执行线程由下游逻辑最近的 subscribeOn() 控制，下游没有 subscribeOn() 则跟Subscriber 在同一线程执行
                //执行计时任务前先将 button 设置为不可点击
                .observeOn(Schedulers.io())//操作UI主要在UI线程
                .subscribe(new Subject<Long>() {
                    @Override
                    public boolean hasObservers() {
                        return false;
                    }

                    @Override
                    public boolean hasThrowable() {
                        return false;
                    }

                    @Override
                    public boolean hasComplete() {
                        return false;
                    }

                    @Nullable
                    @Override
                    public Throwable getThrowable() {
                        return null;
                    }

                    @Override
                    protected void subscribeActual(Observer<? super Long> observer) {

                    }

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                    }

                    @Override
                    public void onNext(@NonNull Long aLong) {
                        try {
                            String message = "  interval："+((System.currentTimeMillis()-startTime)/1000)+"s"+
                                    "  state："+ state;
                            writeStringToFile(message);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        startTime();
                    }
                });
    }
    private void makeFile() {
        this.logFilePath = Environment.getExternalStorageDirectory() + File.separator + "Android" + File.separator + "data" + File.separator + context.getPackageName() + File.separator + "DaemonLog";
        File file = new File(this.logFilePath);
        createFileDirectors(logFilePath);
        if (!file.exists()) {
            boolean mkdirs = file.mkdirs();
            if (mkdirs) {
                fileStr = new File(file, "logs.txt");
            }
        } else {
            fileStr = new File(file, "logs.txt");;
        }
    }

    public static void createFileDirectors(String fileDir) {
        String[] fileDirs=fileDir.split("\\/");
        String topPath="";
        for (int i = 0; i < fileDirs.length; i++) {
            topPath+="/"+fileDirs[i];
            File file = new File(topPath);
            if (file.exists()) {
                continue;
            }else {
                file.mkdir();
            }
        }
    }
    public void writeStringToFile(final String message) {
        new Thread(new Runnable() {
            public void run() {
                FileOutputStream outputStream = null;

                try {
//                    ByteArrayInputStream inputStream = new ByteArrayInputStream(message.getBytes());
//                    fileStr = new File(file, "logs.txt");
//                    outputStream = new FileOutputStream(new File(file, "logs.txt"));
////                    int lenx = false;
//                    byte[] bytes = new byte[1024];
//
//                    int len;
//                    while((len = inputStream.read(bytes)) != -1) {
//                        outputStream.write(bytes, 0, len);
//                    }
//
//                    outputStream.flush();
                    setAppendFile("time:"+ getDataStr()+message);
//                    Log.e("Log写入", message+"写入本地文件成功：" + fileStr.getAbsolutePath());
                } catch (Exception var15) {
                    var15.printStackTrace();
                }

            }
        }).start();
    }

    /**
     * 将文本追加写入到文件
     */
    private void setAppendFile(String value) {
        FileWriter fw;
        BufferedWriter bw;
        PrintWriter printWriter = null;
        try {
            fw = new FileWriter(fileStr, true);
            bw = new BufferedWriter(fw);
            printWriter = new PrintWriter(bw);
            printWriter.println(value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }

    /**
     * 获取格式化日期
     * @return
     */
    private String getDataStr(){
        return getSdf().format(new Date());
    }
    private SimpleDateFormat getSdf() {
        if (simpleDateFormat == null) {
            simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd HH:mm:ss.SSS ", Locale.getDefault());
        }
        return simpleDateFormat;
    }
}
