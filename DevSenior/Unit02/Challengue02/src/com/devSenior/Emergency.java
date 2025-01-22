package com.devSenior;

public abstract class Emergency {
  private String type;
  private String location;
  private int severityLevel;
  private int responseTime;
  private boolean attended;
  private long initialAttentionTime;
  private long endAttentionTime;

  public Emergency(String type, String location, int severityLevel, int responseTime) {
    this.type = type;
    this.location = location;
    this.severityLevel = severityLevel;
    this.responseTime = responseTime;
    this.attended = false;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public int getSeverityLevel() {
    return severityLevel;
  }

  public void setSeverityLevel(int severityLevel) {
    this.severityLevel = severityLevel;
  }

  public int getResponseTime() {
    return responseTime;
  }

  public void setResponseTime(int responseTime) {
    this.responseTime = responseTime;
  }

  public boolean isAttended() {
    return attended;
  }

  public long getInitialAttentionTime() {
    return initialAttentionTime;
  }

  public long getEndAttentionTime() {
    return endAttentionTime;
  }

  public void startAttention() {
    initialAttentionTime = System.currentTimeMillis();
  }

  public void endAttention() {
    attended = true;
    endAttentionTime = System.currentTimeMillis();
  }

  public long calculateAttentionTime() {
    return (endAttentionTime - initialAttentionTime);
  }

  public String getDescription() {
    return String.format("%s en %s (Severity: %d)", type, location, severityLevel);
  }

  public String toString() {
    return String.format("%s %nEstimated response time: %d minutes.", getDescription(), responseTime);
  }
}
