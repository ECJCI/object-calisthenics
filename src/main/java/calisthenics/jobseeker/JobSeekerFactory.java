package calisthenics.jobseeker;

import calisthenics.job.JobListing;

public class JobSeekerFactory {
    private JobSeekerListing jobSeekerListing;
    private JobListing jobListing;

    public JobSeekerFactory(JobSeekerListing  jobSeekerListing, JobListing jobListing ) {
        this.jobSeekerListing = jobSeekerListing;
        this.jobListing = jobListing;
    }

    public JobSeeker create() {
        JobSeeker jobSeeker = new JobSeeker(jobListing);
        jobSeekerListing.add(jobSeeker);
        return jobSeeker;
    }
}
