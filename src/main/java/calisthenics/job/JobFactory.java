package calisthenics.job;

import calisthenics.application.Application;
import calisthenics.application.ApplicationListing;
import calisthenics.job.Job;
import calisthenics.job.JobInformation;
import calisthenics.jobseeker.JobSeeker;
import calisthenics.jobseeker.JobSeekerListing;
import calisthenics.recruiter.Recruiter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;


public class JobFactory {

    public Job createJob(Recruiter recruiter){
        Collection<Application> applications = new ArrayList<Application>();
        ApplicationListing applicationListing = new ApplicationListing(applications);

        HashSet<JobSeeker> setOfSeekersWhoHaveSavedJobs = new HashSet<JobSeeker>();
        JobSeekerListing seekersWhoHaveSavedJob = new JobSeekerListing(setOfSeekersWhoHaveSavedJobs);

        JobInformation jobInformation = new JobInformation(recruiter, seekersWhoHaveSavedJob);
        Job job = new Job(jobInformation, applicationListing);

        return job;
    }
}