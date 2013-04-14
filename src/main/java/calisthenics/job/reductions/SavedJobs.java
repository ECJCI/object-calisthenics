package calisthenics.job.reductions;

import calisthenics.interfaces.Listing;
import calisthenics.interfaces.Reduction;
import calisthenics.job.Job;
import calisthenics.job.JobListing;
import calisthenics.job.reductions.predicates.JobsThatHaveBeenSavedByJobSeeker;
import calisthenics.jobseeker.JobSeeker;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

import java.util.Collection;

public class SavedJobs implements Reduction<Job, JobSeeker> {

    @Override
    public Listing<Job> reduce(Collection<Job> jobListing, JobSeeker jobSeeker) {
        Predicate<Job> isJobSaved = new JobsThatHaveBeenSavedByJobSeeker(jobSeeker);
        Collection<Job> jobsThatHaveBeenSavedBySeeker = Collections2.filter(jobListing, isJobSaved);
        return new JobListing(jobsThatHaveBeenSavedBySeeker);
    }

}