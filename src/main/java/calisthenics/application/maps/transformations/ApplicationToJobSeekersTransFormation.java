package calisthenics.application.maps.transformations;

import calisthenics.application.Application;
import calisthenics.jobseeker.JobSeeker;
import com.google.common.base.Function;


public class ApplicationToJobSeekersTransFormation implements Function<Application, JobSeeker> {
    @Override
    public JobSeeker apply(Application application) {
        return application.getJobSeekerId();
    }
}
