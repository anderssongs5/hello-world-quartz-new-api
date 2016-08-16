package quartz.examples.trigger.simple;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import quartz.examples.trigger.HelloWorldJob;

public class SimpleTriggerHW {

    public static void main(String[] args) throws SchedulerException {
        JobDetail job = JobBuilder.newJob(HelloWorldJob.class).withIdentity("jobDetailExample", "group1").build();

        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("simpleTriggerExample", "group2")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever()).build();

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);
    }
}
