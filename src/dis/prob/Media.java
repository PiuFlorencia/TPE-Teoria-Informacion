package dis.prob;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Media {
	private BufferedReader br;
	private String seniales;
	private int cantidad;
	private double media;
	private double suma;
	private double senial;
	private double desvioEstandar;
	
	public Media(FileReader file) {
		super();
		this.br = new BufferedReader(file);
		this.seniales = "null";
		this.cantidad = 0;
		this.media = 0;
		this.suma = 0;
		this.senial = 0;
		this.desvioEstandar = 0;
	}
	
	
	
	public double calcularMedia() {
		try {
			seniales = br.readLine();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (seniales != null ) {
			senial = toDouble(seniales);
			suma+= senial;
			cantidad++;
			try {
				seniales = br.readLine();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		media = suma/cantidad;
		return media;	
	}
	
	public double calcularDesvio(FileReader file) {
		BufferedReader braux = new BufferedReader(file);
		try {
			seniales = br.readLine();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (seniales != null ) {
			senial = toDouble(seniales);
			suma+= senial;
			cantidad++;
			try {
				seniales = br.readLine();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		media = suma/cantidad;
		double divisor = 0;
		for (int i=0; i < cantidad; i++) {
			try {
				seniales = braux.readLine();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			senial = toDouble(seniales);
			divisor+= (senial - media) * (senial - media);
			System.out.println("divisor: " + divisor);
		}
		desvioEstandar = Math.sqrt(divisor/cantidad);
		return desvioEstandar;
		
		
	}
	public static Double toDouble(String s) {
	    return Double.parseDouble(s);
	}
	
}
