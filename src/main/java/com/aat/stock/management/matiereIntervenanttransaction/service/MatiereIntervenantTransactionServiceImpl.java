package com.aat.stock.management.matiereIntervenanttransaction.service;

import com.aat.stock.management.filiere.exceptions.FiliereNotFoundException;
import com.aat.stock.management.intervenant.Intervenant;
import com.aat.stock.management.intervenant.IntervenantRepository;
import com.aat.stock.management.matiereIntervenanttransaction.MatiereIntervenantTransaction;
import com.aat.stock.management.matiereIntervenanttransaction.MatiereIntervenantTransactionDTO;
import com.aat.stock.management.matiereIntervenanttransaction.MatiereIntervenantTransactionMapper;
import com.aat.stock.management.matiereIntervenanttransaction.MatiereIntervenantTransactionRepository;
import com.aat.stock.management.matiereIntervenanttransaction.exceptions.InsufficientQuantityException;
import com.aat.stock.management.matierePremiere.MatierePremiere;
import com.aat.stock.management.matierePremiere.MatierePremiereMapper;
import com.aat.stock.management.matierePremiere.MatierePremiereRepository;
import com.aat.stock.management.matierePremiere.exceptions.MatierePremiereNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatiereIntervenantTransactionServiceImpl implements MatiereIntervenantTransactionServiceIntr {

    @Autowired
    private MatierePremiereRepository matierePremiereRepository;
    @Autowired
    private MatierePremiereMapper matierePremiereMapper;
    @Autowired
    private IntervenantRepository intervenantRepository;
    @Autowired
    private MatiereIntervenantTransactionMapper matiereIntervenantTransactionMapper;
    @Autowired
    private MatiereIntervenantTransactionRepository matiereIntervenantTransactionRepository;


    @Override
    public List<MatiereIntervenantTransactionDTO> findAllTransaction(){
        List <MatiereIntervenantTransaction> matiereIntervenantTransactions = matiereIntervenantTransactionRepository.findAll();
        return matiereIntervenantTransactionMapper.modelToDtos(matiereIntervenantTransactions);
    }
    @Override
    public MatiereIntervenantTransactionDTO matiereSortie(MatiereIntervenantTransactionDTO matiereIntervenantTransactionDTO)throws InsufficientQuantityException {

       if(isMatiereExists(matiereIntervenantTransactionDTO.getMatierePremiere().getCode()) == true
               && isReceptionnaireExists(matiereIntervenantTransactionDTO.getIntervenant().getId())==true){
           if(matiereIntervenantTransactionDTO.getQuantiteLivre()>matiereIntervenantTransactionDTO.getMatierePremiere().getStockActuel()){
               throw new InsufficientQuantityException("le stocke quantient seulement:"
                       +matiereIntervenantTransactionDTO.getMatierePremiere().getStockActuel());

           }
           else{
              //short qte_stock=matiereIntervenantTransactionDTO.getMatierePremiere().getStockActuel();
              // matiereIntervenantTransactionDTO.getMatierePremiere().setStockActuel((short) (qte_stock-matiereIntervenantTransactionDTO.getQuantiteLivre()));
               MatiereIntervenantTransaction matiereIntervenantTransaction = matiereIntervenantTransactionMapper.dtoToModel(matiereIntervenantTransactionDTO);
               MatiereIntervenantTransaction savedmatiereIntervenantTransaction= matiereIntervenantTransactionRepository.save(matiereIntervenantTransaction);
               return matiereIntervenantTransactionMapper.modelToDto(savedmatiereIntervenantTransaction);
           }
       }
       else {
           return null;
       }

    }
    public boolean isMatiereExists(String codeMatiere)throws MatierePremiereNotFoundException{

        Optional<MatierePremiere> existingMatiere = matierePremiereRepository.findById(codeMatiere);
        if(!existingMatiere.isPresent()) {
            throw new FiliereNotFoundException("la Matiere premiére avec ce nom n'existe pas");

        }
        return existingMatiere.isPresent();
    }
    public boolean isReceptionnaireExists(Long id)throws FiliereNotFoundException{

        Optional<Intervenant> existingIntervenant = intervenantRepository.findById(id);
        if(!existingIntervenant.isPresent()) {
            throw new FiliereNotFoundException("il n y a aucun receptionnaire avec ce id");

        }
        return existingIntervenant.isPresent();
    }
}
