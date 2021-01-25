export class AtividadeModel{

    constructor( idAtividade: number, nomeAtividade: String ,descricaoAtividade: String, dataInicio: Date,
        dataTermino: Date, status: boolean){
            this.idAtividade = idAtividade;
            this.nomeAtividade = nomeAtividade;
            this.descricaoAtividade = descricaoAtividade;
            this.dataInicio = dataInicio;
            this.dataTermino = dataTermino;
            this.status = status;
        }

    idAtividade: number;
    nomeAtividade: String;
    descricaoAtividade: String;
    dataInicio: Date;
    dataTermino: Date;
    status: boolean;
}