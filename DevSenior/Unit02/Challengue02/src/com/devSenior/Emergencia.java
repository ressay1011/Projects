package com.devSenior;

public abstract class Emergencia {
  private String tipo;
  private String ubicacion;
  private int nivelGravedad;
  private int tiempoRespuesta;
  private boolean atendida;
  private long tiempoInicioAtencion;
  private long tiempoFinalAtencion;

  public Emergencia(String tipo, String ubicacion, int nivelGravedad, int tiempoRespuesta) {
    this.tipo = tipo;
    this.ubicacion = ubicacion;
    this.nivelGravedad = nivelGravedad;
    this.tiempoRespuesta = tiempoRespuesta;
    this.atendida = false;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public String getUbicacion() {
    return ubicacion;
  }

  public void setUbicacion(String ubicacion) {
    this.ubicacion = ubicacion;
  }

  public int getNivelGravedad() {
    return nivelGravedad;
  }

  public void setNivelGravedad(int nivelGravedad) {
    this.nivelGravedad = nivelGravedad;
  }

  public int getTiempoRespuesta() {
    return tiempoRespuesta;
  }

  public void setTiempoRespuesta(int tiempoRespuesta) {
    this.tiempoRespuesta = tiempoRespuesta;
  }

  public boolean isAtendida() {
    return atendida;
  }

  public long getTiempoInicioAtencion() {
    return tiempoInicioAtencion;
  }

  public long getTiempoFinalAtencion() {
    return tiempoFinalAtencion;
  }

  public void iniciarAtencion() {
    tiempoInicioAtencion = System.currentTimeMillis();
  }

  public void finalizarAtencion() {
    atendida = true;
    tiempoFinalAtencion = System.currentTimeMillis();
  }

  public long calcularTiempoAtencion() {
    return (tiempoFinalAtencion - tiempoInicioAtencion);
  }

  public String getDescripcion() {
    return String.format("%s en %s (Gravedad: %d)", tipo, ubicacion, nivelGravedad);
  }

  public String toString() {
    return String.format("%s %ntiempo estimado de respuesta: %d minutos.", getDescripcion(), tiempoRespuesta);
  }
}
