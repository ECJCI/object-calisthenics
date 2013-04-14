package calisthenics.recruiter;

import calisthenics.interfaces.ATS;
import calisthenics.interfaces.JReq;
import calisthenics.job.*;
import calisthenics.interfaces.Displayable;
import calisthenics.records.JobListing;
import calisthenics.records.JobSeekerListing;

import javax.naming.Name;

public class Recruiter implements Displayable {

    private JobListing listing;
    private JobSeekerListing jobSeekerListing;
    private JobFactory jobFactory;
    private Title name;

    public Recruiter(JobListing listing, JobSeekerListing jobSeekerListing, JobFactory jobFactory, Title name) {
        this.listing = listing;
        this.jobSeekerListing = jobSeekerListing;
        this.jobFactory = jobFactory;
        this.name = name;
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

    @Override
    public void display() {
        System.out.print(name);
    }
}