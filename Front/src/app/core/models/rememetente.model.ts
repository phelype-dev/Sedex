import { EmpresaModel } from "./empresa.model";

export class RemetenteModel {

	rem_codigo: number;

	rem_remetente: String;

	rem_abreviado: String;

	rem_fixo: String;

	rem_movel: String;

	emp_codigo: EmpresaModel;

  rem_ativo: Boolean;

}
