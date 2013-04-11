package calisthenics.application.queries;

import calisthenics.application.Application;
import calisthenics.jobseeker.JobSeeker;
import com.google.common.base.Predicate;

public class SeekersWhoHaveAppliedForJob implements Predicate<Application> {
    private JobSeeker jobSeeker;

    public SeekersWhoHaveAppliedForJob(JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }

    @Override
    public boolean apply(Application application) {
        return application.createdBySeeker(jobSeeker);
    }
}
