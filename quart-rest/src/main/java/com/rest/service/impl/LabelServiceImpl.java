package com.rest.service.impl;

import com.common.base.BaseServiceImpl;
import com.common.dao.LabelDao;
import com.common.entity.Label;
import com.rest.service.LabelService;
import org.springframework.stereotype.Service;

@Service
public class LabelServiceImpl extends BaseServiceImpl<LabelDao, Label> implements LabelService {
}
