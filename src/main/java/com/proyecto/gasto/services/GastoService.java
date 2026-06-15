package com.proyecto.gasto.services;

import com.proyecto.gasto.model.GastoModel;
import com.proyecto.gasto.repository.GastoRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GastoService {

    private final GastoRepository gastoRepository = new GastoRepository();

    public List<GastoModel> obtenerTodosLosGastos() {
        return gastoRepository.listarTodos();
    }

    public GastoModel obtenerGastoPorId(int id) {
        return gastoRepository.buscarPorId(id);
    }

    public GastoModel registrarGasto(GastoModel gasto) {
        return gastoRepository.guardar(gasto);
    }

    public GastoModel actualizarGasto(int id, GastoModel gastoActualizado) {
        GastoModel gastoExistente = gastoRepository.buscarPorId(id);
        if (gastoExistente != null) {
            gastoExistente.setDescripcion(gastoActualizado.getDescripcion());
            gastoExistente.setMonto(gastoActualizado.getMonto());
            gastoExistente.setCategoria(gastoActualizado.getCategoria());
            gastoExistente.setFecha(gastoActualizado.getFecha());
            return gastoExistente;
        }
        return null;
    }

    public boolean eliminarGasto(int id) {
        GastoModel existente = gastoRepository.buscarPorId(id);
        if (existente != null) {
            gastoRepository.eliminar(id);
            return true;
        }
        return false;
    }

    public List<GastoModel> filtrarPorCategoria(String categoria) {
        return gastoRepository.listarTodos().stream()
                .filter(g -> g.getCategoria().equalsIgnoreCase(categoria))
                .collect(Collectors.toList());
    }

    public double calcularTotalPorCategoria(String categoria) {
        return gastoRepository.listarTodos().stream()
                .filter(g -> g.getCategoria().equalsIgnoreCase(categoria))
                .mapToDouble(GastoModel::getMonto)
                .sum();
    }

    public List<GastoModel> filtrarPorRangoDeMonto(double montoMin, double montoMax) {
        return gastoRepository.listarTodos().stream()
                .filter(g -> g.getMonto() >= montoMin && g.getMonto() <= montoMax)
                .collect(Collectors.toList());
    }

    public GastoModel obtenerGastoMasAlto() {
        return gastoRepository.listarTodos().stream()
                .max(Comparator.comparingDouble(GastoModel::getMonto))
                .orElse(null);
    }
}