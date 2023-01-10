package oop_lecture.utility;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JsonTest {
	// init classes referring to each other
	LoopClass1 l1 = new LoopClass1();
	LoopClass1 l2 = new LoopClass2();


	@Test
	void parse() {
		l1.data = 1;
		l2.data = 2;

		l1.l_ = l2;
		l2.l_ = l1;

		// transform to JSON
		String x = null;
		try {
			x = new ObjectMapper().writeValueAsString(l1);
		} catch (IOException e) {
			System.out.println("Loop -> cant parse");
			e.printStackTrace();
		}

		assertEquals("""
				{"l_":{"data":2},"data":1}""",
				x
		);


		JsonNode jn = null;
		try {
			jn = Json.parse(x);
		} catch (IOException e) {
			e.printStackTrace();
		}

		assert jn != null;
		assertEquals(jn.get("data").asText(), Integer.toString(1));

	}

	@Test
	void toJson() {
		l1.data = 1;
		l2.data = 2;

		l1.l_ = l2;
		l2.l_ = l1;


	}

	@Test
	void fromJson() {
		JsonNode jn = Json.parse()
	}


	static class LoopClass1 {
		private LoopClass1 l_;
		private int data;


		public LoopClass1 getL_() {
			return l_;
		}
		public void setLoopClass(LoopClass1 lc) {
			l_ = lc;
		}

		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}

	}
	static class LoopClass2 extends LoopClass1{
		@Override
		@JsonIgnore
		public LoopClass1 getL_() {
			return super.getL_();
		}
	}
}