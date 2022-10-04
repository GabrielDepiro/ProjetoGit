package teste;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class teste {
	public static void main(String[] args){
		SparkSession spark = SparkSession.builder().appName("teste").master("local[*]").getOrCreate();
		Logger.getLogger("org.apache").setLevel(Level.WARN);
		
		Dataset<Row> emp = spark.read()
				//respeitando as variaveis dentro do csv
				.option("header", true)
				//tenta descobrir os tipos de dados dentro do csv
				.option("inferSchema", true)
				.csv("C:\\Users\\gabri\\OneDrive\\Área de Trabalho\\Api_Iacit-main\\ApiDtTchIacit");
		
		emp.show();
		spark.close();
	}
}
