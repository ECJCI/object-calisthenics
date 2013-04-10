package calisthenics.job;

import calisthenics.recruiter.RecruiterId;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

import java.util.Collection;

public class JobListing {
    private Collection<Job> jobs;

    public JobListing(Collection<Job> jobList) {
        this.jobs = jobList;
    }

    public int PostCount() {
        return jobs.size();
    }

    public void AddJob(Job job) {
        jobs.add(job);
    }

    public JobListing JobsByRecruiterId(final RecruiterId id) {

        Predicate<Job> belongsToRecruiter = new BelongsToRecruiter(id);
        Collection<Job> jobsWithSpecificId = Collections2.filter(jobs, belongsToRecruiter) ;
        return new JobListing(jobsWithSpecificId);
    }

    public boolean IsJobListed(Job job) {
        return jobs.contains(job);
    }

    private class BelongsToRecruiter implements Predicate<Job>{
        private final RecruiterId id;

        public BelongsToRecruiter(RecruiterId id) {
            this.id = id;
        }

        @Override
        public boolean apply(Job job) {
            return job.getId().equals(id);
        }
    }
}
