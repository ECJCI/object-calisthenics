package calisthenics.job.queries;

import calisthenics.interfaces.Listing;
import calisthenics.interfaces.Query;
import calisthenics.job.Job;
import calisthenics.job.JobListing;
import calisthenics.job.queries.predicates.JobsAppliedToBySeekerPredicate;
import calisthenics.job.queries.predicates.JobsThatHaveBeenSavedByJobSeeker;
import calisthenics.jobseeker.JobSeeker;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

import java.util.Collection;

public class JobsAppliedTo implements Query<Job> {

    @Override
    public Listing<Job> query(Collection<Job> jobs, Object jobSeekerObject) {
            JobSeeker  jobSeeker = (JobSeeker) jobSeekerObject;
            Predicate<Job> hasAppliedToJob = new JobsAppliedToBySeekerPredicate(jobSeeker);
            Collection<Job> jobsThatSeekerHasAppliedTo = Collections2.filter(jobs, hasAppliedToJob);
            return new JobListing(jobsThatSeekerHasAppliedTo);
        }
}