package com.bad.planilla.backend.apirest.services;

import com.bad.planilla.backend.apirest.entity.UnidadesorganizacionalesEntity;
import com.bad.planilla.backend.apirest.repository.UnidadOrganizacionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("unidadOrganizacionalService")
public class UnidadOrganizacionalServiceImp implements IUnidadOrganizacionalService{
    @Autowired
    private UnidadOrganizacionalRepository unidadOrganizacionalRepository;

    @Override
    public List<UnidadesorganizacionalesEntity> list() {
        return unidadOrganizacionalRepository.findAllByOrderByNombre();
    }

    @Override
    public UnidadesorganizacionalesEntity guardar(UnidadesorganizacionalesEntity unidadOrganizacional) {
        return unidadOrganizacionalRepository.save(unidadOrganizacional);
    }

    @Override
    public UnidadesorganizacionalesEntity findById(int id) {
        return unidadOrganizacionalRepository.findByIdUnidadorganizacional(id);
    }

    @Override
    public UnidadesorganizacionalesEntity modificar(UnidadesorganizacionalesEntity unidadOrganizacional) {
        return unidadOrganizacionalRepository.save(unidadOrganizacional);
    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public String desactivar(int id) {
        return null;
    }

	@Override
	public List<UnidadesorganizacionalesEntity> listUnidadMayor(boolean unidad) {
		
		return unidadOrganizacionalRepository.findByUnidadmayorAndEstado(unidad,true);
	}

	@Override
	public List<UnidadesorganizacionalesEntity> listUnidadesSuperiores(int unidad) {
		
		return unidadOrganizacionalRepository.findByUnidadOrganizacionalSuperiorAndEstado(unidad,true);
	}
}
