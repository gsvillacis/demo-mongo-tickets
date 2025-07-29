package com.utpl.demo_mongo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.utpl.demo_mongo.enums.Estado;
import com.utpl.demo_mongo.enums.Prioridad;
import com.utpl.demo_mongo.enums.GrupoResolutor;
import com.utpl.demo_mongo.enums.AplicacionAfectada;
import java.time.LocalDateTime;

@Document(collection = "tickets")
public class Ticket {
    
    @Id
    private String id;
    private String nombrePersona;
    private String numeroContacto;
    private String descripcion;
    private AplicacionAfectada aplicacionAfectada;
    private Prioridad prioridad;
    private GrupoResolutor grupoResolutor;
    private String accionesRecuperacion;
    private Estado estado;
    private LocalDateTime fechaCreacion;
    
    // Constructor por defecto
    public Ticket() {
        this.estado = Estado.NUEVO;
        this.fechaCreacion = LocalDateTime.now();
    }
    
    // Constructor para creación de ticket (sin acciones de recuperación)
    public Ticket(String nombrePersona, String numeroContacto, String descripcion, AplicacionAfectada aplicacionAfectada, 
                  Prioridad prioridad, GrupoResolutor grupoResolutor) {
        this();
        this.nombrePersona = nombrePersona;
        this.numeroContacto = numeroContacto;
        this.descripcion = descripcion;
        this.aplicacionAfectada = aplicacionAfectada;
        this.prioridad = prioridad;
        this.grupoResolutor = grupoResolutor;
    }
    
    // Getters y Setters
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getNombrePersona() {
        return nombrePersona;
    }
    
    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }
    
    public String getNumeroContacto() {
        return numeroContacto;
    }
    
    public void setNumeroContacto(String numeroContacto) {
        this.numeroContacto = numeroContacto;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public AplicacionAfectada getAplicacionAfectada() {
        return aplicacionAfectada;
    }
    
    public void setAplicacionAfectada(AplicacionAfectada aplicacionAfectada) {
        this.aplicacionAfectada = aplicacionAfectada;
    }
    
    public Prioridad getPrioridad() {
        return prioridad;
    }
    
    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }
    
    public GrupoResolutor getGrupoResolutor() {
        return grupoResolutor;
    }
    
    public void setGrupoResolutor(GrupoResolutor grupoResolutor) {
        this.grupoResolutor = grupoResolutor;
    }
    
    public String getAccionesRecuperacion() {
        return accionesRecuperacion;
    }
    
    public void setAccionesRecuperacion(String accionesRecuperacion) {
        this.accionesRecuperacion = accionesRecuperacion;
    }
    
    public Estado getEstado() {
        return estado;
    }
    
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
    
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
