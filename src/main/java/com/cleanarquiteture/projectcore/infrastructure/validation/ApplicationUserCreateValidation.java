package com.cleanarquiteture.projectcore.infrastructure.validation;

import br.com.fluentvalidator.AbstractValidator;
import com.cleanarquiteture.projectcore.domain.dto.ApplicationUserCreateDTO;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

import static br.com.fluentvalidator.predicate.StringPredicate.*;

@Component
public class ApplicationUserCreateValidation extends AbstractValidator<ApplicationUserCreateDTO> {
    @Override
    public void rules() {
        ruleFor(ApplicationUserCreateDTO::getName)
                .must(Predicate.not(stringEmptyOrNull()))
                .when(stringSizeGreaterThan(2))
                .withMessage("Name must be not null, empty or less than 2.")
                .withFieldName("Name");
    }
}
