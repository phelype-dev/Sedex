import { DestinatarioModel } from './destinatario.model';
import { CidadeModel } from "./Cidade.model";
import { EmpresaModel } from "./empresa.model";
import { EstadoModel } from "./Estado.model";
import { RemetenteModel } from "./rememetente.model";

export class RegSedexModel {

  sed_codigo: number;

  sed_data_postagem: Date;

  emp_codigo: EmpresaModel = new EmpresaModel();

  rem_codigo: RemetenteModel = new RemetenteModel;

  cid_codigo: CidadeModel = new CidadeModel;

  est_codigo: EstadoModel = new EstadoModel;

  des_codigo: DestinatarioModel = new DestinatarioModel;

  sed_codigo_rastreio: String;

  sed_valor: Float32List;

  sed_pago: boolean;

  sed_extraviou: boolean;

  sed_operador: String;

  sed_data_modificacao: Date;
}
