package calisthenics.application;

import calisthenics.application.Application;

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
}
