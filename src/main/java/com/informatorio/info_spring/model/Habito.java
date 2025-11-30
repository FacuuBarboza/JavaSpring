package com.informatorio.info_spring.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Habito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    @Enumerated(EnumType.STRING)
    private NivelDeImportanciaEnum nivelDeImportanciaEnum;

    @ManyToMany(mappedBy = "habitos")
    private List<EntradaDiaria> entradasDiarias;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public NivelDeImportanciaEnum getNivelDeImportanciaEnum() {
        return nivelDeImportanciaEnum;
    }

    public void setNivelDeImportanciaEnum(NivelDeImportanciaEnum nivelDeImportanciaEnum) {
        this.nivelDeImportanciaEnum = nivelDeImportanciaEnum;
    }

    public List<EntradaDiaria> getEntradasDiarias() {
        return entradasDiarias;
    }

    public void setEntradasDiarias(List<EntradaDiaria> entradasDiarias) {
        this.entradasDiarias = entradasDiarias;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
