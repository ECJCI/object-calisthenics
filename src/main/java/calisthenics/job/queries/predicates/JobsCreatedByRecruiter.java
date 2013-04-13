package calisthenics.job.queries.predicates;

import calisthenics.job.Job;
import calisthenics.recruiter.Recruiter;
import com.google.common.base.Predicate;

public class JobsCreatedByRecruiter implements Predicate<Job> {
    private final Recruiter recruiter;

    public JobsCreatedByRecruiter(Recruiter recruiter) {
        this.recruiter = recruiter;
    }

    @Override
    public boolean apply(Job job) {
        return job.doesJobBelongToRecruiter(recruiter);
    }
}
