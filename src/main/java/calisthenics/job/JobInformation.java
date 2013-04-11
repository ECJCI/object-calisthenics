package calisthenics.job;

import calisthenics.recruiter.RecruiterId;

public class JobInformation {
    private RecruiterId recruiterId;

    public JobInformation(RecruiterId recruiterId) {
        this.recruiterId = recruiterId;
    }

    public boolean doesJobBelongToRecruiter(RecruiterId id)
    {
        return recruiterId.equals(id);
    }
}
