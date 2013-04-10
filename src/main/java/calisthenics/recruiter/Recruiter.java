package calisthenics.recruiter;

import calisthenics.job.Job;
import calisthenics.job.JobListing;

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

    public JobListing JobPosts() {
        return listing.jobsByRecruiterId(id);
    }
}


