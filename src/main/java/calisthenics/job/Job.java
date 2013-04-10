package calisthenics.job;

import calisthenics.recruiter.RecruiterId;

public class Job {
    private RecruiterId recruiterId;

    public Job(RecruiterId recruiterId) {
        this.recruiterId = recruiterId;
    }

    public RecruiterId getRecruiterId() {
        return recruiterId;
    }
}

