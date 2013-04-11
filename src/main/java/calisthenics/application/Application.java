package calisthenics.application;

import calisthenics.jobseeker.SeekerId;

public class Application {
    private SeekerId seekerId;

    public Application(SeekerId seekerId) {
        this.seekerId = seekerId;
    }

    public boolean createdBySeeker(SeekerId seekerId) {
        return this.seekerId.equals(seekerId);
    }
}
