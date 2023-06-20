package com.non.service;

import java.util.List;
import java.util.Optional;
import com.non.model.Trains;

public interface TrainsService {
	
	 List<Trains> getTrains();
	
	 List<Trains> getTrains(String source, String destination);
	
	 Trains addTrain(Trains train);
	 
	 Optional<Trains> getTrainsById(String tid);

	 String deleteTrain(String tid);

	 Trains updateTrain(Trains trains);

}
