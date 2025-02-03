package com.SpringMicroservices.turnos.Repository;

import com.SpringMicroservices.turnos.Model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnoRepository extends JpaRepository<Turno, Long> {
}
