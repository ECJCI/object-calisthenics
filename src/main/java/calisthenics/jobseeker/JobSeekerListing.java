package calisthenics.jobseeker;

import calisthenics.interfaces.Listing;
import calisthenics.interfaces.Map;
import calisthenics.interfaces.Reduction;
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
        return null ;
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
    public <A> Listing<JobSeeker> reduce(Reduction<JobSeeker, A> reduction, A element) {
        return reduction.reduce(jobSeekers, element);
    }

    @Override
    public <A> Listing<A> map(Map<JobSeeker, A> map, Listing<JobSeeker> data) {
        return map.map(jobSeekers);
    }

}