import { CidadeModel } from "./Cidade.model";
import { EmpresaModel } from "./empresa.model";
import { EstadoModel } from "./Estado.model";

export class DestinatarioModel {
 
 des_codigo: number;
 des_destinatario: String;
 des_aos_cuidados: String;
 des_aos_cuidados_abrev: String;
 des_cpf: String;
 des_logradouro: String;
 des_numero: number;
 des_complemento: String;
 des_bairro: String;
 cid_cidade: CidadeModel;
 est_estado: EstadoModel;
 des_cep: String;
 des_fixo: String;
 des_movel: String;
 des_transpotadora: EmpresaModel;
 des_ativo: boolean;
 des_data_alteracao: Date;
 des_latitude: String;
 des_longitude: String;

}