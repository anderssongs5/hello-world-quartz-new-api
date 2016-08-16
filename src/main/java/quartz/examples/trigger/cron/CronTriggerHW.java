package quartz.examples.trigger.cron;

import java.text.ParseException;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import quartz.examples.trigger.HelloWorldJob;

public class CronTriggerHW {

    public static void main(String[] args) throws SchedulerException, ParseException {
        JobDetail job = JobBuilder.newJob(HelloWorldJob.class).withIdentity("jobDetailExample", "group1").build();

        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("cronTriggerExample", "group2")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/3 * * * * ?")).build();

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);
    }
}
