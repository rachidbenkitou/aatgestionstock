package com.aat.stock.management.matiereIntervenanttransaction;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MatiereIntervenantTransactionMapper {

    MatiereIntervenantTransaction dtoToModel(MatiereIntervenantTransactionDTO matiereIntervenantTransactionDTO);

    MatiereIntervenantTransactionDTO modelToDto(MatiereIntervenantTransaction matiereIntervenantTransaction);

    List<MatiereIntervenantTransactionDTO> modelToDtos(List<MatiereIntervenantTransaction> matiereIntervenantTransactions);

}
