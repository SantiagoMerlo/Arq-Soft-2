package ar.edu.ucc.arqsoft.test.dto;

public class ResponseAutorizacionDto {
        private String codigo;

        private String estado;

        private String autorizacion;

    public ResponseAutorizacionDto(String codigo, String estado, String autorizacion) {
        this.codigo = codigo;
        this.estado = estado;
        this.autorizacion = autorizacion;
    }

    public String getCodigo() {
            return codigo;
        }

        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public String getAutorizacion() {
            return autorizacion;
        }

        public void setAutorizacion(String autorizacion) {
            this.autorizacion = autorizacion;
        }

        @Override
        public String toString() {
            return "ResponseAutorizacionDto [codigo=" + codigo + ", estado=" + estado + ", autorizacion=" + autorizacion
                    + "]";
        }
}
