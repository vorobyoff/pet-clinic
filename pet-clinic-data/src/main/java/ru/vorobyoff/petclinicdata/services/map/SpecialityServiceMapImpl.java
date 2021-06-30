package ru.vorobyoff.petclinicdata.services.map;

import org.springframework.stereotype.Service;
import ru.vorobyoff.petclinicdata.models.map.Speciality;
import ru.vorobyoff.petclinicdata.services.map.base.AbstractMapService;
import ru.vorobyoff.petclinicdata.services.map.base.SpecialityService;

import java.util.Collection;
import java.util.Optional;

@Service
public class SpecialityServiceMapImpl extends AbstractMapService<Speciality, Long> implements SpecialityService {

    @Override
    public Collection<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public Optional<Speciality> findById(final Long id) {
        return super.findById(id);
    }

    @Override
    public void delete(final Speciality obj) {
        super.delete(obj);
    }

    @Override
    public void deleteById(final Long id) {
        super.deleteById(id);
    }

    @Override
    public Speciality save(final Speciality obj) {
        return super.save(obj);
    }
}