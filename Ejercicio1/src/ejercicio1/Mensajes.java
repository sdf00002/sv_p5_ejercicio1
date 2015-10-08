package ejercicio1;

import java.util.Date;

public class Mensajes {
	
	//public static final String CRLF="\r\n";
	public static final String OK="+OK";
	public static final String ERR="-ERR";
	//public static final String SOL="SOL";
	//public static final String PET="PET";
	//static int ID=0;
	//static int OPERACION=1;
	static int QUIT=2;
	protected String codigoRecibido="";
	protected static int secuencia;
	protected int longitud;
	protected int secuenciaRecibida = 0;
	protected long fecha;
	private String mensaje = "";
	private Servicios data = null;
	
	public Mensajes(Servicios s){
		Date f=new Date();
		fecha=f.getTime();
		
		//Forma cadena de texto
		mensaje=OK+" "+secuencia+" date= "+fecha+" "+s.toString();
		longitud=mensaje.length();
		mensaje=mensaje+" "+longitud;
		
		secuencia++;
		
	}
	
	public Mensajes(String datos){
		String [] campos=datos.split(" ");
		if (campos.length==9){
			codigoRecibido=campos[0];
			secuenciaRecibida=Integer.parseInt(campos[1]);
			fecha=Long.parseLong(campos[4]);
			data=new Servicios(Double.parseDouble(campos[5]),Double.parseDouble(campos[6]),Double.parseDouble(campos[7]));
		}
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	

}
