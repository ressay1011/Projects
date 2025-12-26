package com.devSenior;

/**
 * Abstract class representing a general emergency.
 * Provides properties and methods for tracking response times and attention
 * status.
 */
public abstract class Emergencia {
  /** The type of emergency (e.g., "Incendio", "Accidente"). */
  private String tipo;
  /** The location where the emergency is occurring. */
  private String ubicacion;
  /** The severity level of the emergency (1-5). */
  private int nivelGravedad;
  /** Estimated response time in minutes. */
  private int tiempoRespuesta;
  /** Indicates if the emergency has been fully attended. */
  private boolean atendida;
  /** Timestamp when attention started. */
  private long tiempoInicioAtencion;
  /** Timestamp when attention finalized. */
  private long tiempoFinalAtencion;

  /**
   * Constructs a new Emergencia with specified details.
   * 
   * @param tipo            The type of emergency.
   * @param ubicacion       The location of the emergency.
   * @param nivelGravedad   The severity level.
   * @param tiempoRespuesta The estimated response time in minutes.
   */
  public Emergencia(String tipo, String ubicacion, int nivelGravedad, int tiempoRespuesta) {
    this.tipo = tipo;
    this.ubicacion = ubicacion;
    this.nivelGravedad = nivelGravedad;
    this.tiempoRespuesta = tiempoRespuesta;
    this.atendida = false;
  }

  /**
   * Gets the type of emergency.
   * 
   * @return The emergency type.
   */
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

  /**
   * Starts the attention timer.
   */
  public void iniciarAtencion() {
    tiempoInicioAtencion = System.currentTimeMillis();
  }

  /**
   * Finalizes the attention and sets as attended.
   */
  public void finalizarAtencion() {
    atendida = true;
    tiempoFinalAtencion = System.currentTimeMillis();
  }

  /**
   * Calculates the total attention time in milliseconds.
   * 
   * @return The difference between end and start attention timestamps.
   */
  public long calcularTiempoAtencion() {
    return (tiempoFinalAtencion - tiempoInicioAtencion);
  }

  /**
   * Returns a basic description of the emergency.
   */
  public String getDescripcion() {
    return String.format("%s en %s (Gravedad: %d)", tipo, ubicacion, nivelGravedad);
  }

  @Override
  public String toString() {
    return String.format("%s %ntiempo estimado de respuesta: %d minutos.", getDescripcion(), tiempoRespuesta);
  }
}
