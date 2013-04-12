package calisthenics.application;

import calisthenics.jobseeker.JobSeeker;

public class Application {
    private JobSeeker jobSeeker;

    public Application(JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }

    public boolean createdBySeeker(JobSeeker jobSeeker) {
        return this.jobSeeker.equals(jobSeeker);
    }

    public JobSeeker getJobSeekerId() {
        return jobSeeker;
    }

}
