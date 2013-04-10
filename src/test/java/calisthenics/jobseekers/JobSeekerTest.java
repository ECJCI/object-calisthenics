package calisthenics.jobseekers;

import calisthenics.job.Job;
import calisthenics.job.JobListing;
import calisthenics.jobseeker.JobSeeker;
import calisthenics.recruiter.Recruiter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

public class JobSeekerTest {

    @Test
    public void testJobSeekersCanSaveJobsOnSiteForLaterViewing(){

        //Listing that recruiters post to
        Collection<Job> jobs = new ArrayList<Job>();
        JobListing listing = new JobListing(jobs);

        //snapshot listing that job seekers can save
        Collection<Job> savedJobs = new ArrayList<Job>();
        JobListing savedJobsListing = new JobListing(savedJobs);

        //recruiter creates and posts a job
        Recruiter recruiter = new Recruiter(listing);
        Job job = new Job(recruiter.Id());

        //Job Seeker saves the job
        JobSeeker seeker = new JobSeeker(savedJobsListing);
        seeker.saveJob(job);

        //Job Seekers saved jobs should contain the job
        assertTrue(seeker.isJobSaved(job));
    }
}
