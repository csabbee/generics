package typesystem.wildcardsbounds.enums;

// decompile with JAD
public enum Department {
	JAVA(true){

        @Override
        public void printLanguages() {
           System.out.println("Java, Groovy, Clojure, Scala");
        }
	    
	}, DOTNET(false){

        @Override
        public void printLanguages() {
            System.out.println("C#, F#");
        }
	    
	}, ENGINEERING_SERVICES(true){

        @Override
        public void printLanguages() {
            System.out.println("ant, maven");
        }
	    
	};
	private boolean great;
	
	private Department(boolean great){
	    this.great = great;
	}
	
	public abstract void printLanguages();
}
