package calisthenics.job.queries;

import calisthenics.job.Job;
import calisthenics.recruiter.RecruiterId;
import com.google.common.base.Predicate;

public class JobsCreatedByRecruiter implements Predicate<Job> {
    private final RecruiterId id;

    public JobsCreatedByRecruiter(RecruiterId id) {
        this.id = id;
    }
    @Override
    public boolean apply(Job job) {
        return job.doesJobBelongToRecruiter(id);
    }
}
