package calisthenics.application;

import calisthenics.application.queries.SeekersWhoHaveAppliedForJob;
import calisthenics.interfaces.Listing;
import calisthenics.interfaces.Query;
import calisthenics.jobseeker.JobSeekerListing;
import calisthenics.jobseeker.JobSeeker;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

import java.util.Collection;
import java.util.HashSet;

public class ApplicationListing implements Listing<Application> {
    private Collection<Application> applications;

    public ApplicationListing(Collection<Application> applications) {
        this.applications = applications;
    }

    @Override
    public boolean isListed(Application element) {
       return applications.contains(element);
    }

    @Override
    public void add(Application application) {
        applications.add(application);
    }

    @Override
    public boolean contains(Application application) {
        return applications.contains(application);
    }

    @Override
    public Listing<Application> query(Query<Application> query, Object element) {
        return query.query(applications, element);
    }


    public static ApplicationListing empty() {
        Collection<Application> setOfApplications = new HashSet<Application>();
        return new ApplicationListing(setOfApplications);
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