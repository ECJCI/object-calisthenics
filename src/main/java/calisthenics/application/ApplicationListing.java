package calisthenics.application;

import calisthenics.application.queries.SeekersWhoHaveAppliedForJob;
import calisthenics.jobseeker.SeekerId;
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

    public boolean hasApplicationFromSeeker(SeekerId seekerId) {
        Predicate seekersWhoHaveAppliedForJob = new SeekersWhoHaveAppliedForJob(seekerId);
        Collection<Application> applicationsFromSeeker = Collections2.filter(applications, seekersWhoHaveAppliedForJob);
        return !(applicationsFromSeeker.isEmpty());
    }
}
