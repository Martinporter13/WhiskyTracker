package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;
	@Test
	public void contextLoads() {
	}

	@Test
	public void canGetWhiskyByYear(){
		List<Whisky> foundWhisky = whiskyRepository.getWhiskyByYear(1995);
		assertEquals(1, foundWhisky.size());
	}

	@Test
	public void canGetDistilleryByRegion(){
		List<Distillery> foundDistillery = distilleryRepository.getDistilleryByRegion("Speyside");
		assertEquals(2,foundDistillery.size());
	}

	@Test
	public void canGetWhiskiesByDistilleryByAge(){
		List<Distillery> foundWhisky = distilleryRepository.findWhiskiesOfaParticularAge(15);
		assertEquals(1, foundWhisky.size());
	}

	@Test
	public void canGetWhiskiesOfaParticularRegion(){
		List<Whisky> foundDistillery = whiskyRepository.findWhiskiesFromaParticularRegion("Speyside");
		assertEquals(2,foundDistillery.size());
	}

}


