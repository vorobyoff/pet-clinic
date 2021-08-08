package ru.vorobyoff.petclinicweb.formatters;

import lombok.RequiredArgsConstructor;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import ru.vorobyoff.petclinicdata.models.PetType;
import ru.vorobyoff.petclinicdata.services.base.PetTypeService;

import java.text.ParseException;
import java.util.Locale;

import static org.thymeleaf.util.StringUtils.capitalize;

@Component
@RequiredArgsConstructor
public final class PetTypeFormatter implements Formatter<PetType> {

    private final PetTypeService petTypeService;

    @Override
    public PetType parse(final String text, final Locale locale) throws ParseException {
        return petTypeService.findAll().stream()
                .filter(petType -> petType.getName().equalsIgnoreCase(text))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("PetType with the given text does noe exists."));
    }

    @Override
    public String print(final PetType type, final Locale locale) {
        return capitalize(type.getName());
    }
}