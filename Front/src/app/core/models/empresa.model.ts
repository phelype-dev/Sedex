import { CidadeModel } from "./Cidade.model";
import { EstadoModel } from "./Estado.model";
import { TipoEmpresaModel } from "./tipo-empresa.model";

export class EmpresaModel {

	emp_codigo: number;
	emp_cnpj: String;
	emp_razao_social: String;
	emp_operacoa: String;
	emp_descricao: String;
	emp_logradouro: String;
	emp_numero: number;
	emp_complemento: String;
	emp_bairro: String;
	emp_cidade: CidadeModel;
	emp_estado: EstadoModel;
	emp_cep: String;
	emp_fixo: String;
	tem_codigo: TipoEmpresaModel;
}
