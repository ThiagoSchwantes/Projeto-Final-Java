package br.edu.up.models;

public class Equipamento {

    private Integer equipamentoId;
    private String nomeEquipamento;
    private String descricao;
    
    public Equipamento(Integer equipamentoId, String nomeEquipamento, String descricao) {
        this.equipamentoId = equipamentoId;
        this.nomeEquipamento = nomeEquipamento;
        this.descricao = descricao;
    }

    public Equipamento(String nomeEquipamento, String descricao) {
        this.nomeEquipamento = nomeEquipamento;
        this.descricao = descricao;
    }

    public Integer getEquipamentoId() {
        return equipamentoId;
    }

    public void setEquipamentoId(Integer equipamentoId) {
        this.equipamentoId = equipamentoId;
    }

    public String getNomeEquipamento() {
        return nomeEquipamento;
    }

    public void setNomeEquipamento(String nomeEquipamento) {
        this.nomeEquipamento = nomeEquipamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String toStringBasico(){
        return "Acabamento [Id=" +  equipamentoId + "  nome=" + nomeEquipamento + "]";
    }

    @Override
    public String toString() {
        return "Equipamento [equipamentoId=" + equipamentoId + ", nomeEquipamento=" + nomeEquipamento + ", descricao="
                + descricao + "]";
    }

    public String toCSV(){
        return equipamentoId + ";" + nomeEquipamento + ";" + descricao;
    }
}
