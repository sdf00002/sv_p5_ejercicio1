package ejercicio1;

import java.io.*;
import java.util.Date;

public class Mensajes {
	
	//public static final String CRLF="\r\n";
	public static final String OK="+OK";
	public static final String ERR="-ERR";
	//public static final String SOL="SOL";
	//public static final String PET="PET";
	protected static String ID="";
	//static int OPERACION=1;
	//static int QUIT=2;
	protected String codigoRecibido="";
	protected static int secuencia=0;
	protected int longitud;
	protected int secuenciaRecibida = 0;
	protected long fecha;
	private String mensaje = "";
	private Servicios data = null;
	
	public Mensajes(Datos d, int est){
		Date f=new Date();
		fecha=f.getTime();
		Servicios s = new Servicios(String.valueOf(d.getOp1()),String.valueOf(d.getOp2()));
		
		//Dependiendo de la variable est, estariamos en un estado u otro
		if(est==0){
			//Forma cadena de texto
			mensaje=OK+" "+secuencia+" date= "+fecha+" "+" Bienvenido selecciona la operacion";
			longitud=mensaje.length();
			mensaje=mensaje+" "+longitud;
			
		} else 
			if(est==1){
				//Forma cadena de texto
				mensaje=OK+" "+secuencia+" date= "+fecha+" "+" Has seleccionado operacion";
				longitud=mensaje.length();
				mensaje=mensaje+" "+longitud;
				
			}
			else
		if(est==2){
		//Forma cadena de texto
		mensaje=OK+" "+secuencia+" date= "+fecha+" "+s.toString();
		longitud=mensaje.length();
		mensaje=mensaje+" "+longitud;
		
		}
		secuencia++;
	}
	
	
	public byte[] toByteArray()
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream(20);
		DataOutputStream dos = new DataOutputStream(bos);
		
		try {
			dos.writeUTF(mensaje);
			data.toByteArray(dos);
			dos.close();
			return bos.toByteArray();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Mensajes(String datos, byte[] bytedata) {

		ByteArrayInputStream bais = new ByteArrayInputStream(bytedata);

		DataInputStream dis = new DataInputStream(bais);
		try {
			this.secuenciaRecibida = dis.readInt();
			this.fecha = dis.readLong();

		} catch (IOException ex) {
		}

		String [] campos=datos.split(" ");
		if (campos.length==9){
			codigoRecibido=campos[0];
			secuenciaRecibida=Integer.parseInt(campos[1]);
			fecha=Long.parseLong(campos[4]);
			data=new Servicios(campos[5],campos[6]);
			//new Mensajes(data);
		}
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	

}
