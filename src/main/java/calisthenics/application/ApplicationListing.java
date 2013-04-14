package calisthenics.application;

import calisthenics.application.maps.ApplicationToJobSeekers;
import calisthenics.application.reductions.SeekersWhoHaveAppliedForJob;
import calisthenics.interfaces.Listing;
import calisthenics.interfaces.Map;
import calisthenics.interfaces.Reduction;
import calisthenics.jobseeker.JobSeekerListing;
import calisthenics.jobseeker.JobSeeker;
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
    public <A> Listing<Application> reduce(Reduction<Application, A> reduction, A element) {
        return reduction.reduce(applications, element);
    }

    @Override
    public <A> Listing<A> map(Map<Application, A> map, Listing<Application> data) {
        return map.map(applications);
    }

    public static ApplicationListing empty() {
        Collection<Application> setOfApplications = new HashSet<Application>();
        return new ApplicationListing(setOfApplications);
    }

    public boolean hasApplicationFromSeeker(JobSeeker jobSeeker) {
        Predicate<Application> seekersWhoHaveAppliedForJob = new SeekersWhoHaveAppliedForJob(jobSeeker);
        Collection<Application> applicationsFromSeeker = Collections2.filter(applications, seekersWhoHaveAppliedForJob);
        return !(applicationsFromSeeker.isEmpty());
    }

    public JobSeekerListing allSeekersWhoHaveAppliedForJob() {
        Map<Application, JobSeeker> applicationsToJobSeekers = new ApplicationToJobSeekers();
        return (JobSeekerListing) applicationsToJobSeekers.map(applications);
    }
}