package calisthenics.job;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ejones
 * Date: 4/9/13
 * Time: 3:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class Job {
    private RecruiterId id;

    public Job(RecruiterId id) {
        this.id = id;
    }

    public static class JobListing {
        private List<Job> jobs;

        public JobListing(List<Job> jobList) {
            this.jobs = jobList;
        }

        public int PostCount() {
            return jobs.size();
        }

        public void AddJob(Job job) {
           jobs.add(job);
        }

        public JobListing JobsByRecruiterId(RecruiterId id) {
            Predicate<Job> predicate = new Predicate<Job>();

            JobListing jobsWithSpecificId = new JobListing(Collections2.filter(jobs, predicate));
            return jobsWithSpecificId;
        }
    }
}
