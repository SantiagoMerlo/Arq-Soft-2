package ar.edu.ucc.arqsoft.test.model;

public enum Operacion {
    DEBITO("DEBITO"),CREDITO("CREDITO");

    private String label;

    public String getLabel() {
        return label;
    }

    private Operacion(String label) {
        this.label = label;
    }
}
