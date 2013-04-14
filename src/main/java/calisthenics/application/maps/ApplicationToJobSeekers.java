package calisthenics.application.maps;

import calisthenics.application.Application;
import calisthenics.application.maps.transformations.ApplicationToJobSeekersTransFormation;
import calisthenics.interfaces.Listing;
import calisthenics.interfaces.Map;
import calisthenics.jobseeker.JobSeeker;
import calisthenics.jobseeker.JobSeekerListing;
import com.google.common.base.Function;
import com.google.common.collect.Collections2;

import java.util.Collection;

public class ApplicationToJobSeekers implements Map<Application, JobSeeker> {

    @Override
    public Listing<JobSeeker> map(Collection<Application> applications) {
        Function<Application, JobSeeker> applicationsToSeeker = new ApplicationToJobSeekersTransFormation();
        Collection<JobSeeker> result = Collections2.transform(applications, applicationsToSeeker);
        return new JobSeekerListing(result);
    }
}
