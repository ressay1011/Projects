package com.devSenior;

public class Bomberos extends ServicioBase {
  public Bomberos(String id, int personalDisponible, int combustibleDisponible) {
    super(id, personalDisponible, combustibleDisponible);
  }

  @Override
  public void atenderEmergencia(Emergencia emergencia) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'atenderEmergencia'");
  }

  @Override
  public void evaluarEstado(Emergencia emergencia) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'evaluarEstado'");
  }

}
