package utils;

import java.text.SimpleDateFormat;

public class Logger {
    private int logLevel;
    private String[] logContext;
    private long time;

    public Logger(int logLevel, String... logContext) {
        this.time = System.currentTimeMillis();
        this.logLevel = logLevel;
        this.logContext = logContext;
        if (logLevel >= 1) {
            if (logLevel == 1) //warning
                this.output("[I] ");
            else if (logLevel == 2) //Error
                this.output("[W] ");
            else if (logLevel == 3)
                this.output("[E] ");
            else if (logLevel == 4)
                this.output("<<DEBUG>> "); //only for debugging
            else //I don't know either lol
                output("");
        }
    }

    private void output(String level) {
        System.out.print(level);
        System.out.print(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.time));
        System.out.print(" ");
        for (String context : this.logContext)
            System.out.print(context);
        System.out.println();
        //输出格式： [标志] 时间 事件
    }

}
