package tk.zytekaron.jvar.timer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RunnableTimer {
    private ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    private long delay;
    private TimeUnit unit;
    private Runnable runnable;
    
    public RunnableTimer(Runnable runnable) {
        this.runnable = runnable;
    }
    
    public RunnableTimer(long delay, TimeUnit unit, Runnable runnable) {
        this.delay = delay;
        this.unit = unit;
        this.runnable = runnable;
    }
    
    public void run() {
        scheduledExecutorService.schedule(runnable, delay, unit);
    }
    
    public void run(long delay, TimeUnit unit) {
        scheduledExecutorService.schedule(runnable, delay, unit);
    }
    
    public void schedule() {
        scheduledExecutorService.schedule(runnable, delay, unit);
    }
    
    public void schedule(long delay, TimeUnit unit) {
        scheduledExecutorService.schedule(runnable, delay, unit);
    }
}