import { Pipe, PipeTransform } from "@angular/core";

@Pipe({
  name: 'BarCode'
})
export class CEPPipe implements PipeTransform {

  generateBarcodeSequence(barcode) {
    let barcodeSequence = "";

    if (barcode.length > 0 &&
      barcode.length % 2 === 0) {
      for (let index = 0; index < barcode.length; index = index + 2) {

        let item = Number(barcode.substr(index, 2));
        let charCode;

        if (item <= 49) {
          charCode = item + 48;
        }
        else {
          charCode = item + 142;
        }
        barcodeSequence = barcodeSequence + String.fromCharCode(charCode);
      }
      barcodeSequence = "(" + barcodeSequence + ")";
    }
    return barcodeSequence;
  }

}
