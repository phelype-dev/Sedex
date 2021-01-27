import { RegSedexModel } from './../../core/models/regSedexModel';
import { RegsedexService } from './../../core/services/regsedex.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-etiqueta',
  templateUrl: './etiqueta.component.html',
  styleUrls: ['./etiqueta.component.css']
})
export class EtiquetaComponent implements OnInit {

  reg: RegSedexModel

  constructor(private regSedexService: RegsedexService) { }

  ngOnInit(): void {
  }

  printPage() {
    window.print();
  }

  pegaId(id: any) {
    this.regSedexService.buscaPorId(id).subscribe(data => {
      this.reg = data;
    });
  }

}
