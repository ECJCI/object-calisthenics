package calisthenics.recruiter;

import calisthenics.application.Application;
import calisthenics.application.ApplicationListing;
import calisthenics.job.Job;
import calisthenics.job.JobInformation;
import calisthenics.job.JobListing;
import calisthenics.jobseeker.JobSeekerListing;
import calisthenics.jobseeker.JobSeeker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class Recruiter {

    private JobListing listing;
    private JobSeekerListing jobSeekerListing;

    public Recruiter(JobListing listing, JobSeekerListing jobSeekerListing) {
        this.listing = listing;
        this.jobSeekerListing = jobSeekerListing;
    }

    public void post(Job job) {
       listing.add(job);
    }

    public JobListing jobPosts() {
        return listing.jobsByRecruiterId(this);
    }

    public Job createJob() {
        Collection<Application> applications = new ArrayList<Application>();
        ApplicationListing applicationListing = new ApplicationListing(applications);
        HashSet<JobSeeker> setOfSeekersWhoHaveSavedJobs = new HashSet<JobSeeker>();
        JobSeekerListing seekersWhoHaveSavedJob = new JobSeekerListing(setOfSeekersWhoHaveSavedJobs);

        JobInformation jobInformation = new JobInformation(this, seekersWhoHaveSavedJob);
        Job job = new Job(jobInformation, applicationListing);
        return job;
    }

    public JobSeekerListing jobSeekersWhoHaveAppliedForJob(Job job) {
        boolean isJobListed =  jobPosts().isListed(job);
        JobSeekerListing seekersWhoHaveApplied = jobSeekerListing.jobSeekersWhoHaveAppliedToJob(job);
        JobSeekerListing emptyListing = JobSeekerListing.empty();

        return isJobListed ? seekersWhoHaveApplied  : emptyListing;
    }

}