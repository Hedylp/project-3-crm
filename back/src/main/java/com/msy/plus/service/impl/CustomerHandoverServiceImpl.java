package com.msy.plus.service.impl;

import com.msy.plus.mapper.CustomerHandoverMapper;
import com.msy.plus.entity.CustomerHandover;
import com.msy.plus.service.CustomerHandoverService;
import com.msy.plus.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* @author MoShuYing
* @date 2021/05/21
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class CustomerHandoverServiceImpl extends AbstractService<CustomerHandover> implements CustomerHandoverService {
    @Resource
    private CustomerHandoverMapper customerHandoverMapper;

}
