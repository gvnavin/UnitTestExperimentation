package com.test.jmockit;

/**
 * Created by gnavin on 2/27/17.
 */
public class Team {

    private Collaborator collaborator;
    private Leader leader;

    public Team(final Collaborator collaborator) {
        this.collaborator = collaborator;
    }

    public Team(final Leader leader) {
        this.leader = leader;
    }

    public boolean hasADiscussion() {
        System.out.println(leader.getName());
        Discussion d = new Discussion();
        return d.started();
    }

    public void pass(int a, int b) {
        a += 1;
        b += 1;
        collaborator.simpleOperation(a, b);
    }
}