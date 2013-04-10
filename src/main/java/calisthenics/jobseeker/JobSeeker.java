package calisthenics.jobseeker;

import calisthenics.job.Job;
import calisthenics.job.JobListing;

public class JobSeeker {
    private JobListing savedJobs;

    public JobSeeker(JobListing savedJobs) {
        this.savedJobs = savedJobs;
    }

    public void saveJob(Job job) {
       savedJobs.addJob(job);
    }

    public boolean isJobSaved(Job job) {
        return savedJobs.isJobListed(job);
    }
}
