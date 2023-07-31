package com.cleanarquiteture.projectcore.infrastructure.validation;

import br.com.fluentvalidator.AbstractValidator;
import com.cleanarquiteture.projectcore.domain.dto.ApplicationUserCreateDTO;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

import static br.com.fluentvalidator.predicate.StringPredicate.stringContains;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;
@Component
public class ApplicationUserCreateValidation extends AbstractValidator<ApplicationUserCreateDTO> {
    @Override
    public void rules() {
        ruleFor(ApplicationUserCreateDTO::getName)
                .must(stringContains("Jùlio"))
                .when(Predicate.not(stringEmptyOrNull()))
                .withMessage("Name must contains key Júlio");
    }
}
