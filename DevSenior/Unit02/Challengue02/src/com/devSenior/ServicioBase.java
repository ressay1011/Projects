package com.devSenior;

/**
 * Base class for all emergency services.
 * Implements the responder interface and manages shared resources like
 * personal and fuel availability.
 */
public abstract class ServicioBase implements IResponderEmergencia {
  /** Unique identifier for the service. */
  private String id;
  /** Current number of personnel available for deployment. */
  private int personalDisponible;
  /** Amount of fuel available for the service's vehicles. */
  private int combustibleDisponible;

  /**
   * Constructs a new ServicioBase.
   * 
   * @param id                    The service identifier.
   * @param personalDisponible    Initial personnel count.
   * @param combustibleDisponible Initial fuel level.
   */
  public ServicioBase(String id, int personalDisponible, int combustibleDisponible) {
    this.id = id;
    this.personalDisponible = personalDisponible;
    this.combustibleDisponible = combustibleDisponible;
  }

  /**
   * Checks if the service has at least one person and some fuel available.
   * 
   * @return true if both personnel and fuel are above zero.
   */
  public boolean estaDisponible() {
    return personalDisponible > 0 && combustibleDisponible > 0;
  }

  /**
   * Assigns personnel to an emergency.
   */
  public void asignarPersonal(int cantidad) {
    if (cantidad <= personalDisponible) {
      personalDisponible -= cantidad;
    } else {
      System.out.println("No hay suficiente personal disponible: " + id);
    }
  }

  /**
   * Returns personnel to the available pool.
   */
  public void removerPersonal(int cantidad) {
    personalDisponible += cantidad;
  }

  /**
   * Uses fuel for a mission.
   */
  public void asignarCombustible(int cantidad) {
    combustibleDisponible = Math.max(0, combustibleDisponible - cantidad);
  }

  /**
   * Replenishes fuel.
   */
  public void removerCombustible(int cantidad) {
    combustibleDisponible += cantidad;
  }

  @Override
  public abstract void atenderEmergencia(Emergencia emergencia);

  @Override
  public abstract void evaluarEstado(Emergencia emergencia);

}
