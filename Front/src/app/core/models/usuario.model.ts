import { PessoaModel } from "./pessoa.model";

export class UsuarioModel {

    idUsuario: number;
    idPessoa: PessoaModel;
    nomeLogin: String;
    password: String;
    status: boolean;
    dateCadastro: Date;
    cargo: number;
}