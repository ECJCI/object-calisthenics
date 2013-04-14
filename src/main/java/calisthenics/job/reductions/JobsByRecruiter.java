package calisthenics.job.reductions;


import calisthenics.interfaces.Listing;
import calisthenics.interfaces.Reduction;
import calisthenics.job.Job;
import calisthenics.records.JobListing;
import calisthenics.job.reductions.predicates.JobsCreatedByRecruiter;
import calisthenics.recruiter.Recruiter;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

import java.util.Collection;

public class JobsByRecruiter implements Reduction<Job, Recruiter> {
    @Override
    public Listing<Job> reduce(Collection<Job> jobs, Recruiter element) {
        Recruiter recruiter = (Recruiter) element;
        Predicate<Job> belongsToRecruiter = new JobsCreatedByRecruiter(recruiter);
        Collection<Job> jobsWithSpecificId = Collections2.filter(jobs, belongsToRecruiter) ;
        return new JobListing(jobsWithSpecificId);
    }
}
