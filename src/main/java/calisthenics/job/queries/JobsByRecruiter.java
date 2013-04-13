package calisthenics.job.queries;


import calisthenics.interfaces.Listing;
import calisthenics.interfaces.Query;
import calisthenics.job.Job;
import calisthenics.job.JobListing;
import calisthenics.job.queries.predicates.JobsCreatedByRecruiter;
import calisthenics.recruiter.Recruiter;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

import java.util.Collection;

public class JobsByRecruiter implements Query<Job> {
    @Override
    public Listing<Job> query(Collection<Job> jobs, Object element) {
        Recruiter recruiter = (Recruiter) element;
        Predicate<Job> belongsToRecruiter = new JobsCreatedByRecruiter(recruiter);
        Collection<Job> jobsWithSpecificId = Collections2.filter(jobs, belongsToRecruiter) ;
        return new JobListing(jobsWithSpecificId);
    }
}
