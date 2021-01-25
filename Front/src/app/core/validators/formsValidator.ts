import { FormGroup } from "@angular/forms";

export class FormsValidator {

    static cepValidator(formGroup: FormGroup) {
        const cep = formGroup.value;

        if(cep && cep !== '') {
            const validacep = /^[0-9]{8}$/;
            return validacep.test(cep) ? null : { cepInvalido : true }
        }
        return null
    }


}

