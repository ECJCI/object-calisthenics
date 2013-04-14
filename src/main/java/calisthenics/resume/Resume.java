package calisthenics.resume;

import calisthenics.jobseeker.JobSeeker;

public class Resume {
    private final JobSeeker jobSeeker;

    public Resume(JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }

    public boolean doesResumeBelongToJobSeeker(JobSeeker jobSeeker){
        return this.jobSeeker.equals(jobSeeker);
    }

}
