package calisthenics.job;

import calisthenics.recruiter.RecruiterId;

import java.util.ArrayList;
import java.util.List;

public class JobListing {
    private List<Job> jobs;

    public JobListing(List<Job> jobList) {
        this.jobs = jobList;
    }

    public int PostCount() {
        return jobs.size();
    }

    public void AddJob(Job job) {
        jobs.add(job);
    }

    public JobListing JobsByRecruiterId(RecruiterId id) {
        JobListing jobsWithSpecificId = new JobListing(new ArrayList<Job>());
        return jobsWithSpecificId;
    }
}
