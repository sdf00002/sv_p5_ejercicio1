package ejercicio1;

import java.io.*;

/**
 * @author Sergio
 *
 */
public class Mensajes {
	//PDU formada por: Version+secuencia+comando+payload
	public static final String CRLF="\r\n";
	public static final String OK="+OK";
	public static final String ERR="-ERR";
	public static final String QUIT="QUIT";
	//public static final String PET="PET";
	protected int longitud,secuencia=0,estado=0;
	protected static final byte version=1;
	protected long fecha;
	private boolean salida=false;
	private String mensaje = "";
	private Datos data=null;

	
	/**
	 * @param d Datos que recibe el constructor por defecto
	 */
	public Mensajes(Datos d){
		data=d;
				
		do {
		//Dependiendo de la variable est, estariamos en un estado u otro
		if(estado==0){		
			//Comprobamos que se recibe un mensaje OK
			if(data.getComando().equals(Mensajes.OK)){
				//Comprobamos si el usuario cumple nuestras condiciones
				if(this.tieneNumero(data.getUsuario())==true && data.getUsuario().length()>=6 && data.getUsuario().length()<=12){
			this.toByteArray(data, "Selecciona operacion");
			estado++;
			secuencia++;
				}
				else {
					Datos d1 = new Datos(Mensajes.ERR,data.getUsuario(),data.getOp1(),data.getOp2(),data.getSigno(),data.getRes());
					this.toByteArray(d1, "Usuario no valido");
					secuencia++;
				}
			}
			// Si el comando recibido no es OK mandamos un mensaje de error
			else {
				Datos d2 = new Datos(Mensajes.ERR,data.getUsuario(),data.getOp1(),data.getOp2(),data.getSigno(),data.getRes());
				this.toByteArray(d2,"Seleccion incorrecta");
				secuencia++;
			}
		} else 
			if(estado==1){
				//Si recibimos un OK
				if(data.getComando()==Mensajes.OK){
					//Si quiere realizar una suma
					if(data.getSigno().equals("+")){
						Servicios s = new Servicios(data.getOp1(),data.getOp2());
						Datos dat = new Datos(data.getComando(),data.getUsuario(),data.getOp1(),data.getOp2(),data.getSigno(),s.Suma());
						this.toByteArray(dat);
						secuencia++;
					}
					else 
					//Si quiere realizar una resta
					if(d.getSigno().equals("-")){
						Servicios s = new Servicios(data.getOp1(),data.getOp2());
						Datos dat = new Datos(data.getComando(),data.getUsuario(),data.getOp1(),data.getOp2(),data.getSigno(),s.Resta());
						this.toByteArray(dat);
						secuencia++;
					}
					//Si el signo es incorrecto enviamos mensaje de error
					else{
						Datos d3 = new Datos(Mensajes.ERR,data.getUsuario(),data.getOp1(),data.getOp2(),data.getSigno(),data.getRes());
						this.toByteArray(d3,"Signo incorrecto");
						secuencia++;
						}	
				}
				//Si recibimos un quit, salimos
				else if (data.getComando().equals(Mensajes.QUIT)){
					estado=2;
					secuencia++;
				}
				
			}
			else
		if(estado==2){
		Datos d4 = new Datos(Mensajes.QUIT,data.getUsuario(),data.getOp1(),data.getOp2(),data.getSigno(),data.getRes());
		this.toByteArray(d4, "Has salido del servicio");
		salida=true;	
		}
		
		} while (salida=false);
	}
	
	
	/**
	 * @param data datos que queremos pasar a bytes
	 */
	public byte[] toByteArray(Datos data)
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream(29);
		DataOutputStream dos = new DataOutputStream(bos);
		
		try {
			dos.write(version);
			dos.writeInt(secuencia);
			dos.writeUTF(data.getComando());
			dos.writeUTF(data.getUsuario());
			dos.writeDouble(data.getRes());
			dos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
		byte[] bytes =  bos.toByteArray(); // devuelve byte[]
		return bytes;
	}
	
	/**
	 * @param dat datos que queremos pasar a bytes
	 * @param cad cadena de caracteres que complementa a los datos
	 */
	public byte[] toByteArray(Datos dat, String cad)
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream(41);
		DataOutputStream dos = new DataOutputStream(bos);
		
		try {
			dos.write(version);
			dos.writeInt(secuencia);
			dos.writeUTF(dat.getComando());
			dos.writeUTF(dat.getUsuario());
			dos.writeUTF(cad);
			dos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		}
		byte[] bytes =  bos.toByteArray(); // devuelve byte[]
		return bytes;
	}
	
	/**
	 * @param word String que pasamos para comprobar si contiene algun numero
	 * @return True si contiene algun numero el String, False si no lo lleva
	 */
	public boolean tieneNumero(String word){
		if(word.contains("1"))
			return true;
		else if (word.contains("2"))
			return true;
		else if (word.contains("3"))
			return true;
		else if (word.contains("4"))
			return true;
		else if (word.contains("5"))
			return true;
		else if(word.contains("6"))
			return true;
		else if	(word.contains("7"))
			return true;
		else if	(word.contains("8"))
			return true;
		else if	(word.contains("9"))
			return true;
		else if	(word.contains("0"))
	return true;
else
	return false;
	
}
	
	/**
	 * @return devuelve el valor de la variable mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}
	
	/**
	 * @param mensaje Asigna la cadena que le pasamos a la variable mensaje
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	

}
