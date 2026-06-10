package com.proyecto.gasto.repository;

import com.proyecto.gasto.model.Gasto;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GastoRepository {

    private final List<Gasto> gastos = new ArrayList<>();
    private int contadorId = 6;

    public GastoRepository() {
        gastos.add(new Gasto(1, "Compra de supermercado", 45.75, "Alimentacion", LocalDate.of(2026, 6, 1)));
        gastos.add(new Gasto(2, "Pago de transporte", 3.50, "Transporte", LocalDate.of(2026, 6, 2)));
        gastos.add(new Gasto(3, "plan de internet", 10.00, "Servicios", LocalDate.of(2026, 6, 3)));
        gastos.add(new Gasto(4, "Compra de medicina", 18.25, "Salud", LocalDate.of(2026, 6, 4)));
        gastos.add(new Gasto(5, "servicios de estream", 28.90, "Entretenimiento", LocalDate.of(2026, 6, 5)));
    }

    public List<Gasto> listarTodos() {
        return gastos;
    }

    public Gasto guardar(Gasto gasto) {
        gasto.setId(contadorId);
        contadorId++;
        gastos.add(gasto);
        return gasto;
    }

    public Gasto buscarPorId(int id) {
        for (Gasto gasto : gastos) {
            if (gasto.getId() == id) {
                return gasto;
            }
        }
        return null;
    }

    public void eliminar(int id) {
        gastos.removeIf(gasto -> gasto.getId() == id);
    }
}
