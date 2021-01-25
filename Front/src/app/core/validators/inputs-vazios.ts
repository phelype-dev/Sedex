import { Directive, Input } from '@angular/core';
import { NG_VALIDATORS, Validator, FormControl } from '@angular/forms';
import { Key } from 'readline';

export class ValidatorsInputs{
    @Input()
    input = null;

}