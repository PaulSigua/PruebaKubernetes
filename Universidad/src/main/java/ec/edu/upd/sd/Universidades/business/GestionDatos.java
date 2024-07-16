package ec.edu.upd.sd.Universidades.business;

import ec.edu.upd.sd.Universidades.model.Universidades;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class GestionDatos {

	@Inject
	GestionUniversidad gUni;
	
	@PostConstruct
	public void init() {
		System.out.println("iniciando");
		
		Universidades uni = new Universidades();
		uni.setNombre("Universidades Politecnica Salesiana");
		uni.setDireccion("Calle Vieja");
		uni.setTelefono("4035316");
		
		gUni.guardarUniversidads(uni);
		
		
	}
}
