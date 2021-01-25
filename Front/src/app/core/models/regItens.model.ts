import { tipoEquipamentoModel } from './tipoEquipamento.model';
import { TipoItemModel } from './tipoItem.model';
import { RegSedexModel } from './regSedexModel';
export class RegItens {

  ips_codigo: number;
  sed_codigo: RegSedexModel;
  tit_codigo: TipoItemModel;
  ips_descricao: String;
  equ_codigo: tipoEquipamentoModel;
  ips_codigo_equip: number;
  ips_cod_ra: number;

}
