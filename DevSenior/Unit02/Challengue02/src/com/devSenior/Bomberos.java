package com.devSenior;

/**
 * Firefighters service implementation.
 * Specializes {@link ServicioBase} for fire-related emergency response.
 */
public class Bomberos extends ServicioBase {
  /**
   * Constructs a new Bomberos service.
   * 
   * @param id                    The service ID.
   * @param personalDisponible    Available firefighters.
   * @param combustibleDisponible Available fuel for fire trucks.
   */
  public Bomberos(String id, int personalDisponible, int combustibleDisponible) {
    super(id, personalDisponible, combustibleDisponible);
  }

  @Override
  public void atenderEmergencia(Emergencia emergencia) {
    // Implementation for handling emergencies
    throw new UnsupportedOperationException("Unimplemented method 'atenderEmergencia'");
  }

  @Override
  public void evaluarEstado(Emergencia emergencia) {
    // Implementation for evaluating emergency state
    throw new UnsupportedOperationException("Unimplemented method 'evaluarEstado'");
  }

}
