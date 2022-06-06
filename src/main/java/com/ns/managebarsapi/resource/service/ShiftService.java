package com.ns.managebarsapi.resource.service;

import com.ns.managebarsapi.model.Shift;
import com.ns.managebarsapi.resource.repo.ShiftRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ShiftService {

    private final ShiftRepo shiftRepo;

    public ShiftService(ShiftRepo shiftRepo) {
        this.shiftRepo = shiftRepo;
    }

    public List<Shift> queryOngoingShifts() {
        return shiftRepo.findOngoingShifts();
    }

    public List<Shift> queryShiftsByDate(String date){
        LocalDate parsedDate = LocalDate.parse(date);
        return shiftRepo.findAllByDate(parsedDate);
    }
}
