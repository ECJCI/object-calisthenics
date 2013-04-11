package calisthenics.job;

import calisthenics.jobseeker.SeekerId;

import java.util.HashSet;

public class JobSeekerListing {
    private HashSet<SeekerId> seekersWhoSavedJob;

    public JobSeekerListing(HashSet<SeekerId> seekersWhoSavedJob) {
        this.seekersWhoSavedJob = seekersWhoSavedJob;
    }

    public boolean isJobSeekerListed(SeekerId seekerId) {
        return seekersWhoSavedJob.contains(seekerId);
    }

    public void addJobSeeker(SeekerId seekerId) {
        seekersWhoSavedJob.add(seekerId);
    }
}