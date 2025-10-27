public class AcessaBanco{  
    	private String login;  	
        private boolean conectado; 

        public String getLogin() {
            return login;
        }
        public void setLogin(String login) {
            this.login = login;
        }
        
        public void setConectado(boolean conectado) {
            this.conectado = conectado;
        }
        public boolean getConectado() {
            return conectado;
        }
} 
