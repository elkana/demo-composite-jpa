package com.example.democompositejpa.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import com.example.democompositejpa.model.LdvDetail;
import com.example.democompositejpa.model.LdvDetailId;
import jakarta.transaction.Transactional;

public interface LdvDetailsRepo extends ListCrudRepository<LdvDetail, LdvDetailId> {
    LdvDetail findByContractNo(String contractNo);

    @Transactional
    @Modifying
    int deleteByContractNo(String contractNo);


    @Transactional
    @Modifying
    @Query("update LdvDetail o set o.contractNo=?2 WHERE o.contractNo=?1")
    int updateByContractNo(String contractOld, String contractNew);

}
