package Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class TurnoDTO {

    private String tratamiento;
    private String dniPaciente;
    private LocalDate fecha;

}
