package calisthenics.job;

import calisthenics.jobseeker.JobSeeker;

import java.util.Collection;
import java.util.HashSet;

public class JobSeekerListing {
    private Collection<JobSeeker> seekersWhoSavedJob;

    public JobSeekerListing(Collection<JobSeeker> seekersWhoSavedJob) {
        this.seekersWhoSavedJob = seekersWhoSavedJob;
    }

    public boolean isJobSeekerListed(JobSeeker jobSeeker) {
        return seekersWhoSavedJob.contains(jobSeeker);
    }

    public void addJobSeeker(JobSeeker jobSeeker) {
        seekersWhoSavedJob.add(jobSeeker);
    }

    public static JobSeekerListing empty() {
        HashSet<JobSeeker> emptySet = new HashSet<JobSeeker>();
        return new JobSeekerListing(emptySet);
    }
}