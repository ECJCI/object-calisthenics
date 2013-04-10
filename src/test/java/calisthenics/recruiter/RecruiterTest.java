package calisthenics.recruiter;

import calisthenics.job.Job;
import calisthenics.job.JobListing;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class RecruiterTest {

    private List<Job> jobList;
    private Job job;
    private JobListing listing;


    @Before
    public void setUp() {
        jobList = new ArrayList<Job>();
        listing = new JobListing(jobList);
    }

    @Test
    public void testRecruitersCanPostJobs() {
        Recruiter recruiter = new Recruiter(listing);
        RecruiterId id = recruiter.Id();

        job = new Job(id);
        recruiter.Post(job);
        assertTrue(listing.PostCount() > 0);
    }

    @Test
    public void testRecruitersShouldBeAbleToSeeAListingOfTheJobsTheyHavePosted(){
        Recruiter firstRecruiter = new Recruiter(listing);
        Recruiter secondRecruiter = new Recruiter(listing);

        RecruiterId firstRecruiterId = firstRecruiter.Id();
        RecruiterId secondRecruiterId = secondRecruiter.Id();

        Job job1 = new Job(firstRecruiterId);
        Job job2 = new Job(secondRecruiterId);

        firstRecruiter.Post(job1);
        secondRecruiter.Post(job2);

        JobListing firstRecruitersJobListing = firstRecruiter.JobPosts();

        assertTrue(firstRecruitersJobListing.isJobListed(job1));
        assertFalse(firstRecruitersJobListing.isJobListed(job2));
    }
}
