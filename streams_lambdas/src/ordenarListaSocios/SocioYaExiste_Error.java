package ordenarListaSocios;

public class SocioYaExiste_Error extends Exception {

	public SocioYaExiste_Error() {
        super("\nEl socio que intenta ingresar ya existe, compruebe el DNI introducido.\n");
    }
}
