import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'fixo'
})
export class FixoPipe implements PipeTransform {

  transform(value: String, ...args: any[]): any {
    if (value.length <= 13) {
      return value.replace(/(\d{2})(\d{4})(\d{4})/g, '\($1) \$2-\$3');
    } else {
      return value = '';
    }
    return null;
  }

}
