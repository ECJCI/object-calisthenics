package calisthenics.job.queries.predicates;

import calisthenics.job.Job;
import calisthenics.jobseeker.JobSeeker;
import com.google.common.base.Predicate;

public class JobsAppliedToBySeekerPredicate implements Predicate<Job> {
    private JobSeeker jobSeeker;

    public JobsAppliedToBySeekerPredicate(JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }

    @Override
    public boolean apply(Job job) {
        return job.hasSeekerAppliedToJob(jobSeeker);
    }
}
