package calisthenics.jobseekers;

import calisthenics.application.Application;
import calisthenics.application.ApplicationListing;
import calisthenics.job.Job;
import calisthenics.job.JobListing;
import calisthenics.jobseeker.JobSeekerFactory;
import calisthenics.jobseeker.JobSeekerListing;
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
    private JobListing jobListing;

    private Recruiter recruiter;
    private JobSeeker jobSeeker;
    private Job job;
    private ApplicationListing applicationListing;
    private Collection<Application> applications;
    private JobSeekerListing jobSeekerListing;
    private Application application;

    @Before
    public void setUp() throws Exception {
        //Listing that recruiters post to
        jobs = new ArrayList<Job>();
        jobListing = new JobListing(jobs);


        //recruiter creates and posts a job
        recruiter = new Recruiter(jobListing, jobSeekerListing);


        applications = new ArrayList<Application>();
        applicationListing = new ApplicationListing(applications);

        job = recruiter.createJob();

        //create the jobSeeker listing
        HashSet<JobSeeker> jobSeekers = new HashSet<JobSeeker>();
        jobSeekerListing = new JobSeekerListing(jobSeekers);

        //create job seeker
        JobSeekerFactory jobSeekerFactory = new JobSeekerFactory(jobSeekerListing, jobListing);
        jobSeeker = jobSeekerFactory.create();
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

        System.out.print(jobListing.postCount());
        //job applied to should be in the job listing
        assertTrue(jobsAppliedTo.isJobListed(jobAppliedTo));

        //job not applied to should not be in the job listing
        assertFalse(jobsAppliedTo.isJobListed(jobNotAppliedTo));
    }
}