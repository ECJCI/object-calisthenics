package calisthenics.jobseeker;

import calisthenics.interfaces.Listing;
import calisthenics.interfaces.Query;
import calisthenics.job.Job;

import java.util.Collection;
import java.util.HashSet;

public class JobSeekerListing implements Listing<JobSeeker> {
    private Collection<JobSeeker> jobSeekers;

    public JobSeekerListing(Collection<JobSeeker> jobSeekers) {
        this.jobSeekers = jobSeekers;
    }

    public static JobSeekerListing empty() {
        return new JobSeekerListing(new HashSet<JobSeeker>());
    }

    public JobSeekerListing jobSeekersWhoHaveAppliedToJob(Job job){
        return null;
    }

    @Override
    public boolean isListed(JobSeeker jobSeeker) {
        return jobSeekers.contains(jobSeeker);
    }

    @Override
    public void add(JobSeeker jobSeeker) {
     jobSeekers.add(jobSeeker);
    }

    @Override
    public boolean contains(JobSeeker jobSeeker) {
        return jobSeekers.contains(jobSeeker);
    }

    @Override
    public Listing<JobSeeker> query(Query<JobSeeker> query, Object element) {
        return query.query(jobSeekers, element);
    }

}