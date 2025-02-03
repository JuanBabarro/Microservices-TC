package com.SpringMicroservices.turnos.Service;

import com.SpringMicroservices.turnos.Model.Paciente;
import com.SpringMicroservices.turnos.Model.Turno;
import com.SpringMicroservices.turnos.Repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    ITurnoRepository turnoRepository;

    @Autowired
    private RestTemplate apiConsumir; //mismo nombre que en el AppConfig

    @Override
    public List<Turno> getTurnos() {
        return turnoRepository.findAll();
    }

    @Override
    public void saveTurno(LocalDate fecha, String tratamiento, String dniPaciente) {
        //La URL tiene como host el puerto del servicio Pacientes (9001) y usa el metodo "traerdni" de su Controller
        //Por el apiConsumir tenemos que crear otro model "Paciente" para poder tener los datos del paciente
        Paciente p = apiConsumir.getForObject("http://localhost:9001/pacientes/traerdni/"+dniPaciente, Paciente.class);
        String nombreCompletoPaciente = p.getNombre()+" "+p.getApellido();

        Turno turno = new Turno();
        turno.setFecha(fecha);
        turno.setTratamiento(tratamiento);
        turno.setNombreCompletoPaciente(nombreCompletoPaciente);

        turnoRepository.save(turno);
    }

    @Override
    public void deleteTurno(Long id) {
        turnoRepository.deleteById(id);
    }

    @Override
    public Turno findTurno(Long id) {
        return turnoRepository.findById(id).orElse(null);
    }

    @Override
    public void editTurno(Long id, Turno turno) {
        Turno t = this.findTurno(id);

        t.setFecha(turno.getFecha());
        t.setTratamiento(turno.getTratamiento());
        t.setNombreCompletoPaciente(turno.getNombreCompletoPaciente());

        turnoRepository.save(t);
    }
}
