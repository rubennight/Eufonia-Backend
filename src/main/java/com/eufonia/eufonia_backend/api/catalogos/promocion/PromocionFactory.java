package com.eufonia.eufonia_backend.api.catalogos.promocion;

import java.util.ArrayList;
import java.util.List;

import com.eufonia.eufonia_backend.persistence.model.PromocionEntity;

public class PromocionFactory {
    
    public static Promocion toObject(PromocionEntity promocionEntity){

        Promocion promocion = new Promocion();

        promocion.setIdPromocion(promocionEntity.getIdPromocion());
        promocion.setNombre(promocionEntity.getNombre());
        promocion.setDescripcion(promocionEntity.getDescripcion());
        promocion.setDescuento(promocionEntity.getDescuento());
        promocion.setFechaInicio(promocionEntity.getFechaInicio());
        promocion.setFechaFinal(promocionEntity.getFechaFin());
        promocion.setVigencia(promocionEntity.getVigencia());

        return promocion;
    }

    public static List<Promocion> toListObject(List<PromocionEntity> promocionEntities){

        List<Promocion> promociones = new ArrayList<>();

        for (PromocionEntity promocionEntity : promocionEntities) {
            Promocion promocion = new Promocion();

            promocion.setIdPromocion(promocionEntity.getIdPromocion());
            promocion.setNombre(promocionEntity.getNombre());
            promocion.setDescripcion(promocionEntity.getDescripcion());
            promocion.setFechaInicio(promocionEntity.getFechaInicio());
            promocion.setFechaFinal(promocionEntity.getFechaFin());
            promocion.setDescuento(promocionEntity.getDescuento());
            promocion.setVigencia(promocionEntity.getVigencia());

            promociones.add(promocion);
        }

        return promociones;
    }

}