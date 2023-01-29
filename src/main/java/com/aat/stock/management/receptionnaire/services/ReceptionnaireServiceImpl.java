/*
package com.aat.stock.management.receptionnaire.services;

import com.aat.stock.management.receptionnaire.Receptionnaire;
import com.aat.stock.management.receptionnaire.ReceptionnaireDto;
import com.aat.stock.management.receptionnaire.ReceptionnaireMapper;
import com.aat.stock.management.receptionnaire.ReceptionnaireRepository;
import com.aat.stock.management.receptionnaire.exceptions.ReceptionnaireNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ReceptionnaireServiceImpl implements ReceptionnaireServiceIntr{
    @Autowired
    private ReceptionnaireRepository receptionnaireRepository;
    private ReceptionnaireMapper receptionnaireMapper;



    @Override
    public List<ReceptionnaireDto> findAllReceptionnaires() {
        return receptionnaireMapper.modelToDtos(receptionnaireRepository.findAll());
    }

    @Override
    public ReceptionnaireDto findReceptionnairesById(Short id) throws ReceptionnaireNotFoundException {
       Receptionnaire receptionnaire = receptionnaireRepository.findById(id)
                .orElseThrow(()->new ReceptionnaireNotFoundException("Receptionnaire n'est pas existe"));
        return receptionnaireMapper.modelToDto(receptionnaire);
    }

    @Override
    public ReceptionnaireDto saveReceptionnaires(ReceptionnaireDto receptionnaireDto) {

        Receptionnaire receptionnair = receptionnaireRepository.save(receptionnaireMapper.dtoToModel(receptionnaireDto));
        return receptionnaireMapper.modelToDto(receptionnair);
    }

    @Override
    public ReceptionnaireDto updateReceptionnaires(ReceptionnaireDto receptionnaireDto) {
        return null;
    }

    @Override
    public void deleteReceptionnaires(Short id) {

    }}

 */
/*=======
public class ReceptionnaireServiceImpl implements ReceptionnaireServiceIntr{
    @Autowired
    private ReceptionnaireRepository receptionnaireRepository;
    
>>>>>>> 28fae95c3b282ba664468c2dc0db2864ee2882e6
}*/
