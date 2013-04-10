package calisthenics.jobseekers;

import calisthenics.job.Application;
import calisthenics.job.ApplicationListing;
import calisthenics.job.Job;
import calisthenics.job.JobListing;
import calisthenics.jobseeker.JobSeeker;
import calisthenics.recruiter.Recruiter;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

public class JobSeekerTest {
    private Collection<Job> jobs;
    private JobListing listing;
    private Collection<Job> savedJobs;
    private JobListing savedJobsListing;
    private Recruiter recruiter;
    private JobSeeker seeker;
    private Job job;
    private ApplicationListing applicationListing;
    private Collection<Application> applications;

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

        applications = new ArrayList<Application>();
        applicationListing = new ApplicationListing(applications);

        job = new Job(recruiter.Id(), applicationListing);
    }

    @Test
    public void testJobSeekersCanSaveJobsOnSiteForLaterViewing(){

        //Job Seeker saves the job
        seeker = new JobSeeker(savedJobsListing);
        seeker.saveJob(job);

        //Job Seekers saved jobs should contain the job
        assertTrue(seeker.isJobSaved(job));
    }

    @Test
    public void testJobSeekersCanApplyToJobsPostedByRecruiters(){
       Application application = new Application();
       recruiter.post(job);

       seeker.applyToJob(job, application);

       assertTrue(job.hasApplication(application));
    }
}
