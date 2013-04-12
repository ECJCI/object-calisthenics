package calisthenics.recruiter;

import calisthenics.application.Application;
import calisthenics.application.ApplicationListing;
import calisthenics.job.Job;
import calisthenics.job.JobListing;
import calisthenics.jobseeker.JobSeeker;
import calisthenics.jobseeker.JobSeekerListing;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class RecruiterTest {

    private List<Job> jobList;
    private Job job;
    private JobListing listing;
    private ApplicationListing applicationListing;
    private Collection<Application> applications;
    private JobSeekerListing jobSeekerListing;


    @Before
    public void setUp() {
        jobList = new ArrayList<Job>();
        listing = new JobListing(jobList);


        //create the jobSeeker listing
        HashSet<JobSeeker> jobSeekers = new HashSet<JobSeeker>();
        jobSeekerListing = new JobSeekerListing(jobSeekers);

        applications = new ArrayList<Application>();
        applicationListing = new ApplicationListing(applications);
    }

    @Test
    public void testRecruitersCanPostJobs() {
        Recruiter recruiter = new Recruiter(listing, jobSeekerListing);
        RecruiterId id = recruiter.Id();

        job = recruiter.createJob();
        recruiter.post(job);
        assertTrue(listing.postCount() > 0);
    }

    @Test
    public void testRecruitersShouldBeAbleToSeeAListingOfTheJobsTheyHavePosted(){
        Recruiter firstRecruiter = new Recruiter(listing, jobSeekerListing);
        Recruiter secondRecruiter = new Recruiter(listing, jobSeekerListing);

        RecruiterId firstRecruiterId = firstRecruiter.Id();
        RecruiterId secondRecruiterId = secondRecruiter.Id();

        Job job1 = firstRecruiter.createJob();
        Job job2 = secondRecruiter.createJob();

        firstRecruiter.post(job1);
        secondRecruiter.post(job2);

        JobListing firstRecruitersPostedJobs = firstRecruiter.jobPosts();

        assertTrue(firstRecruitersPostedJobs.isJobListed(job1));
        assertFalse(firstRecruitersPostedJobs.isJobListed(job2));
    }

    @Test
    public void testRecruitersShouldBeAbleToSeeJobSeekersWhoHaveAppliedToTheirJobsByJob(){
        Recruiter recruiter = new Recruiter(listing, jobSeekerListing);
        JobSeeker jobSeeker = new JobSeeker(listing);

        Job job = recruiter.createJob();
        recruiter.post(job);

        Application application = jobSeeker.createApplication();
        jobSeeker.applyToJob(job, application);

        JobSeekerListing seekersWhoHaveAppliedToJob = recruiter.seekersWhoHaveAppliedForJob(job);
        assertTrue(seekersWhoHaveAppliedToJob.isJobSeekerListed(jobSeeker));
    }
}
