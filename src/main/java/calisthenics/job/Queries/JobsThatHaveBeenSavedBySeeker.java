package calisthenics.job.Queries;

import calisthenics.job.Job;
import calisthenics.jobseeker.SeekerId;
import com.google.common.base.Predicate;

public class JobsThatHaveBeenSavedBySeeker implements Predicate<Job> {
    private final SeekerId id;

    public JobsThatHaveBeenSavedBySeeker(SeekerId id) {
        this.id = id;
    }
    @Override
    public boolean apply(Job job) {
        return job.isJobSaved(id);
    }
}
