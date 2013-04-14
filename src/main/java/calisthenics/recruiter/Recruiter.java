package calisthenics.recruiter;

import calisthenics.job.*;
import calisthenics.jobseeker.JobSeekerListing;

public class Recruiter {

    private JobListing listing;
    private JobSeekerListing jobSeekerListing;
    private JobFactory jobFactory;

    public Recruiter(JobListing listing, JobSeekerListing jobSeekerListing, JobFactory jobFactory) {
        this.listing = listing;
        this.jobSeekerListing = jobSeekerListing;
        this.jobFactory = jobFactory;
    }

    public void post(Job job) {
       listing.add(job);
    }

    public JobListing jobPosts() {
        return listing.jobsByRecruiterId(this);
    }

    public Job<ATS> createATSJob() {
      return jobFactory.createATSJob(this);
    }

    public Job<JReq> createJReqJob() {
        return jobFactory.createJReqJob(this);
    }

    public JobSeekerListing jobSeekersWhoHaveAppliedForJob(Job job) {
        boolean isJobListed =  jobPosts().isListed(job);
        JobSeekerListing seekersWhoHaveApplied = jobSeekerListing.jobSeekersWhoHaveAppliedToJob(job);
        JobSeekerListing emptyListing = JobSeekerListing.empty();

        return isJobListed ? seekersWhoHaveApplied  : emptyListing;
    }

}