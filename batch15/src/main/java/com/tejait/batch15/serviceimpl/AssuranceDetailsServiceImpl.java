package com.tejait.batch15.serviceimpl;
import com.tejait.batch15.model.AssuranceDetails;
import com.tejait.batch15.repository.AssuranceDetailsRepository;
import com.tejait.batch15.service.AssuranceDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AssuranceDetailsServiceImpl implements AssuranceDetailsService {

    private final AssuranceDetailsRepository repository;


    @Override
    public List<AssuranceDetails> saveAll(List<AssuranceDetails> detailsList) {

        // Ensure new records are inserted
        detailsList.forEach(data -> data.setId(0));

        return repository.saveAll(detailsList);
    }

    @Override
    public List<AssuranceDetails> getAll() {

        return repository.findAll();
    }

}




