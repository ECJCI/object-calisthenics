package calisthenics.job;

import calisthenics.recruiter.RecruiterId;

/**
 * Created with IntelliJ IDEA.
 * User: ejones
 * Date: 4/9/13
 * Time: 3:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class Job {
    private RecruiterId id;

    public Job(RecruiterId id) {
        this.id = id;
    }

    public RecruiterId getId() {
        return id;
    }
}

