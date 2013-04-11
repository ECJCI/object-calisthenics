package calisthenics.application.queries;

import calisthenics.application.Application;
import calisthenics.jobseeker.SeekerId;
import com.google.common.base.Predicate;

public class SeekersWhoHaveAppliedForJob implements Predicate<Application> {
    private SeekerId seekerId;

    public SeekersWhoHaveAppliedForJob(SeekerId seekerId) {
        this.seekerId = seekerId;
    }

    @Override
    public boolean apply(Application application) {
        return application.createdBySeeker(seekerId);
    }
}
