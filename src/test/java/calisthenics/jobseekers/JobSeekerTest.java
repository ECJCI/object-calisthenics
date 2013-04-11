package calisthenics.jobseekers;

import calisthenics.application.Application;
import calisthenics.application.ApplicationListing;
import calisthenics.job.Job;
import calisthenics.job.JobListing;
import calisthenics.job.JobSeekerListing;
import calisthenics.jobseeker.JobSeeker;
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
    private Job job;
    private ApplicationListing applicationListing;
    private Collection<Application> applications;
    private JobSeekerListing seekersWhoHaveSavedJob;
    private Application application;

    @Before
    public void setUp() throws Exception {
        //Listing that recruiters post to
        jobs = new ArrayList<Job>();
        listing = new JobListing(jobs);

        //snapshot listing that job seekers can save
        savedJobs = new ArrayList<Job>();
        savedJobsListing = new JobListing(savedJobs);

        //recruiter creates and posts a job
        recruiter = new Recruiter(listing);

        //job jobSeeker listing
        HashSet<JobSeeker> setOfSeekersWhoHaveSavedJobs = new HashSet<JobSeeker>();
        seekersWhoHaveSavedJob = new JobSeekerListing(setOfSeekersWhoHaveSavedJobs);

        applications = new ArrayList<Application>();
        applicationListing = new ApplicationListing(applications);

        job = recruiter.createJob();

        jobSeeker = new JobSeeker(listing);
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
       Application application = jobSeeker.createApplication();
       recruiter.post(job);

       jobSeeker.applyToJob(job, application);
       assertTrue(job.hasApplication(application));
    }

    @Test
    public void testJobSeekersShouldBeAbleToSeeAListingOfJobsTheyHaveSaved(){
        recruiter.post(job);
        jobSeeker.saveJob(job);
        JobListing savedJobs = jobSeeker.savedJobs();

        assertTrue(savedJobs.isJobListed(job));
    }

    @Test
    public void testJobSeekersShouldBeAbleToSeeAListingOfTheJobsForWhichTheyHaveApplied(){
        Job jobAppliedTo = job;
        Job jobNotAppliedTo = recruiter.createJob();

        //recruiter posts a job
        recruiter.post(jobAppliedTo);
        recruiter.post(jobNotAppliedTo);

        //jobSeeker applies to job
        jobSeeker.applyToJob(jobAppliedTo, application);

        //jobSeeker gets a listing of jobs applied to
        JobListing jobsAppliedTo = jobSeeker.jobsAppliedTo();

        System.out.print(listing.postCount());
        //job applied to should be in the job listing
        assertTrue(jobsAppliedTo.isJobListed(jobAppliedTo));

        //job not applied to should not be in the job listing
        assertFalse(jobsAppliedTo.isJobListed(jobNotAppliedTo));
    }
}