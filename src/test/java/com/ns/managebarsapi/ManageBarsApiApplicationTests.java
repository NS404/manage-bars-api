package com.ns.managebarsapi;

import com.ns.managebarsapi.model.Shift;
import com.ns.managebarsapi.resource.service.ShiftService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ManageBarsApiApplicationTests {

	@Autowired
	private ShiftService shiftService;


	@Test
	void contextLoads() {
		List<Shift> ongoingShifts = shiftService.queryOngoingShifts();
		System.out.println(ongoingShifts);

		List<Shift> shiftByDate = shiftService.queryShiftsByDate("2022-06-03");
		System.out.println(shiftByDate);
	}

}
