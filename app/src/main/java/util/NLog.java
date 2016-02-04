package util;

import android.util.Log;

import com.zhihu.chuankris.myapplication.preferrence.ServiceConst;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class NLog {
    private static boolean UI_DEBUG = ServiceConst.mBOOl_DEBUG;
    ;
    private static boolean OUT_TO_FILE = true;
    private static String LOG = "zhihulog";
    private static String logFileName = "zhihulog.log";

    public NLog() {

    }

    public static String getLogDir() {
        String path = PhysicalStorage.getExternalStorageRootPath() + File.separator + LOG;
        if (!new File(path).exists()) {
            if (!new File(path).mkdirs()) {
                Log.w("NLog", "can not create log dir");
            }
        }
        return path;
    }

    public static void clearLogFile() {
        String logFilePath = PhysicalStorage.getExternalStorageRootPath();

        File file = new File(logFilePath + "/" + logFileName);
        //	    File file = new File(LOG_FILE_PATH);
        if (file.exists()) {
            file.delete();
        }
    }

    public static void writeToLog(String tag, String msg) {
        if (!OUT_TO_FILE) {
            return;
        }

        if (!(android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED))) {
            return;
        }

        Date now = new Date();
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT);
        String time = df.format(now);

        String log = time + " " + tag + ": " + msg + "\n";
        String logFilePath = PhysicalStorage.getExternalStorageRootPath();


        File file = new File(logFilePath + "/" + logFileName);
        if (!file.exists()) {
            try {
                file.createNewFile();

            } catch (IOException e) {

                e.printStackTrace();
            }
        }
        BufferedWriter output;
        try {
            output = new BufferedWriter(new FileWriter(file, true), 512);
            output.write(log);
            output.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public static int v(String tag, String msg) {
        if (UI_DEBUG && tag != null && msg != null) {
            writeToLog(tag, msg);
            return android.util.Log.v(tag, msg);

        } else {
            return 0;
        }
    }

    public static int v(String tag, String msg, Throwable tr) {
        if (UI_DEBUG && tag != null && msg != null) {
            writeToLog(tag, msg + " " + tr.getMessage());
            return android.util.Log.v(tag, msg, tr);
        } else {
            return 0;
        }
    }

    public static int d(String tag, String msg) {
        if (UI_DEBUG && tag != null && msg != null) {
            writeToLog(tag, msg);
            return android.util.Log.d(tag, msg);
        } else {
            return 0;
        }
    }

    public static int d(String tag, String msg, Throwable tr) {
        if (UI_DEBUG && tag != null && msg != null) {
            writeToLog(tag, msg + " " + tr.getMessage());
            return android.util.Log.d(tag, msg, tr);
        } else {
            return 0;
        }
    }

    public static int i(String tag, String msg) {
        if (UI_DEBUG && tag != null && msg != null) {
            writeToLog(tag, msg);
            return android.util.Log.i(tag, msg);
        } else {
            return 0;
        }
    }

    public static int i(String tag, String msg, Throwable tr) {
        if (UI_DEBUG && tag != null && msg != null) {
            writeToLog(tag, msg + " " + tr.getMessage());
            return android.util.Log.i(tag, msg, tr);
        } else {
            return 0;
        }
    }

    public static int w(String tag, String msg) {
        if (UI_DEBUG && tag != null && msg != null) {
            writeToLog(tag, msg);
            return android.util.Log.w(tag, msg);
        } else {
            return 0;
        }
    }

    public static int w(String tag, String msg, Throwable tr) {
        if (UI_DEBUG && tag != null && msg != null) {
            writeToLog(tag, msg + " " + tr.getMessage());
            return android.util.Log.w(tag, msg, tr);
        } else {
            return 0;
        }
    }

    public static boolean isLoggable(String arg0, int arg1) {
        if (UI_DEBUG) {
            return android.util.Log.isLoggable(arg0, arg1);
        } else {
            return false;
        }
    }

    public static int w(String tag, Throwable tr) {
        if (UI_DEBUG) {
            writeToLog(tag, tr.getMessage());
            return android.util.Log.w(tag, tr);
        } else {
            return 0;
        }
    }

    public static int e(String tag, String msg) {
        if (UI_DEBUG && tag != null && msg != null) {
            writeToLog(tag, msg);
            return android.util.Log.e(tag, msg);
        } else {
            return 0;
        }
    }

    public static int e(String tag, String msg, Throwable tr) {
        if (UI_DEBUG && tag != null && msg != null) {
            writeToLog(tag, msg + " " + tr.getMessage());
            return android.util.Log.e(tag, msg, tr);
        } else {
            return 0;
        }
    }

    public static String getStackTraceString(Throwable tr) {
        if (UI_DEBUG) {
            return android.util.Log.getStackTraceString(tr);
        } else {
            return (" ");
        }
    }

    public static int println(int arg0, String arg1, String arg2) {
        if (UI_DEBUG) {
            writeToLog(arg1, arg2);
            return android.util.Log.println(arg0, arg1, arg2);
        } else {
            return 0;
        }
    }
}
