package DTO;

public class GrupoDTO {
        private String nomeGrupo;
        private int idGrupo;

    public GrupoDTO() {
        this.idGrupo = idGrupo;
        this.nomeGrupo = nomeGrupo;
    }
    
    public String getNomeGrupo() {
        return nomeGrupo;
    }

    public void setNomeGrupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    @Override
    public String toString(){
        return "GrupoDTO [ idGrupo = "+ idGrupo + ", nomeGrupo = "+ nomeGrupo;
    }

}
