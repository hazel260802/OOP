package oop_lecture.utility;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import oop_lecture.models.DiaDiem;
import oop_lecture.models.DiaDiemLichSu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Json {
    private static final ObjectMapper om = getDefaultObjectMapper();

    private static ObjectMapper getDefaultObjectMapper() {
        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // region định nghĩa Json DD
		om.registerModule(new SimpleModule().addSerializer(
				DiaDiem.class,
				new StdSerializer<>(DiaDiem.class) {
					@Override
					public void serialize(DiaDiem o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
						// bắt đầu viết file json
						jsonGenerator.writeStartObject();
						jsonGenerator.writeStringField("ten", o.ten);
						jsonGenerator.writeStringField("chiTietDiaDiem", o.chiTietDiaDiem);
						jsonGenerator.writeEndObject();
					}
				}
		));
		om.registerModule(new SimpleModule().addDeserializer(
				DiaDiem.class,
				new StdDeserializer<>(DiaDiemLichSu.class) {
					@Override
					public DiaDiem deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
						// lấy jnode
						JsonNode jn = jsonParser.getCodec().readTree(jsonParser);
						// đọc các trường phức tạp
						DiaDiem diaDiem = new DiaDiem();
						diaDiem.ten = jn.get("ten").asText();
						diaDiem.chiTietDiaDiem = jn.get("chiTietDiaDiem").asText();

						return diaDiem;
					}
				})
		);
		// endregion
		// region định nghĩa Json DDLS
		om.registerModule(new SimpleModule().addSerializer(
				DiaDiemLichSu.class,
				new StdSerializer<>(DiaDiemLichSu.class) {
					@Override
					public void serialize(DiaDiemLichSu o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
						// bắt đầu viết file json
						jsonGenerator.writeStartObject();
						jsonGenerator.writeStringField("ten", o.getTen());
						jsonGenerator.writeObjectField("diaDiem", o.getDiaDiem());
						jsonGenerator.writeStringField("loaiDiTich", o.getLoaiDiTich());
						jsonGenerator.writeStringField("capDo", o.getCapDo());
						jsonGenerator.writeBooleanField("laDiSanTheGioi", o.getLaDiSanTheGioi());
						// viết d.s json
						jsonGenerator.writeArrayFieldStart("tenSuKienLichSu");
						for (var sk : o.getSuKienLichSu()) {
							jsonGenerator.writeString(sk.getTen());
						}
						jsonGenerator.writeEndArray();

						jsonGenerator.writeEndObject();
					}
				}
		));
		om.registerModule(new SimpleModule().addDeserializer(
				DiaDiemLichSu.class,
				new StdDeserializer<>(DiaDiemLichSu.class) {
					@Override
					public DiaDiemLichSu deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
						// lấy jnode
						JsonNode jn = jsonParser.getCodec().readTree(jsonParser);
						// đọc các trường phức tạp
						DiaDiem diaDiem = om.treeToValue(jn.get("diaDiem"), DiaDiem.class);
						List<String> tenSuKienLichSu = new ArrayList<String>(om.treeToValue(jn.get("tenSuKienLichSu"), List.class));

						return new DiaDiemLichSu(
								jn.get("ten").asText(),
								diaDiem,
								jn.get("loaiDiTich").asText(),
								jn.get("capDo").asText(),
								jn.get("laDiSanTheGioi").asBoolean(),
								tenSuKienLichSu
						);
					}
				}
				));
		// endregion

        return om;
    }

    public static JsonNode parse(String string) throws IOException {
        return om.readTree(string);
    }

    public static <A> A fromJson(JsonNode node, Class<A> classA) throws JsonProcessingException {
        return om.treeToValue(node, classA);
    }

    public static JsonNode toJson(Object o) {
        return om.valueToTree(o);
    }

}
