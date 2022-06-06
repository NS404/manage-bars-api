package com.ns.managebarsapi.resource.repo;

import com.ns.managebarsapi.model.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ShiftRepo extends JpaRepository<Shift,Long> {


    @Query("SELECT sh from Shift sh WHERE sh.finished = false")
    List<Shift> findOngoingShifts();

    List<Shift> findAllByDate(LocalDate date);
}
