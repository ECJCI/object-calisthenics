package calisthenics.job.reductions;

import calisthenics.interfaces.Listing;
import calisthenics.interfaces.Reduction;
import calisthenics.job.Job;
import calisthenics.job.JobListing;
import calisthenics.job.reductions.predicates.JobsAppliedToBySeekerPredicate;
import calisthenics.jobseeker.JobSeeker;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

import java.util.Collection;

public class JobsAppliedTo implements Reduction<Job,JobSeeker> {

    @Override
    public Listing<Job> reduce(Collection<Job> jobs, JobSeeker jobSeeker) {
        Predicate<Job> hasAppliedToJob = new JobsAppliedToBySeekerPredicate(jobSeeker);
            Collection<Job> jobsThatSeekerHasAppliedTo = Collections2.filter(jobs, hasAppliedToJob);
            return new JobListing(jobsThatSeekerHasAppliedTo);
        }


}