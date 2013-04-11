package calisthenics.job;

import calisthenics.job.Queries.JobsCreatedByRecruiter;
import calisthenics.job.Queries.JobsThatHaveBeenSavedBySeeker;
import calisthenics.jobseeker.SeekerId;
import calisthenics.recruiter.RecruiterId;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

import java.util.Collection;

public class JobListing {
    private Collection<Job> jobs;

    public JobListing(Collection<Job> jobList) {
        this.jobs = jobList;
    }

    public int postCount() {
        return jobs.size();
    }

    public void addJob(Job job) {
        jobs.add(job);
    }

    public JobListing jobsByRecruiterId(RecruiterId id) {

        Predicate<Job> belongsToRecruiter = new JobsCreatedByRecruiter(id);
        Collection<Job> jobsWithSpecificId = Collections2.filter(jobs, belongsToRecruiter) ;
        return new JobListing(jobsWithSpecificId);
    }

    public boolean isJobListed(Job job) {
        return jobs.contains(job);
    }

    public JobListing savedJobs(SeekerId seekerId) {
        Predicate<Job> isJobSaved = new JobsThatHaveBeenSavedBySeeker(seekerId);
        Collection<Job> jobsThatHaveBeenSavedBySeeker = Collections2.filter(jobs, isJobSaved);
        return new JobListing(jobsThatHaveBeenSavedBySeeker);
    }
}