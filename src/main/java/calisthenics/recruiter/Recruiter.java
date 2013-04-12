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
    private RecruiterId id;

    public Recruiter(JobListing listing, JobSeekerListing jobSeekerListing) {
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
        HashSet<JobSeeker> setOfSeekersWhoHaveSavedJobs = new HashSet<JobSeeker>();
        JobSeekerListing seekersWhoHaveSavedJob = new JobSeekerListing(setOfSeekersWhoHaveSavedJobs);

        JobInformation jobInformation = new JobInformation(id, seekersWhoHaveSavedJob);
        Job job = new Job(jobInformation, applicationListing);
        return job;
    }

    public JobSeekerListing seekersWhoHaveAppliedForJob(Job job) {
        boolean isJobListed =  jobPosts().isJobListed(job);
        JobSeekerListing seekersWhoHaveApplied = job.allApplicants();
        JobSeekerListing emptyListing = JobSeekerListing.empty();

        return isJobListed ? seekersWhoHaveApplied  : emptyListing;
    }
}