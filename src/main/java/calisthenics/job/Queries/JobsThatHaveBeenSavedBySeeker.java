package calisthenics.job.queries;

import calisthenics.job.Job;
import calisthenics.jobseeker.JobSeeker;
import com.google.common.base.Predicate;

public class JobsThatHaveBeenSavedBySeeker implements Predicate<Job> {
    private final JobSeeker jobSeeker;

    public JobsThatHaveBeenSavedBySeeker(JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }
    @Override
    public boolean apply(Job job) {
        return job.isJobSaved(jobSeeker);
    }
}
