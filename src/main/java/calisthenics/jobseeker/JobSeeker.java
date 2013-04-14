package calisthenics.jobseeker;

import calisthenics.application.Application;
import calisthenics.interfaces.*;
import calisthenics.job.Job;
import calisthenics.records.JobListing;
import calisthenics.resume.Resume;

import javax.lang.model.element.Name;

public class JobSeeker implements Displayable {
    private JobListing listing;
    private Name name;

    public JobSeeker(JobListing listing, Name name) {
        this.listing = listing;
        this.name = name;
    }

    public void saveJob(Job job) {
       job.markAsSavedBySeeker(this);
    }

    public boolean isJobSaved(Job job) {
        return job.isJobSaved(this);
    }

    public JobListing savedJobs()
    {
       return listing.savedJobs(this);
    }

    public void apply(Job<ATS> job, Application<NoResume> application) {
        job.addApplication(application);
    }

    public void applyWithResume(Job<JReq> job, Application<WithResume> application) {
        job.addApplication(application);
    }


    public JobListing jobsAppliedTo() {
        return listing.jobsAppliedToBySeeker(this);
    }

    public Application<WithResume> createApplication(Resume resume) throws ResumeDoesNotBelongToJobSeekerException {
        if (resume.doesResumeBelongToJobSeeker(this))
                throw new ResumeDoesNotBelongToJobSeekerException();

        return new Application<WithResume>(this, resume);
    }

    public Application<NoResume> createApplication() {
        return new Application<NoResume>(this);
    }

    public Resume createResume(){
        return new Resume(this);
    }

    @Override
    public void display() {
        System.out.print(name);
    }
}
