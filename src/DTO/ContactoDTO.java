package DTO;

public class ContactoDTO {
 private String nomeContact;
        private int telefono;
        private String email;
        private int idContact;
        public String getNomeContact() {
            return nomeContact;
        }
        public void setNomeContact(String nomeContact) {
            this.nomeContact = nomeContact;
        }
        public int getTelefono() {
            return telefono;
        }
        public void setTelefono(int telefono) {
            this.telefono = telefono;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public int getIdContact() {
            return idContact;
        }
        public void setIdContact(int idContact) {
            this.idContact = idContact;
        }
        
        @Override
        public String toString(){
            return "ContactoDTO [IdContacto= " + idContact + ", nomeContacto = "+ nomeContact + ", tlfn = " + telefono + ", email = "+ email;
        }
}


