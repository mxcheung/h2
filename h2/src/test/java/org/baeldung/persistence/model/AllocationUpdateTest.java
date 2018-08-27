package org.baeldung.persistence.model;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class AllocationUpdateTest {

	private Set<AllocationUpdate> firstSet;
	private Set<AllocationUpdate> secondSet;
	
	@Before
	public void setup() throws Exception {
		
		AllocationUpdate allocationUpdate1 = new AllocationUpdate();
		allocationUpdate1.setCdpSettlementId("123");
		allocationUpdate1.setSettlementSystemId(123L);
		AllocationUpdate allocationUpdate2 = new AllocationUpdate();
		allocationUpdate2.setCdpSettlementId("123");
		firstSet = new HashSet<>();
		firstSet.add(allocationUpdate1);
		secondSet = new HashSet<>();
		secondSet.add(allocationUpdate2);
	}

	@Test
	public void compareSet() throws IOException {
		Set<AllocationUpdate> one = firstSet;
		Set<AllocationUpdate> two = secondSet;
		one.removeAll(secondSet);
		two.removeAll(firstSet);
		assertEquals(1,one.size());
		assertEquals(1,two.size());
	}


}
