package ejercicio1;

public interface Cliente {
	
	/**
	 * M�todo para autenticar un usuario
	 */
	public void login();
	
	/**
	 * @param men cadena de caracteres que manda el cliente
	 */
	public void envia(String men);
	
	/**
	 * @return devuelve cadena de caracteres recibida de servidor
	 */
	public String recibe();
	
	/**
	 * M�todo para seleccionar la operacion que quiere realizar el cliente
	 */
	public void seleccionOperacion();
	
	
	/**
	 * M�todo para indicar que el cliente quiere salir
	 */
	public void salir();
	
}
