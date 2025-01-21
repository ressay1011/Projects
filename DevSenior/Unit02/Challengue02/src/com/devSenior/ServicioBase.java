package com.devSenior;

public abstract class ServicioBase {
  private String id;
  private int personalDisponible;
  private int combustibleDisponible;

  public ServicioBase(String id, int personalDisponible, int combustibleDisponible) {
    this.id = id;
    this.personalDisponible = personalDisponible;
    this.combustibleDisponible = combustibleDisponible;
  }

  public boolean estaDisponible() {
    return personalDisponible > 0 && combustibleDisponible > 0;
  }

  @Override
  public void asignarPersonal(int cantidad) {
    if (cantidad <= personalDisponible) {
      personalDisponible -= cantidad;
    } else {
      System.out.println("No hay suficiente personal disponible" + id);
    }
  }

  @Override
  public void removerPersonal(int cantidad) {
    personalDisponible += cantidad;
  }

  @Override
  public void asignarCombustible(int cantidad) {
    combustibleDisponible = Math.max(0, combustibleDisponible - cantidad);
  }

  @Override
  public void removerCombustible(int cantidad) {
    combustibleDisponible += cantidad;
  }

  @Override
  public abstract void atenderEmergencia(Emergencia emergencia);

  @Override
  public abstract void evaluarEstado(Emergencia emergencia);

}
