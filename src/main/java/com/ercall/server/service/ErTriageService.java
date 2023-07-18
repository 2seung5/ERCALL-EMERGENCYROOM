package com.ercall.server.service;

import com.ercall.server.dto.ErTriageResponseDto;
import com.ercall.server.entity.ErTriage;
import com.ercall.server.entity.ErTriageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ErTriageService {
    private final ErTriageRepository erTriageRepository;
    //콜 리스트 조회=>er_triage db기반으로 보여줌
    @Transactional
    public List<ErTriageResponseDto> findAll(){
        Sort sort = Sort.by(Sort.Direction.DESC,"erTriageId","sortingTime");
        List<ErTriage> list = erTriageRepository.findAll(sort);
        return list.stream().map(ErTriageResponseDto::new).collect(Collectors.toList());
        //ErTriage 객체를 ErTriageResponseDto 객체로 변환함

    }
    //중증도 분류표 상세조회
    @Transactional
    public  ErTriageResponseDto findById(final Long erTriageId){
        ErTriage entity= erTriageRepository.findById(erTriageId).orElseThrow(()->new IllegalArgumentException("Posts not found with id : " + erTriageId) );
        return new ErTriageResponseDto(entity);
    }
}
