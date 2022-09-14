package com.softwareag.it.web.rest;

import com.softwareag.it.domain.App;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class RequestLite implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID applicationID;
    private UUID appId;

    private Set<App> apps = new HashSet<>();

    public UUID getAppId() {
        return appId;
    }

    public void setAppId(UUID appId) {
        this.appId = appId;
    }

    public UUID getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(UUID applicationID) {
        this.applicationID = applicationID;
    }

    public Set<App> getApps() {
        return apps;
    }

    public void setApps(Set<App> apps) {
        this.apps = apps;
    }
}
