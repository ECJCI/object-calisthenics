package calisthenics.job.queries;

import calisthenics.job.Job;
import calisthenics.jobseeker.JobSeeker;
import com.google.common.base.Predicate;

public class JobsAppliedToBySeeker implements Predicate<Job> {
    private JobSeeker jobSeeker;

    public JobsAppliedToBySeeker(JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }

    @Override
    public boolean apply(Job job) {
        return job.hasSeekerAppliedToJob(jobSeeker);
    }
}
