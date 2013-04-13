package calisthenics.jobseeker;

import calisthenics.job.JobListing;

public class JobSeekerFactory {
    private JobListing jobListing;
    private JobSeekerListing jobSeekerListing;

    public JobSeekerFactory(JobListing jobListing, JobSeekerListing jobSeekerListing) {
        this.jobListing = jobListing;
        this.jobSeekerListing = jobSeekerListing;
    }

    public JobSeeker create() {
        JobSeeker jobSeeker = new JobSeeker(jobListing);
        jobSeekerListing.add(jobSeeker);
        return jobSeeker;
    }
}
