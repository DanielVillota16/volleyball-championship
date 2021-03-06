package model;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class EventTest {
	private Event e;
	private String path;

	private void setUpScenary2() {
		e=new Event();
		path="data/assistants1-data";
	}
	
	@Test
	public void testLoad2() {
		setUpScenary2();
		try {
			long start = System.currentTimeMillis();
			e.load(path);
			long endTime = (System.currentTimeMillis() - start);
			System.out.println(endTime);
			assertTrue("The method load of 100.000 assitants is delayed", endTime>20);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testSearchCompetitor() {
		setUpScenary2();
		try {

			e.load(path);
			e.searchCompetitor("08-2246044");

			assertTrue("The method search do not find",e.searchCompetitor("08-2246044") != null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testSearchEspectator() {
		setUpScenary2();
		try {

			e.load(path);
			e.searchEspectator("36-5207000");

			assertTrue("The method search do not find",e.searchEspectator("36-5207000") != null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Event getE() {
		return e;
	}
	public void setE(Event e) {
		this.e = e;
	}

}
