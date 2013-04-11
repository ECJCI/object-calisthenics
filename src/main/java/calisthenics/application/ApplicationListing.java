package calisthenics.application;

import calisthenics.application.queries.SeekersWhoHaveAppliedForJob;
import calisthenics.job.JobSeekerListing;
import calisthenics.jobseeker.JobSeeker;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

import java.util.Collection;

public class ApplicationListing {
    private Collection<Application> applications;

    public ApplicationListing(Collection<Application> applications) {
        this.applications = applications;
    }

    public void add(Application application) {
        applications.add(application);
    }

    public boolean containsApplication(Application application) {
        return applications.contains(application);
    }

    public boolean hasApplicationFromSeeker(JobSeeker jobSeeker) {
        Predicate seekersWhoHaveAppliedForJob = new SeekersWhoHaveAppliedForJob(jobSeeker);
        Collection<Application> applicationsFromSeeker = Collections2.filter(applications, seekersWhoHaveAppliedForJob);
        return !(applicationsFromSeeker.isEmpty());
    }

    public JobSeekerListing allSeekersWhoHaveAppliedForJob() {
        Function applicationsToSeeker = new ApplicationToSeeker();
        Collection<JobSeeker> result = Collections2.transform(applications, applicationsToSeeker);
        return new JobSeekerListing(result);
    }

    class ApplicationToSeeker implements Function<Application, JobSeeker> {

        @Override
        public JobSeeker apply(Application application) {
            return application.getJobSeekerId();
        }
    }
}