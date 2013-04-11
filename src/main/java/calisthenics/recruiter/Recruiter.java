package calisthenics.recruiter;

import calisthenics.application.Application;
import calisthenics.application.ApplicationListing;
import calisthenics.job.*;

import java.util.ArrayList;
import java.util.Collection;

public class Recruiter {

    private JobListing listing;
    private RecruiterId id;

    public Recruiter(JobListing listing) {
        this.listing = listing;
        id = new RecruiterId();
    }

    public void post(Job job) {
       listing.addJob(job);
    }

    public RecruiterId Id() {
        return id;
    }

    public JobListing jobPosts() {
        return listing.jobsByRecruiterId(id);
    }

    public Job createJob() {
        Collection<Application> applications = new ArrayList<Application>();
        ApplicationListing applicationListing = new ApplicationListing(applications);

        JobInformation jobInformation = new JobInformation(id);

        Job job = new Job(jobInformation, applicationListing);
        return job;
    }
}