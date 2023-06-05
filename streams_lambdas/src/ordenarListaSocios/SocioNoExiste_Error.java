package ordenarListaSocios;

public class SocioNoExiste_Error extends Exception {
	public SocioNoExiste_Error() {
        super("\nEl socio no existe, compruebe el DNI introducido.\n");
    }
}
