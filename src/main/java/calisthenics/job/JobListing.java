package calisthenics.job;

import calisthenics.job.queries.JobsAppliedToBySeeker;
import calisthenics.job.queries.JobsCreatedByRecruiter;
import calisthenics.job.queries.JobsThatHaveBeenSavedBySeeker;
import calisthenics.jobseeker.JobSeeker;
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

    public JobListing savedJobs(JobSeeker jobSeeker) {
        Predicate<Job> isJobSaved = new JobsThatHaveBeenSavedBySeeker(jobSeeker);
        Collection<Job> jobsThatHaveBeenSavedBySeeker = Collections2.filter(jobs, isJobSaved);
        return new JobListing(jobsThatHaveBeenSavedBySeeker);
    }

    public JobListing jobsAppliedToBySeeker(JobSeeker jobSeeker) {
        Predicate<Job> hasAppliedToJob = new JobsAppliedToBySeeker(jobSeeker);
        Collection<Job> jobsThatSeekerHasAppliedTo = Collections2.filter(jobs, hasAppliedToJob);
        return new JobListing(jobsThatSeekerHasAppliedTo);
    }
}