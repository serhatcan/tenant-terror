
import java.util.Random;
import java.util.TimerTask;

public class ScheduledObjectCreator extends TimerTask {

	Simulation s;
	Random r;
	HouseFactory hf;
	StudentFactory sf;
	BrokerFactory bf;

	public ScheduledObjectCreator(Simulation simulation) {
		s = simulation;
		hf = new HouseFactory();
		sf = new StudentFactory();
		bf = new BrokerFactory();

	}

	@Override
	public void run() {

		if (s.numOfBrokers < 10) {
			s.entities.add(bf.produce(new ClosestFirst(s), s));
			s.numOfBrokers++;
		}

		s.entities.add(sf.produce(new ClosestFirst(s), s));
		s.numOfStudents++;

		s.entities.add(hf.produce(new ClosestFirst(s), s));
		s.numOfHouses++;
	}

}
