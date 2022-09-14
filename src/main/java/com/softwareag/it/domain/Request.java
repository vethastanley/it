package com.softwareag.it.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.softwareag.it.domain.enumeration.Status;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Request.
 */
@Entity
@Table(name = "request")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Request implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private UUID id = UUID.randomUUID();

    @NotNull
    @Column(name = "application_id", nullable = false)
    private UUID applicationID;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "doj", nullable = false)
    private Long doj;

    @NotNull
    @Column(name = "role", nullable = false)
    private String role;

    @NotNull
    @Column(name = "team", nullable = false)
    private String team;

    @NotNull
    @Column(name = "manager", nullable = false)
    private String manager;

    @NotNull
    @Column(name = "org", nullable = false)
    private String org;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @OneToMany(mappedBy = "request")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "request" }, allowSetters = true)
    private Set<App> apps = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public UUID getId() {
        return this.id;
    }

    public Request id(UUID id) {
        this.setId(id);
        return this;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getApplicationID() {
        return this.applicationID;
    }

    public Request applicationID(UUID applicationID) {
        this.setApplicationID(applicationID);
        return this;
    }

    public void setApplicationID(UUID applicationID) {
        this.applicationID = applicationID;
    }

    public String getName() {
        return this.name;
    }

    public Request name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDoj() {
        return this.doj;
    }

    public Request doj(Long doj) {
        this.setDoj(doj);
        return this;
    }

    public void setDoj(Long doj) {
        this.doj = doj;
    }

    public String getRole() {
        return this.role;
    }

    public Request role(String role) {
        this.setRole(role);
        return this;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTeam() {
        return this.team;
    }

    public Request team(String team) {
        this.setTeam(team);
        return this;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getManager() {
        return this.manager;
    }

    public Request manager(String manager) {
        this.setManager(manager);
        return this;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getOrg() {
        return this.org;
    }

    public Request org(String org) {
        this.setOrg(org);
        return this;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public Status getStatus() {
        return this.status;
    }

    public Request status(Status status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<App> getApps() {
        return this.apps;
    }

    public void setApps(Set<App> apps) {
        if (this.apps != null) {
            this.apps.forEach(i -> i.setRequest(null));
        }
        if (apps != null) {
            apps.forEach(i -> i.setRequest(this));
        }
        this.apps = apps;
    }

    public Request apps(Set<App> apps) {
        this.setApps(apps);
        return this;
    }

    public Request addApp(App app) {
        this.apps.add(app);
        app.setRequest(this);
        return this;
    }

    public Request removeApp(App app) {
        this.apps.remove(app);
        app.setRequest(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Request)) {
            return false;
        }
        return id != null && id.equals(((Request) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Request{" +
            "id=" + getId() +
            ", applicationID='" + getApplicationID() + "'" +
            ", name='" + getName() + "'" +
            ", doj=" + getDoj() +
            ", role='" + getRole() + "'" +
            ", team='" + getTeam() + "'" +
            ", manager='" + getManager() + "'" +
            ", org='" + getOrg() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
