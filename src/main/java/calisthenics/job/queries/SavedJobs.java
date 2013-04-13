package calisthenics.job.queries;

import calisthenics.interfaces.Listing;
import calisthenics.interfaces.Query;
import calisthenics.job.Job;
import calisthenics.job.JobListing;
import calisthenics.job.queries.predicates.JobsThatHaveBeenSavedByJobSeeker;
import calisthenics.jobseeker.JobSeeker;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

import java.util.Collection;

public class SavedJobs implements Query<Job> {

    @Override
    public Listing<Job> query(Collection<Job> jobListing, Object element) {
        JobSeeker jobSeeker = (JobSeeker) element;
        Predicate<Job> isJobSaved = new JobsThatHaveBeenSavedByJobSeeker(jobSeeker);
        Collection<Job> jobsThatHaveBeenSavedBySeeker = Collections2.filter(jobListing, isJobSaved);
        return new JobListing(jobsThatHaveBeenSavedBySeeker);
    }

}