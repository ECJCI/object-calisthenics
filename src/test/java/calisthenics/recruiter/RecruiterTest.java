package calisthenics.recruiter;

import calisthenics.job.Application;
import calisthenics.job.ApplicationListing;
import calisthenics.job.Job;
import calisthenics.job.JobListing;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class RecruiterTest {

    private List<Job> jobList;
    private Job job;
    private JobListing listing;
    private ApplicationListing applicationListing;
    private Collection<Application> applications;


    @Before
    public void setUp() {
        jobList = new ArrayList<Job>();
        listing = new JobListing(jobList);
        applications = new ArrayList<Application>();
        applicationListing = new ApplicationListing(applications);
    }

    @Test
    public void testRecruitersCanPostJobs() {
        Recruiter recruiter = new Recruiter(listing);
        RecruiterId id = recruiter.Id();

        job = recruiter.createJob();
        recruiter.post(job);
        assertTrue(listing.postCount() > 0);
    }

    @Test
    public void testRecruitersShouldBeAbleToSeeAListingOfTheJobsTheyHavePosted(){
        Recruiter firstRecruiter = new Recruiter(listing);
        Recruiter secondRecruiter = new Recruiter(listing);

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
}
