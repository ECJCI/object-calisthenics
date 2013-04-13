package calisthenics.job;

import calisthenics.interfaces.Listing;
import calisthenics.interfaces.Query;
import calisthenics.job.queries.JobsByRecruiter;
import calisthenics.job.queries.JobsAppliedTo;
import calisthenics.job.queries.SavedJobs;
import calisthenics.jobseeker.JobSeeker;
import calisthenics.recruiter.Recruiter;

import java.util.Collection;
import java.util.HashSet;

public class JobListing implements Listing<Job> {
    private Collection<Job> jobs;

    public JobListing(Collection<Job> jobList) {
        this.jobs = jobList;
    }

    public int postCount() {
        return jobs.size();
    }

    public JobListing jobsByRecruiterId(Recruiter recruiter) {
       return (JobListing) query(new JobsByRecruiter(), recruiter);
    }

    public JobListing savedJobs(JobSeeker jobSeeker) {
        return (JobListing) query(new SavedJobs(), jobSeeker);
    }

    public JobListing jobsAppliedToBySeeker(JobSeeker jobSeeker) {
        return (JobListing) query(new JobsAppliedTo(), jobSeeker);
    }

    @Override
    public boolean isListed(Job job) {
        return jobs.contains(job);
    }

    @Override
    public void add(Job job) {
        jobs.add(job);
    }

    @Override
    public boolean contains(Job job) {
        return jobs.contains(job);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Listing<Job> query(Query<Job> query, Object element) {
        return query.query(jobs, element);
    }

    public static JobListing empty() {
        return new JobListing(new HashSet<Job>());
    }
}