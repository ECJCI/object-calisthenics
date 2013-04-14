package calisthenics.job;

import calisthenics.application.Application;
import calisthenics.records.ApplicationListing;
import calisthenics.interfaces.ATS;
import calisthenics.interfaces.JReq;
import calisthenics.jobseeker.JobSeeker;
import calisthenics.records.JobSeekerListing;
import calisthenics.recruiter.Recruiter;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;


public class JobFactory {

    public Job<ATS> createATSJob(Recruiter recruiter){
        Collection<Application> applications = new ArrayList<Application>();
        ApplicationListing applicationListing = new ApplicationListing(applications);

        HashSet<JobSeeker> setOfSeekersWhoHaveSavedJobs = new HashSet<JobSeeker>();
        JobSeekerListing seekersWhoHaveSavedJob = new JobSeekerListing(setOfSeekersWhoHaveSavedJobs);
        Title title = new Title("The best job");

        JobInformation jobInformation = new JobInformation(recruiter, seekersWhoHaveSavedJob, title);
        Job<ATS> job = new Job<ATS>(jobInformation, applicationListing);

        return job;
    }

    public Job<JReq> createJReqJob(Recruiter recruiter){
        Collection<Application> applications = new ArrayList<Application>();
        ApplicationListing applicationListing = new ApplicationListing(applications);

        HashSet<JobSeeker> setOfSeekersWhoHaveSavedJobs = new HashSet<JobSeeker>();
        JobSeekerListing seekersWhoHaveSavedJob = new JobSeekerListing(setOfSeekersWhoHaveSavedJobs);

        Title title = new Title("Great Job");
        JobInformation jobInformation = new JobInformation(recruiter, seekersWhoHaveSavedJob, title);
        Job<JReq> job = new Job<JReq>(jobInformation, applicationListing);

        return job;
    }

}