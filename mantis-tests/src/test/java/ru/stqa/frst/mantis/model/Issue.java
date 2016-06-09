package ru.stqa.frst.mantis.model;

import biz.futureware.mantis.rpc.soap.client.ObjectRef;

/**
 * Created by user on 08.06.2016.
 */
public class Issue {
  private int id;
  private String summary;
  private String description;
  private Project project;
  private Issue issue;
  private ObjectRef resolution;
  public ObjectRef getResolution() {
    return resolution;
  }

  public Issue withResolution(ObjectRef resolution) {
    this.resolution = resolution;
    return this;
  }


  public int getId() {
    return id;
  }

  public Issue withId(int id) {
    this.id = id;
    return this;
  }

  public String getSummary() {
    return summary;
  }

  public Issue withSummary(String summary) {
    this.summary = summary;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public Issue withDescription(String description) {
    this.description = description;
    return this;

  }

  public Project getProject() {
    return project;
  }

  public Issue withProject(Project project) {
    this.project = project;
    return this;
  }

  public Issue getIssue() {
    return issue;
  }

  public void setIssue(Issue issue) {
    this.issue = issue;
  }
}
