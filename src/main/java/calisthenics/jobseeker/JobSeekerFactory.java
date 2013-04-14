package calisthenics.jobseeker;

import calisthenics.records.JobListing;
import calisthenics.records.JobSeekerListing;

import javax.lang.model.element.Name;

public class JobSeekerFactory {
    private JobListing jobListing;
    private JobSeekerListing jobSeekerListing;

    public JobSeekerFactory(JobListing jobListing, JobSeekerListing jobSeekerListing) {
        this.jobListing = jobListing;
        this.jobSeekerListing = jobSeekerListing;
    }

    public JobSeeker create(Name name) {
        JobSeeker jobSeeker = new JobSeeker(jobListing, name);
        jobSeekerListing.add(jobSeeker);
        return jobSeeker;
    }
}
