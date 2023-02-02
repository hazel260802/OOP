package oop_lecture.utility;

import oop_lecture.models.NhanVatLichSu;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortedSetByNameTest {

	@Test
	void find() {
		SortedSetByName<NhanVatLichSu> sortedSetByName = new SortedSetByName<>();
		var bht = new NhanVatLichSu("BHT", null, null, null, null, null, null);
		var lht = new NhanVatLichSu("LHT", null, null, null, null, null, null);
		var nna = new NhanVatLichSu("NNA", null, null, null, null, null, null);
		var hbd = new NhanVatLichSu("HBD", null, null, null, null, null, null);
		// empty set
		assertNull(sortedSetByName.find("BHT"));

		// set 1
		sortedSetByName.add(bht);
		assertEquals(bht, sortedSetByName.find("BHT"));

		// set many
		sortedSetByName.add(lht);
		sortedSetByName.add(hbd);
		sortedSetByName.add(nna);
		assertEquals(bht,sortedSetByName.find("BHT"));
		assertEquals(lht,sortedSetByName.find("LHT"));
		assertEquals(hbd,sortedSetByName.find("HBd"));
		assertEquals(nna,sortedSetByName.find("nnA"));

		// not in set
		assertNull(sortedSetByName.find("MNNH"));
	}
}