package com.devSenior;

public class FireStation extends BaseService {
  public FireStation(String id, int personalDisponible, int combustibleDisponible) {
    super(id, personalDisponible, combustibleDisponible);
  }

  @Override
  public void attendEmergency(Emergency emergency) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'attendEmergency'");
  }

  @Override
  public void checkState(Emergency emergency) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'checkState'");
  }

}
