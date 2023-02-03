package oop_lecture.application;

import com.fasterxml.jackson.databind.JsonNode;
import oop_lecture.models.*;
import oop_lecture.utility.Json;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Scanner;

import static oop_lecture.application.MainApplication.*;

public class ReadAndLink extends Thread{
	@Override
	public void run() {
		try {
			// region ddls
			File fileDDLS = new File(Objects.requireNonNull(MainApplication.class.getResource("/oop_lecture/data/DiaDiemLichSu.json")).toURI());
			Scanner fileReader = new Scanner(fileDDLS);
			StringBuilder sb = new StringBuilder();
			while (fileReader.hasNextLine()) sb.append(fileReader.nextLine());
			var arrayNode = Json.parse(sb.toString());
			if (arrayNode.isArray()) {
				for (JsonNode n : arrayNode) {
					var x = Json.fromJson(n, DiaDiemLichSu.class);
					ssDiaDiemLichSu.add(x);
				}
			}
			// endregion
			// region lhvh
			File fileLHVH = new File(Objects.requireNonNull(MainApplication.class.getResource("/oop_lecture/data/LeHoiVanHoa.json")).toURI());
			fileReader = new Scanner(fileLHVH);
			sb = new StringBuilder();
			while (fileReader.hasNextLine()) sb.append(fileReader.nextLine());
			arrayNode = Json.parse(sb.toString());
			if (arrayNode.isArray()) {
				for (JsonNode n : arrayNode) {
					var x = Json.fromJson(n, LeHoiVanHoa.class);
					ssLeHoiVanHoa.add(x);
				}
			}
			// endregion
			// region nvls
			File fileNVLS = new File(Objects.requireNonNull(MainApplication.class.getResource("/oop_lecture/data/listNhanVat.json")).toURI());
			fileReader = new Scanner(fileNVLS);
			sb = new StringBuilder();
			while (fileReader.hasNextLine()) sb.append(fileReader.nextLine());
			arrayNode = Json.parse(sb.toString());
			if (arrayNode.isArray()) {
				for (JsonNode n : arrayNode) {
					var x = Json.fromJson(n, NhanVatLichSu.class);
					ssNhanVatLichSu.add(x);
				}
			}
			// endregion
			// region skls
			File fileSKLS = new File(Objects.requireNonNull(MainApplication.class.getResource("/oop_lecture/data/event.json")).toURI());
			fileReader = new Scanner(fileSKLS);
			sb = new StringBuilder();
			while (fileReader.hasNextLine()) sb.append(fileReader.nextLine());
			arrayNode = Json.parse(sb.toString());
			if (arrayNode.isArray()) {
				for (JsonNode n : arrayNode) {
					var x = Json.fromJson(n, SuKienLichSu.class);
					ssSuKienLichSu.add(x);
				}
			}
			// endregion
			// region td
			File fileTD = new File(Objects.requireNonNull(MainApplication.class.getResource("/oop_lecture/data/TrieuDai.json")).toURI());
			fileReader = new Scanner(fileTD);
			sb = new StringBuilder();
			while (fileReader.hasNextLine()) sb.append(fileReader.nextLine());
			arrayNode = Json.parse(sb.toString());
			if (arrayNode.isArray()) {
				for (JsonNode n : arrayNode) {
					var x = Json.fromJson(n, TrieuDai.class);
					ssTrieuDai.add(x);
				}
			}
			// endregion
		} catch (IOException | URISyntaxException ignored) {

		}

		// region link
		for (var x : ssLeHoiVanHoa) x.link(ssNhanVatLichSu);
		for (var x : ssNhanVatLichSu) x.link(ssSuKienLichSu, ssNhanVatLichSu, ssTrieuDai);
		for (var x : ssSuKienLichSu) x.link(ssTrieuDai, ssNhanVatLichSu);
		for (var x : ssTrieuDai) x.link(ssNhanVatLichSu);
		// endregion
	}
}
