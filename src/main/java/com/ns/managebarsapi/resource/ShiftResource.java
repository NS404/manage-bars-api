package com.ns.managebarsapi.resource;


import com.ns.managebarsapi.model.Shift;
import com.ns.managebarsapi.resource.service.ShiftService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shifts")
public class ShiftResource {

    private final ShiftService shiftService;

    public ShiftResource(ShiftService shiftService) {
        this.shiftService = shiftService;
    }


    @GetMapping("/ongoing")
    public ResponseEntity<List<Shift>> getOngoingShifts () {
        List<Shift> shifts = shiftService.queryOngoingShifts();
        return new ResponseEntity<>(shifts, HttpStatus.OK);
    }

    @GetMapping("/find/{date}")
    public ResponseEntity<List<Shift>> getShiftsByDate (@PathVariable String date) {
        List<Shift> shifts = shiftService.queryShiftsByDate(date);
        return new ResponseEntity<>(shifts, HttpStatus.OK);
    }




}
