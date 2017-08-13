package exceptions;

class ConstructionException extends Exception {
}

class FailingConstructor {
	public FailingConstructor(boolean fail) throws ConstructionException{
		if(fail) throw new ConstructionException();
	}
}

class E12_FailingConstructor{
	public static void main(String[] args) {
		for(boolean b = false;;b=!b) {
			try {
				System.out.println("Constructing...");
				new FailingConstructor(b);					
				try {
					System.out.println("Processing...");
				}finally {
					System.out.println("Clean up...");
				}
			}catch (ConstructionException e) {
				System.out.println("Construction has failed: " + e);
				break;
			}
		}
	}
}
