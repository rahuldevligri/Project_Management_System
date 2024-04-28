package com.projectManagement.system.validators;

import com.projectManagement.system.model.Project;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProjectValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Project.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Project project = (Project) target;

        // Validate name
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "project.name.required");
        if (!StringUtils.hasLength(project.getName()) || project.getName().length() > 100) {
            errors.rejectValue("name", "project.name.invalid");
        }

        // Validate description (optional)
        if (project.getDescription() != null && project.getDescription().length() > 255) {
            errors.rejectValue("description", "project.description.invalid");
        }

        // Validate start date
        if (project.getStartDate() == null) {
            errors.rejectValue("startDate", "project.startDate.required");
        } else if (project.getStartDate().isAfter(project.getEndDate())) {
            errors.rejectValue("startDate", "project.startDate.invalid");
        }

        // Validate end date
        if (project.getEndDate() == null) {
            errors.rejectValue("endDate", "project.endDate.required");
        } else if (project.getEndDate().isBefore(project.getStartDate())) {
            errors.rejectValue("endDate", "project.endDate.invalid");
        }
    }
}
