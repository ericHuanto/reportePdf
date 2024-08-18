package org.example;

import dominio.GeneradorReporte;
import dominio.Persona;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    GeneradorReporte generator = GeneradorReporte.getInstancia();
    List<Persona> personas = new ArrayList<>();

    personas.add(new Persona("Juan", "Pérez", 30));
    personas.add(new Persona("María", "González", 25));
    personas.add(new Persona("Carlos", "Rodríguez", 40));

    generator.generar(personas, "personas.pdf", "reporte de datos");
    System.out.print("llegaste al final del main");
  }

}