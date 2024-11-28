package com.example.education.service.impl;

import com.example.education.dto.request.ServiceCreateUpdateRequest;
import com.example.education.model.ServiceModel;
import com.example.education.repository.ServiceRepository;
import com.example.education.service.ServiceModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ServiceModelServiceImpl implements ServiceModelService {
    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public List<ServiceModel> getAll() {
        return serviceRepository.findAll();
    }

    @Override
    public ServiceModel detail(UUID id) {
        Optional<ServiceModel> serviceModel = serviceRepository.findById(id);

        return serviceModel.orElse(null);
    }

    @Override
    public boolean create(ServiceCreateUpdateRequest request) {
        ServiceModel serviceModel = new ServiceModel();

        serviceModel.setPrice(request.getPrice());
        serviceModel.setServiceNo(request.getServiceNo());
        serviceModel.setServiceName(request.getServiceName());
        serviceModel.setTimeUsed(request.getTimeUsed());

        serviceRepository.save(serviceModel);
        return true;
    }

    @Override
    public boolean update(UUID id, ServiceCreateUpdateRequest request) {
        Optional<ServiceModel> serviceModelOptional = serviceRepository.findById(id);

        if (serviceModelOptional.isEmpty()) return false;

        ServiceModel serviceModel = serviceModelOptional.get();
        serviceModel.setPrice(request.getPrice());
        serviceModel.setServiceNo(request.getServiceNo());
        serviceModel.setServiceName(request.getServiceName());
        serviceModel.setTimeUsed(request.getTimeUsed());

        serviceRepository.save(serviceModel);
        return true;
    }

    @Override
    public boolean delete(UUID id) {
        serviceRepository.deleteById(id);
        return true;
    }
}
