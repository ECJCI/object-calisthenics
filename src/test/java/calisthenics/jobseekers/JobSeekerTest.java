package calisthenics.jobseekers;

import calisthenics.application.Application;
import calisthenics.records.ApplicationListing;
import calisthenics.interfaces.ATS;
import calisthenics.interfaces.JReq;
import calisthenics.interfaces.NoResume;
import calisthenics.job.*;
import calisthenics.records.JobListing;
import calisthenics.records.JobSeekerListing;
import calisthenics.jobseeker.JobSeeker;
import calisthenics.jobseeker.JobSeekerFactory;
import calisthenics.recruiter.Recruiter;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class JobSeekerTest {
    private Collection<Job> jobs;
    private JobListing listing;
    private Collection<Job> savedJobs;
    private JobListing savedJobsListing;
    private Recruiter recruiter;
    private JobSeeker jobSeeker;
    private Job<ATS> job;
    private ApplicationListing applicationListing;
    private Collection<Application> applications;
    private JobSeekerListing seekersWhoHaveSavedJob;
    private Application<NoResume> application;
    private JobSeekerFactory jobSeekerFactory;
    private JobSeekerListing jobSeekerListing;
    private JobSeekerListing seekerListing;
    private JobFactory jobFactory;

    @Before
    public void setUp() throws Exception {
        //Listing that recruiters post to
        jobs = new ArrayList<Job>();
        listing = new JobListing(jobs);

        //snapshot listing that job seekers can save
        savedJobs = new ArrayList<Job>();
        savedJobsListing = new JobListing(savedJobs);

        jobFactory = new JobFactory();

        //recruiter creates and posts a job
        recruiter = new Recruiter(listing, jobSeekerListing, jobFactory, new Title("Him"));

        //job jobSeeker listing
        HashSet<JobSeeker> setOfSeekersWhoHaveSavedJobs = new HashSet<JobSeeker>();
        seekersWhoHaveSavedJob = new JobSeekerListing(setOfSeekersWhoHaveSavedJobs);

        applications = new ArrayList<Application>();
        applicationListing = new ApplicationListing(applications);

        job = recruiter.createATSJob();

        HashSet<JobSeeker> jobSeekers = new HashSet<JobSeeker>();
        jobSeekerListing = new JobSeekerListing(jobSeekers);

        jobSeekerFactory = new JobSeekerFactory(listing, jobSeekerListing);
        jobSeeker = jobSeekerFactory.create(null);
        application = jobSeeker.createApplication();
    }

    @Test
    public void testJobSeekersCanSaveJobsOnSiteForLaterViewing(){
        //Job Seeker saves the job
        jobSeeker.saveJob(job);

        //Job Seekers saved jobs should contain the job
        assertTrue(jobSeeker.isJobSaved(job));
    }

    @Test
    public void testJobSeekersCanApplyToJobsPostedByRecruiters(){
       Application<NoResume> application = jobSeeker.createApplication();
       recruiter.post(job);

       jobSeeker.apply(job, application);
       assertTrue(job.hasApplication(application));
    }

    @Test
    public void testJobSeekersShouldBeAbleToSeeAListingOfJobsTheyHaveSaved(){
        recruiter.post(job);
        jobSeeker.saveJob(job);
        JobListing savedJobs = jobSeeker.savedJobs();

        assertTrue(savedJobs.isListed(job));
    }

    @Test
    public void testJobSeekersShouldBeAbleToSeeAListingOfTheJobsForWhichTheyHaveApplied(){
        Job<ATS> jobAppliedTo = job;
        Job<JReq> jobNotAppliedTo = recruiter.createJReqJob();

        //recruiter posts a job
        recruiter.post(jobAppliedTo);
        recruiter.post(jobNotAppliedTo);

        //jobSeeker applies to job
        jobSeeker.apply(jobAppliedTo, application);

        //jobSeeker gets a listing of jobs applied to
        JobListing jobsAppliedTo = jobSeeker.jobsAppliedTo();

        System.out.print(listing.postCount());
        //job applied to should be in the job listing
        assertTrue(jobsAppliedTo.isListed(jobAppliedTo));

        //job not applied to should not be in the job listing
        assertFalse(jobsAppliedTo.isListed(jobNotAppliedTo));
    }
}