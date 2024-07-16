package ec.edu.upd.sd.Universidades.business;

import java.util.List;

import ec.edu.upd.sd.Universidades.dao.UniversidadDAO;
import ec.edu.upd.sd.Universidades.model.Universidades;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionUniversidad {

	@Inject
	private UniversidadDAO daoMsjUsuario;

	public void guardarUniversidads(Universidades Universidades) {
		Universidades men = daoMsjUsuario.read(Universidades.getCodigo());
		if (men != null) {
			daoMsjUsuario.update(Universidades);
		} else {
			System.out.println("MENSAJEEEEEEEEEEEES: " + Universidades);
			daoMsjUsuario.insert(Universidades);
			
		}
	}

	public void actualizarUniversidad(Universidades Universidades) throws Exception {
		Universidades men = daoMsjUsuario.read(Universidades.getCodigo());
		if (men != null) {
			daoMsjUsuario.update(Universidades);
		} else {
			throw new Exception("Universidades no existe");
		}
	}
	
	public void borrarCliente(int codigo) {

		daoMsjUsuario.remove(codigo);
	}

	public List<Universidades> getMensajes() {
		return daoMsjUsuario.getAll();
	}
}
