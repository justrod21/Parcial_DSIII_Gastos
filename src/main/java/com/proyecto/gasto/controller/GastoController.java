package com.proyecto.gasto.controller;

import com.proyecto.gasto.model.GastoModel;
import com.proyecto.gasto.services.GastoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/gastos")
public class GastoController {

    private final GastoService gastoService = new GastoService();

    @GetMapping
    public List<GastoModel> getAllGastos() {
        return gastoService.obtenerTodosLosGastos();
    }

    @GetMapping("/{id}")
    public GastoModel getGastoId(@PathVariable int id) {
        return gastoService.obtenerGastoPorId(id);
    }

    @PostMapping
    public GastoModel postGasto(@RequestBody GastoModel gasto) {
        return gastoService.registrarGasto(gasto);
    }

    @PutMapping("/{id}")
    public GastoModel putGasto(@PathVariable int id, @RequestBody GastoModel gasto) {
        return gastoService.actualizarGasto(id, gasto);
    }

    @DeleteMapping("/{id}")
    public String deleteGasto(@PathVariable int id) {
        boolean eliminado = gastoService.eliminarGasto(id);
        if (eliminado) {
            return "Gasto eliminado correctamente.";
        }
        return "Error: Gasto no encontrado.";
    }

    @GetMapping("/categoria/{categoria}")
    public List<GastoModel> getGastosPorCategoria(@PathVariable String categoria) {
        return gastoService.filtrarPorCategoria(categoria);
    }

    @GetMapping("/total-categoria/{categoria}")
    public double getTotalGastosPorCategoria(@PathVariable String categoria) {
        return gastoService.calcularTotalPorCategoria(categoria);
    }

    @GetMapping("/rango")
    public List<GastoModel> getGastosPorRango(@RequestParam double min, @RequestParam double max) {
        return gastoService.filtrarPorRangoDeMonto(min, max);
    }

    @GetMapping("/mas-alto")
    public GastoModel getGastoMasAlto() {
        return gastoService.obtenerGastoMasAlto();
    }
}