package calisthenics.application;

import calisthenics.interfaces.ApplicationType;
import calisthenics.jobseeker.JobSeeker;
import calisthenics.resume.Resume;

;

public class Application<T extends ApplicationType> {
    private JobSeeker jobSeeker;
    private Resume resume;

    public Application(JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
        this.resume = null;
    }

    public <WithResume> Application(JobSeeker jobSeeker, Resume resume) {
        this.jobSeeker = jobSeeker;
        this.resume = resume;
    }

    public boolean createdBySeeker(JobSeeker jobSeeker) {
        return this.jobSeeker.equals(jobSeeker);
    }

    public JobSeeker getJobSeekerId() {
        return jobSeeker;
    }
}
