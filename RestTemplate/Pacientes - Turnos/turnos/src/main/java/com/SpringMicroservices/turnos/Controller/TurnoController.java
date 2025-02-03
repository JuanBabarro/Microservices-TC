package com.SpringMicroservices.turnos.Controller;

import Dto.TurnoDTO;
import com.SpringMicroservices.turnos.Model.Turno;
import com.SpringMicroservices.turnos.Service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private ITurnoService turnoService;


    @PostMapping("/crear")
    //Remplazamos los "(@RequestBody LocalDate fecha, @RequestBody String tratamiento, @RequestBody String dniPaciente)" por la clase TurnoDTO que creamos
    public String crearTurno(@RequestBody TurnoDTO turnoDTO){
        turnoService.saveTurno(turnoDTO.getFecha(), turnoDTO.getTratamiento(), turnoDTO.getDniPaciente());
        return "¡Turno creado correctamente!";
    }


    @GetMapping("/traer")
    public List<Turno> traerTurnos(){
        return turnoService.getTurnos();
    }

    @DeleteMapping("/borrar/{id}")
    public String deleteTurno(@PathVariable Long id){
        turnoService.deleteTurno(id);
        return "¡El Turno se eliminó correctamente!";
    }

    @PutMapping("/editar/{id_original}")
    public Turno editTurno(@RequestBody Turno turno, @PathVariable Long id){
        turnoService.editTurno(id,turno);
        Turno turnoEditado = turnoService.findTurno(id);
        return turnoEditado;
    }

    @GetMapping("/traer/{id}")
    public Turno traerTurno (@PathVariable Long id){
        return turnoService.findTurno(id);
    }

}
