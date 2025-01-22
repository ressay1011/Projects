package com.devSenior;

public abstract class BaseService {
  private String id;
  private int availableWorkforce;
  private int availableFuel;

  public BaseService(String id, int availableWorkforce, int availableFuel) {
    this.id = id;
    this.availableWorkforce = availableWorkforce;
    this.availableFuel = availableFuel;
  }

  public String getId() {
    return id;
  }

  public int getAvailableWorkforce() {
    return availableWorkforce;
  }

  public void addWorkforce(int quantity) {
    availableWorkforce += quantity;
  }

  public void removeWorkforce(int quantity) {
    if (quantity <= availableWorkforce) {
      availableWorkforce -= quantity;
    } else {
      System.out.println(String.format("There is not enough available workforce in %s (Available workforce: %d)",
          id, availableWorkforce));
    }
  }

  public int getAvailableFuel() {
    return availableFuel;
  }

  public void addFuel(int quantity) {
    availableFuel += quantity;
  }

  public void removeFuel(int quantity) {
    if (quantity <= availableFuel) {
      availableFuel -= quantity;
    } else {
      System.out.println(String.format("There is not enough available fuel in %s (Available fuel: %d)",
          id, availableFuel));
    }
  }

  public boolean isAvailable() {
    return availableWorkforce > 0 && availableFuel > 0;
  }

  public abstract void attendEmergency(Emergency emergency);

  public abstract void checkState(Emergency emergency);

}
