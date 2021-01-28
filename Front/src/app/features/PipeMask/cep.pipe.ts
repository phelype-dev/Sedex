import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'cEP'
})
export class CEPPipe implements PipeTransform {

  transform(value: String, ...args: any[]): any {
    if (value.length <= 8) {
      return value.replace(/(\d{5})(\d{3})/g, '\$1.\$2');
    } else {
      return value = '';
    }
    return null;
  }

}
