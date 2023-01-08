package oop_lecture.utility;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JsonTest {

	@Test
	void parse() {
		// init classes referring to each other
		LoopClass l1 = new LoopClass();
		LoopClass l2 = new LoopClass();

		l1.data = 1;
		l2.data = 2;

		l1.l_ = l2;
		l2.l_ = l1;

		// transform to JSON
		String x = null;
		try {
			x = new ObjectMapper().writeValueAsString(l1);
			System.out.println(x);

		} catch (IOException e) {
			System.out.println("Loop -> cant parse");
			e.printStackTrace();
		}

		JsonNode jn = null;
		try {
			jn = Json.parse(x);
		} catch (IOException e) {
			e.printStackTrace();
		}

		assert jn != null;
		assertEquals(jn.get("data").asText(), Integer.toString(1));

	}


	static class LoopClass {
		@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
		private LoopClass l_;
		private int data;


		public LoopClass getL_() {
			return l_;
		}

		public void setLoopClass(LoopClass lc) {
			l_ = lc;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

	}
}