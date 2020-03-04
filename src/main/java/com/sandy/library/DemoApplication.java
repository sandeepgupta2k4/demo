package com.sandy.library;

import com.sandy.library.entity.TestTable;
import com.sandy.library.repository.TestTableRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.io.ByteArrayOutputStream;
import java.util.Optional;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterOutputStream;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Inject
	TestTableRepository repo;

	private String decompress(byte[] inputData) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {

			InflaterOutputStream ios = new InflaterOutputStream(out);
			ios.write(inputData);
			ios.flush();
			ios.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return out.toString();
	}

	private byte[] compress(String inputData) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			DeflaterOutputStream dos = new DeflaterOutputStream(out);
			dos.write(inputData.getBytes());
			dos.flush();
			dos.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return out.toByteArray();
	}
	@GetMapping("/data")
	public String getData() {
		TestTable data = new TestTable();
		String myStr = "{\"field1\" : \"value1\", \"field2\": \"value2\"}";
		data.setJsonField(myStr);
		data.setTextField(myStr);
		data.setBlobField(compress(myStr));
		repo.save(data);
		Optional<TestTable> record = repo.findById(5);
		TestTable result = record.get();
		return decompress(result.getBlobField());
	}

}
