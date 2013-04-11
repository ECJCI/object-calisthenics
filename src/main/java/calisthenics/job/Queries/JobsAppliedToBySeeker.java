package calisthenics.job.queries;

import calisthenics.job.Job;
import calisthenics.jobseeker.SeekerId;
import com.google.common.base.Predicate;

public class JobsAppliedToBySeeker implements Predicate<Job> {
    private SeekerId seekerId;

    public JobsAppliedToBySeeker(SeekerId seekerId) {
        this.seekerId = seekerId;
    }

    @Override
    public boolean apply(Job job) {
        return job.hasSeekerAppliedToJob(seekerId);
    }
}
