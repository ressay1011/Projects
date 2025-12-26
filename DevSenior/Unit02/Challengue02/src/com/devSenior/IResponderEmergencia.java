package com.devSenior;

/**
 * Interface for entities that respond to emergencies.
 * Defines the contract for providing attention and evaluating emergency
 * situations.
 */
public interface IResponderEmergencia {

  /**
   * Initiates the attention process for a specific emergency.
   * 
   * @param emergencia The emergency to be attended.
   */
  void atenderEmergencia(Emergencia emergencia);

  /**
   * Evaluates the current state of an emergency.
   * 
   * @param emergencia The emergency to be evaluated.
   */
  void evaluarEstado(Emergencia emergencia);
}
