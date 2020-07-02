package com.bad.planilla.backend.apirest.services;

import com.bad.planilla.backend.apirest.entity.UnidadesorganizacionalesEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUnidadOrganizacionalService {

    public abstract List<UnidadesorganizacionalesEntity> list();
    public abstract UnidadesorganizacionalesEntity guardar(UnidadesorganizacionalesEntity unidadOrganizacional);
    public abstract UnidadesorganizacionalesEntity findById(int id);
    public abstract UnidadesorganizacionalesEntity modificar(UnidadesorganizacionalesEntity unidadOrganizacional);
    public void eliminar(int id);
    public abstract String desactivar(int id);
    
    public abstract List<UnidadesorganizacionalesEntity> listUnidadMayor(boolean unidad);
    public abstract List<UnidadesorganizacionalesEntity> listUnidadesSuperiores(int unidad);
}
