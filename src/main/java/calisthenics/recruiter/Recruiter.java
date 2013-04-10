package calisthenics.recruiter;

import calisthenics.job.Job;

public class Recruiter {

    private Job.JobListing listing;
    private RecruiterId id;

    public Recruiter(Job.JobListing listing) {
        this.listing = listing;
        id = new RecruiterId();
    }

    public void Post(Job job) {
       listing.AddJob(job);
    }

    public RecruiterId Id() {
        return id;
    }

    public Job.JobListing JobPosts() {
        return listing.JobsByRecruiterId(id);
    }
}


