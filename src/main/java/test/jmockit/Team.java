package com.test.jmockit;

import lombok.AllArgsConstructor;

/**
 * Created by gnavin on 2/27/17.
 */
@AllArgsConstructor
public class Team {

    private Leader leader;

    public boolean hasADiscussion() {
        System.out.println(leader.getName());
        Discussion d = new Discussion();
        return d.started();
    }
}