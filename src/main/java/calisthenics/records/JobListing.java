package calisthenics.records;

import calisthenics.interfaces.Listing;
import calisthenics.interfaces.Map;
import calisthenics.interfaces.Reduction;
import calisthenics.job.Job;
import calisthenics.job.reductions.JobsByRecruiter;
import calisthenics.job.reductions.JobsAppliedTo;
import calisthenics.job.reductions.SavedJobs;
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
       return (JobListing) reduce(new JobsByRecruiter(), recruiter);
    }

    public JobListing savedJobs(JobSeeker jobSeeker) {
        return (JobListing) reduce(new SavedJobs(), jobSeeker);
    }

    public JobListing jobsAppliedToBySeeker(JobSeeker jobSeeker) {
        return (JobListing) reduce(new JobsAppliedTo(), jobSeeker);
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
    public <A> Listing<Job> reduce(Reduction<Job,A> reduction, A element) {
        return reduction.reduce(jobs, element);
    }

    @Override
    public <A> Listing<A> map(Map<Job, A> map, Listing<Job> data) {
        return map.map(jobs);
    }

    public static JobListing empty() {
        return new JobListing(new HashSet<Job>());
    }
}