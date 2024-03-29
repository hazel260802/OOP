package oop_lecture.utility;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import oop_lecture.models.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Json {
	private static final ObjectMapper om = getDefaultObjectMapper();

	private static ObjectMapper getDefaultObjectMapper() {
		ObjectMapper om = new ObjectMapper();
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		om.findAndRegisterModules();
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
						DiaDiemLichSu diaDiemLichSu = new DiaDiemLichSu(jn.get("ten").asText());
						diaDiemLichSu.setDiaDiem(diaDiem);
						diaDiemLichSu.setLoaiDiTich(jn.get("loaiDiTich").asText());

						return diaDiemLichSu;
					}
				}
				));
		// endregion
		
		om.registerModule(new SimpleModule().addSerializer(
				LeHoiVanHoa.class,
				new StdSerializer<>(LeHoiVanHoa.class) {
					@Override
					public void serialize(LeHoiVanHoa o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
						// bắt đầu viết file json
						jsonGenerator.writeStartObject();
						jsonGenerator.writeStringField("ten", o.getTen());
						jsonGenerator.writeObjectField("noiDienRa", o.getNoiDienRa());
						jsonGenerator.writeObjectField("thoiDiemToChuc", o.getThoiDiemToChuc());
						jsonGenerator.writeStringField("lanDauToChuc", o.getLanDauToChuc());
						// viết d.s json
						jsonGenerator.writeArrayFieldStart("nhanVatLienQuan");
						for (var sk : o.getNhanVatLienQuan()) {
							jsonGenerator.writeString(sk.getTen());
						}
						jsonGenerator.writeEndArray();

						jsonGenerator.writeEndObject();
					}
				}
		));
		om.registerModule(new SimpleModule().addDeserializer(
				LeHoiVanHoa.class,
				new StdDeserializer<>(LeHoiVanHoa.class) {
					@Override
					public LeHoiVanHoa deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
						// lấy jnode
						JsonNode jn = jsonParser.getCodec().readTree(jsonParser);
						// đọc các trường phức tạp
						DiaDiem noiDienRa = om.treeToValue(jn.get("diaDiem"), DiaDiem.class);
						Date thoiDiemToChuc = om.convertValue(jn.get("thoiDiemToChuc"), Date.class);
						List<String> tenNhanVatLienQuan = new ArrayList<>();
						var sjn = jn.get("nhanVatLienQuan");
						if (sjn.isArray()) {
							for (var n : sjn) tenNhanVatLienQuan.add(om.treeToValue(n, String.class));
						}
						return new LeHoiVanHoa(
								jn.get("ten").asText(),
								noiDienRa,
								thoiDiemToChuc,
								jn.get("lanDauToChuc").asText(),
								tenNhanVatLienQuan
						);
					}
				}
		));
		// endregion

		// region định nghĩa Json NVLS
		om.registerModule(new SimpleModule().addSerializer(
				NhanVatLichSu.class,
				new StdSerializer<>(NhanVatLichSu.class) {
					@Override
					public void serialize(NhanVatLichSu o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
						// bắt đầu viết file json
						jsonGenerator.writeStartObject();
						jsonGenerator.writeStringField("ten", o.getTen());
						jsonGenerator.writeObjectField("ngaySinh", o.getNgaySinh());
						jsonGenerator.writeObjectField("ngayMat", o.getNgayMat());
						jsonGenerator.writeStringField("moTaChung", o.getMoTaChung());
						// viết d.s json
						jsonGenerator.writeArrayFieldStart("nhanVatLienQuan");
						for (var sk : o.getNhanVatLienQuan()) {
							jsonGenerator.writeString(sk.getTen());
						}
						jsonGenerator.writeEndArray();

						jsonGenerator.writeArrayFieldStart("suKienLichSu");
						for (var sk : o.getSuKienLichSu()) {
							jsonGenerator.writeString(sk.getTen());
						}
						jsonGenerator.writeEndArray();

						jsonGenerator.writeEndObject();
					}
				}
		));
		om.registerModule(new SimpleModule().addDeserializer(
				NhanVatLichSu.class,
				new StdDeserializer<>(NhanVatLichSu.class) {
					@Override
					public NhanVatLichSu deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
						// lấy jnode
						JsonNode jn = jsonParser.getCodec().readTree(jsonParser);
						// đọc các trường phức tạp
						Year ngaySinh = om.convertValue(jn.get("ngaySinh"), Year.class);
						Year ngayMat = om.convertValue(jn.get("ngayMat"), Year.class);
//						List<String> tenNhanVatLienQuan = new ArrayList<String>(om.treeToValue(jn.get("tenNhanVatLienQuan"), List.class));
//						List<String> tenSuKienLichSu = new ArrayList<String>(om.treeToValue(jn.get("tenSuKienLichSu"), List.class));

						List<String> tenNhanVatLienQuan = new ArrayList<>();
						var sjn = jn.get("nhanVatLienQuan");
						if (sjn.isArray()) {
							for (var n : sjn) tenNhanVatLienQuan.add(om.treeToValue(n, String.class));
						}

						List<String> tenSuKienLichSu = new ArrayList<>();
						sjn = jn.get("suKienLichSu");
						if (sjn.isArray()) {
							for (var n : sjn) tenSuKienLichSu.add(om.treeToValue(n, String.class));
						}

						return new NhanVatLichSu(
								jn.get("ten").asText(),
								tenSuKienLichSu,
								ngaySinh,
								ngayMat,
								jn.get("moTaChung").asText(),
								tenNhanVatLienQuan
						);
					}
				}
		));
		// endregion

		// region định nghĩa Json SKLS
		om.registerModule(new SimpleModule().addSerializer(
				SuKienLichSu.class,
				new StdSerializer<>(SuKienLichSu.class) {
					@Override
					public void serialize(SuKienLichSu o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
						// bắt đầu viết file json
						jsonGenerator.writeStartObject();
						jsonGenerator.writeStringField("ten", o.getTen());
						jsonGenerator.writeObjectField("namBatDau", o.getNamBatDau());
						jsonGenerator.writeObjectField("namKetThuc", o.getNamKetThuc());
						jsonGenerator.writeStringField("moTa", o.getMoTa());
						jsonGenerator.writeObjectField("TrieuDai", o.getTrieuDai());
						// viết d.s json
						jsonGenerator.writeArrayFieldStart("diaDiemLienQuan");
						for (var sk : o.getDiaDiemLienQuan()) {
							jsonGenerator.writeObject(sk.ten);
						}
						jsonGenerator.writeEndArray();

						jsonGenerator.writeArrayFieldStart("nhanVatLienQuan");
						for (var sk : o.getNhanVatLienQuan()) {
							jsonGenerator.writeString(sk.getTen());
						}
						jsonGenerator.writeEndArray();

						jsonGenerator.writeEndObject();
					}
				}
		));
		om.registerModule(new SimpleModule().addDeserializer(
				SuKienLichSu.class,
				new StdDeserializer<>(SuKienLichSu.class) {
					@Override
					public SuKienLichSu deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
						// lấy jnode
						JsonNode jn = jsonParser.getCodec().readTree(jsonParser);
						// đọc các trường phức tạp
						Year namBatDau = om.convertValue(jn.get("namBatDau"), Year.class);
						Year namKetThuc = om.convertValue(jn.get("namKetThuc"), Year.class);

						List<String> tenDiaDiemLienQuan = new ArrayList<>();
						var sjn = jn.get("diaDiemLienQuan");
						if (sjn.isArray()) {
							for (var n : sjn) tenDiaDiemLienQuan.add(om.treeToValue(n, String.class));
						}

						List<String> tenNhanVatLienQuan = new ArrayList<>();
						sjn = jn.get("nhanVatLienQuan");
						if (sjn.isArray()) {
							for (var n : sjn) tenNhanVatLienQuan.add(om.treeToValue(n, String.class));
						}

//						List<String> tenDiaDiemLienQuan = new ArrayList<>(om.treeToValue(jn.get("tenDiaDiemLienQuan"), List.class));
//						List<String> tenNhanVatLienQuan = new ArrayList<String>(om.treeToValue(jn.get("nhanVatLienQuan"), List.class));

						return new SuKienLichSu(
								jn.get("ten").asText(),
								namBatDau,
								namKetThuc,
								jn.get("moTa").asText(),
								tenDiaDiemLienQuan,
								tenNhanVatLienQuan
						);
					}
				}
		));
		// endregion

		// region định nghĩa Json TD
		om.registerModule(new SimpleModule().addSerializer(
				TrieuDai.class,
				new StdSerializer<>(TrieuDai.class) {
					@Override
					public void serialize(TrieuDai o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
						// bắt đầu viết file json
						jsonGenerator.writeStartObject();
						jsonGenerator.writeStringField("ten", o.getTen());
						jsonGenerator.writeObjectField("batDau", o.getBatDau());
						jsonGenerator.writeObjectField("ketThuc", o.getKetThuc());
						jsonGenerator.writeObjectField("thuDo", o.getKinhDo());
						// viết d.s json
						jsonGenerator.writeArrayFieldStart("hoangDe");
						for (var sk : o.getHoangDe()) {
							jsonGenerator.writeString(sk.getTen());
						}
						jsonGenerator.writeEndArray();

						jsonGenerator.writeEndObject();
					}
				}
		));
		om.registerModule(new SimpleModule().addDeserializer(
				TrieuDai.class,
				new StdDeserializer<>(SuKienLichSu.class) {
					@Override
					public TrieuDai deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
						// lấy jnode
						JsonNode jn = jsonParser.getCodec().readTree(jsonParser);
						// đọc các trường phức tạp
						Year batDau = om.convertValue(jn.get("batDau"), Year.class);
						Year ketThuc = om.convertValue(jn.get("ketThuc"), Year.class);
						//List<String> tenHoangDe = new ArrayList<String>(om.treeToValue(jn.get("tenHoangDe"), List.class));

						List<String> tenHoangDe = new ArrayList<>();
						var sjn = jn.get("hoangDe");
						if (sjn.isArray()) {
							for (var n : sjn) tenHoangDe.add(om.treeToValue(n, String.class));
						}

						return new TrieuDai(
								jn.get("ten").asText(),
								batDau,
								ketThuc,
								jn.get("thuDo").asText(),
								tenHoangDe
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
	public static void toFile (File file, Object o) throws IOException {
		om.writeValue(file, o);
	}

}