package calisthenics.job.queries.predicates;

import calisthenics.job.Job;
import calisthenics.jobseeker.JobSeeker;
import com.google.common.base.Predicate;

public class JobsThatHaveBeenSavedByJobSeeker implements Predicate<Job> {
    private final JobSeeker jobSeeker;

    public JobsThatHaveBeenSavedByJobSeeker(JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }
    @Override
    public boolean apply(Job job) {
        return job.isJobSaved(jobSeeker);
    }
}
