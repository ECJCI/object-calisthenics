package calisthenics.recruiter;

import calisthenics.application.Application;
import calisthenics.application.ApplicationListing;
import calisthenics.application.NoResume;
import calisthenics.job.ATS;
import calisthenics.job.Job;
import calisthenics.job.JobFactory;
import calisthenics.job.JobListing;
import calisthenics.jobseeker.JobSeekerFactory;
import calisthenics.jobseeker.JobSeekerListing;
import calisthenics.jobseeker.JobSeeker;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class RecruiterTest {

    private JobListing jobListing;
    private JobSeekerFactory jobSeekerFactory;
    private JobSeekerListing jobSeekerListing;
    private JobFactory jobFactory;


    @Before
    public void setUp() {
        HashSet<Job> jobList = new HashSet<Job>();
        jobFactory = new JobFactory();

        jobListing = new JobListing(jobList);
        Collection<Application> applications = new ArrayList<Application>();

        HashSet<JobSeeker> jobSeekers = new HashSet<JobSeeker>();
        jobSeekerListing = new JobSeekerListing(jobSeekers);

        ApplicationListing applicationListing = new ApplicationListing(applications);
        jobSeekerFactory = new JobSeekerFactory(jobListing, jobSeekerListing);
    }

    @Test
    public void testRecruitersCanPostJobs() {
        Recruiter recruiter = new Recruiter(jobListing, jobSeekerListing, jobFactory);

        Job job = recruiter.createATSJob();
        recruiter.post(job);
        assertTrue(jobListing.postCount() > 0);
    }

    @Test
    public void testRecruitersShouldBeAbleToSeeAListingOfTheJobsTheyHavePosted(){

        Recruiter firstRecruiter = new Recruiter(jobListing, jobSeekerListing, jobFactory);
        Recruiter secondRecruiter = new Recruiter(jobListing, jobSeekerListing, jobFactory);

        Job job1 = firstRecruiter.createATSJob();
        Job job2 = secondRecruiter.createJReqJob();

        firstRecruiter.post(job1);
        secondRecruiter.post(job2);

        JobListing firstRecruitersPostedJobs = firstRecruiter.jobPosts();

        System.out.print(job1.doesJobBelongToRecruiter(firstRecruiter));
        assertTrue(firstRecruitersPostedJobs.isListed(job1));
        assertFalse(firstRecruitersPostedJobs.isListed(job2));
    }

    @Test
    public void testRecruitersShouldBeAbleToSeeJobSeekersWhoHaveAppliedToTheirJobsByJob(){
        Recruiter recruiter = new Recruiter(jobListing, jobSeekerListing, jobFactory);
        JobSeeker jobSeeker = jobSeekerFactory.create();

        Job<ATS> job = recruiter.createATSJob();
        recruiter.post(job);

        Application<NoResume> application = jobSeeker.createApplication();
        jobSeeker.apply(job, application);

        JobSeekerListing jobSeekersWhoHaveAppliedToJob = recruiter.jobSeekersWhoHaveAppliedForJob(job);
        assertTrue(jobSeekersWhoHaveAppliedToJob.isListed(jobSeeker));
    }
}
