package hust.soict.globalict.vntourism.backend.dataprocess;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.riot.RDFDataMgr;

import hust.soict.globalict.vntourism.backend.rdfconstant.Prefix;

public interface IDataProcess {
	// This function creates a sparql query to query data
	public String createSparqlQuery();

	// This function creates a file name of the information we want to get
	public default String createFileName() {
		return this.getClass().getSimpleName() + ".ttl";
	};

	// This function creates a file name for the whole data we query from the
	// internet: rawRDF_+filename
	public default String createRawFileName() {
		return "rawRDF_" + this.createFileName();
	};

	// This function query all data from the internet and store it in a raw ttl file
	public default void createRawTtlFile(String... object) {
		try {
			// Create the raw file we want to store the queried data
			FileWriter out = new FileWriter(this.createRawFileName());
			for (String i : object) {
				// Sparql query to query all the data from the site we want
				String s1 = Prefix.PREFIX + "CONSTRUCT {\r\n" + "    ?s ?p ?o\r\n" + "}\r\n" + "WHERE {\r\n"
						+ "    ?s dbo:wikiPageWikiLink " + i + "\r\n" + "    ?s ?p ?o.\r\n" + "}";

				// Query it from the site http://dbpedia.org/sparql
				org.apache.jena.query.Query query = QueryFactory.create(s1);
				QueryExecution qExe = QueryExecution.service("http://dbpedia.org/sparql").query(query).timeout(50000)
						.build();
				Model results = qExe.execConstruct();

				// Write it in raw file
				results.write(out, "TURTLE");

				// close the model
				qExe.close();
				results.close();
			}

			// close the file after use
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// This functions deletes the raw ttl file
	public default void deleteRawTtlFile() {
		try {
			Files.deleteIfExists(Paths.get(this.createRawFileName()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// This function collects data to an .ttl file
	// Also store it in OutputStream stream to print it on UI Screen
	public default void collectDataToTtlFile(OutputStream stream) {
		// Create the query
		String inputQuery = this.createSparqlQuery();

		// Load the raw file that we take data from
		Model inModel = RDFDataMgr.loadModel(this.createRawFileName());

		// Start extracting data using Sparql
		try (QueryExecution qExe = QueryExecution.create(inputQuery, inModel)) {
			Model results = qExe.execConstruct();
			try {
				// Write the data we extracted in file
				FileWriter out = new FileWriter(this.createFileName());
				results.write(out, "TURTLE");

				// close the file after use
				out.close();

				// Write the data we extracted in stream to put in on UI screen
				results.write(stream, "TURTLE");

			} catch (Exception e) {
				// Catch errors
				e.printStackTrace(new PrintStream(stream));
			} finally {
				// close the model
				qExe.close();
				results.close();
			}
		} catch (Exception e) {
			// Catch errors
			e.printStackTrace(new PrintStream(stream));
		} finally {
			// close the model
			inModel.close();

			// delete the raw file after extracting data from it
			this.deleteRawTtlFile();
		}
	}

}
