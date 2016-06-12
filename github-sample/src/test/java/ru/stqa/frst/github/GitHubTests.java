package ru.stqa.frst.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by user on 12.06.2016.
 */
public class GitHubTests {
  @Test
  public void testCommits() throws IOException {
    Github github = new RtGithub("be1f6acedfe5ca3ec1582aa090645ffd9805fc56");
    RepoCommits commits = github.repos().get(new Coordinates.Simple("KatsiarynaKarneliuk", "java_frst")).commits();
    for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
      System.out.println(new RepoCommit.Smart(commit).message());
    }
  }
}